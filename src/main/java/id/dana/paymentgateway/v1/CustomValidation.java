package id.dana.paymentgateway.v1;

import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DateValidation;
import id.dana.paymentgateway.v1.model.CreateOrderByApiRequest;
import id.dana.paymentgateway.v1.model.CreateOrderByRedirectRequest;
import id.dana.paymentgateway.v1.model.Money;
import id.dana.paymentgateway.v1.model.PayOptionDetail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * CustomValidation
 * 
 * This class provides custom validation functions for Payment Gateway API requests.
 * Validations are registered in the validationRegistry and executed via customValidation().
 */
public final class CustomValidation {

  /** Money value pattern: digits (1-16) + "." + exactly 2 digits (e.g. 10000.00) */
  private static final Pattern MONEY_VALUE_PATTERN = Pattern.compile("^\\d{1,16}\\.\\d{2}$");

  private CustomValidation() {
    // Utility class - prevent instantiation
  }

  /**
   * Validation registry maps request class names to their validation functions
   */
  private static final Map<String, List<Consumer<Object>>> validationRegistry = new HashMap<>();

  static {
    // Register validators for CreateOrderByApiRequest
    List<Consumer<Object>> createOrderByApiValidators = new ArrayList<>();
    createOrderByApiValidators.add(CustomValidation::validateAdditionalInfoRequired);
    createOrderByApiValidators.add(CustomValidation::validateMoneyValuePattern);
    createOrderByApiValidators.add(CustomValidation::validateValidUpToCreateOrderRequest);
    createOrderByApiValidators.add(CustomValidation::validateExternalStoreIdForQris);
    createOrderByApiValidators.add(CustomValidation::validateSandboxPayMethodAndPayOption);
    validationRegistry.put("CreateOrderByApiRequest", createOrderByApiValidators);

    // Register validators for CreateOrderByRedirectRequest
    List<Consumer<Object>> createOrderByRedirectValidators = new ArrayList<>();
    createOrderByRedirectValidators.add(CustomValidation::validateAdditionalInfoRequired);
    createOrderByRedirectValidators.add(CustomValidation::validateMoneyValuePattern);
    createOrderByRedirectValidators.add(CustomValidation::validateValidUpToCreateOrderRequest);
    createOrderByRedirectValidators.add(CustomValidation::validateSandboxPayMethodAndPayOption);
    validationRegistry.put("CreateOrderByRedirectRequest", createOrderByRedirectValidators);
  }

  /**
   * Perform custom validations on the request based on its type
   *
   * This method checks the request type and runs the appropriate validations from the registry.
   *
   * @param request The request object to validate (can be any type)
   * @throws DanaException if validation fails
   */
  public static void customValidation(Object request) {
    if (request == null) {
      return;
    }

    // Get the class name of the request
    String className = request.getClass().getSimpleName();

    // Check if this request type has validations registered
    List<Consumer<Object>> validators = validationRegistry.get(className);
    if (validators != null) {
      for (Consumer<Object> validator : validators) {
        validator.accept(request);
      }
    }
  }

  /**
   * Validate that additionalInfo must exist.
   *
   * @param request The request object to validate
   * @throws DanaException if validation fails
   */
  private static void validateAdditionalInfoRequired(Object request) {
    if (request == null) {
      return;
    }
    if (request instanceof CreateOrderByApiRequest) {
      if (((CreateOrderByApiRequest) request).getAdditionalInfo() == null) {
        throw new DanaException("additionalInfo is required");
      }
    } else if (request instanceof CreateOrderByRedirectRequest) {
      if (((CreateOrderByRedirectRequest) request).getAdditionalInfo() == null) {
        throw new DanaException("additionalInfo is required");
      }
    }
  }

  /**
   * Validate that Money value matches pattern (e.g. 10000.00): ^\d{1,16}\.\d{2}$
   *
   * @param request The request object to validate
   * @throws DanaException if validation fails
   */
  private static void validateMoneyValuePattern(Object request) {
    if (request == null) {
      return;
    }
    Money amount = null;
    if (request instanceof CreateOrderByApiRequest) {
      amount = ((CreateOrderByApiRequest) request).getAmount();
    } else if (request instanceof CreateOrderByRedirectRequest) {
      amount = ((CreateOrderByRedirectRequest) request).getAmount();
    }
    if (amount == null) {
      return;
    }
    String value = amount.getValue();
    if (value == null || value.isEmpty()) {
      throw new DanaException("amount.value is required");
    }
    if (!MONEY_VALUE_PATTERN.matcher(value).matches()) {
      throw new DanaException("amount.value must match pattern (e.g. 10000.00): got " + value);
    }
  }

  /**
   * Validate validUpTo field in CreateOrderByApiRequest or CreateOrderByRedirectRequest.
   *
   * This function handles both request types directly (not wrapped in CreateOrderRequest):
   * - CreateOrderByApiRequest: validates validUpTo directly
   * - CreateOrderByRedirectRequest: validates validUpTo directly
   *
   * @param request The request object to validate
   * @throws DanaException if validation fails
   */
  private static void validateValidUpToCreateOrderRequest(Object request) {
    if (request == null) {
      return;
    }

    String validUpTo = null;
    if (request instanceof CreateOrderByApiRequest) {
      validUpTo = ((CreateOrderByApiRequest) request).getValidUpTo();
    } else if (request instanceof CreateOrderByRedirectRequest) {
      validUpTo = ((CreateOrderByRedirectRequest) request).getValidUpTo();
    }

    if (validUpTo != null) {
      try {
        DateValidation.validateValidUpToDate(validUpTo);
      } catch (IllegalArgumentException e) {
        throw new DanaException("validUpTo validation failed: " + e.getMessage());
      }
    }
  }

  /**
   * Validate that externalStoreId is required when payOption is NETWORK_PAY_PG_QRIS.
   *
   * This function checks if any payOption in payOptionDetails is NETWORK_PAY_PG_QRIS,
   * and if so, ensures externalStoreId is provided.
   *
   * @param request The request object to validate
   * @throws DanaException if validation fails
   */
  private static void validateExternalStoreIdForQris(Object request) {
    if (request == null) {
      return;
    }

    if (!(request instanceof CreateOrderByApiRequest)) {
      return;
    }

    CreateOrderByApiRequest apiRequest = (CreateOrderByApiRequest) request;
    java.util.List<?> payOptionDetails = apiRequest.getPayOptionDetails();
    String externalStoreId = apiRequest.getExternalStoreId();

    if (payOptionDetails == null || payOptionDetails.isEmpty()) {
      return;
    }

    // Check if any payOption is NETWORK_PAY_PG_QRIS
    boolean hasQris = false;
    for (Object payOptionDetail : payOptionDetails) {
      if (payOptionDetail != null) {
        try {
          java.lang.reflect.Method getPayOptionMethod = payOptionDetail.getClass().getMethod("getPayOption");
          Object payOption = getPayOptionMethod.invoke(payOptionDetail);
          // Handle enum or string
          String payOptionStr = null;
          if (payOption instanceof PayOptionDetail.PayOptionEnum) {
            payOptionStr = ((PayOptionDetail.PayOptionEnum) payOption).getValue();
          } else if (payOption instanceof java.lang.Enum) {
            payOptionStr = ((java.lang.Enum<?>) payOption).name();
          } else if (payOption instanceof String) {
            payOptionStr = (String) payOption;
          }
          if (PayOptionDetail.PayOptionEnum.NETWORK_PAY_PG_QRIS.getValue().equals(payOptionStr)) {
            hasQris = true;
            break;
          }
        } catch (Exception e) {
          // Skip if we can't access payOption
          continue;
        }
      }
    }

    // If QRIS is found, externalStoreId must be provided
    if (hasQris) {
      if (externalStoreId == null || externalStoreId.trim().isEmpty()) {
        throw new DanaException("externalStoreId is required when payOption is NETWORK_PAY_PG_QRIS");
      }
    }
  }

  /** In sandbox, only these payMethods are available (Payment Gateway). */
  private static final Set<String> SANDBOX_ALLOWED_PAY_METHODS = Collections.unmodifiableSet(new HashSet<>(
      Arrays.asList("BALANCE", "CREDIT_CARD", "DEBIT_CARD", "VIRTUAL_ACCOUNT", "NETWORK_PAY")));

  /** In sandbox, only these payOptions are available (exact or suffix e.g. VIRTUAL_ACCOUNT_BRI). */
  private static final Set<String> SANDBOX_ALLOWED_PAY_OPTIONS = Collections.unmodifiableSet(new HashSet<>(
      Arrays.asList("CARD", "QRIS", "BRI", "PANIN", "CIMB", "MANDIRI", "BTPN")));

  private static boolean isSandbox() {
    String env = System.getenv("DANA_ENV");
    if (env == null || env.isEmpty()) {
      env = System.getenv("ENV");
    }
    if (env == null || env.isEmpty()) {
      env = "sandbox";
    }
    return "sandbox".equalsIgnoreCase(env);
  }

  private static boolean payOptionAllowedInSandbox(String value) {
    if (value == null || value.trim().isEmpty()) {
      return false;
    }
    String s = value.trim();
    if (SANDBOX_ALLOWED_PAY_OPTIONS.contains(s)) {
      return true;
    }
    for (String opt : SANDBOX_ALLOWED_PAY_OPTIONS) {
      if (s.endsWith("_" + opt)) {
        return true;
      }
    }
    return false;
  }

  /**
   * In sandbox, only certain payMethod and payOption values are available.
   * Skipped when not in sandbox.
   */
  private static void validateSandboxPayMethodAndPayOption(Object request) {
    if (request == null || !isSandbox()) {
      return;
    }
    if (!(request instanceof CreateOrderByApiRequest)) {
      return;
    }
    List<?> payOptionDetails = ((CreateOrderByApiRequest) request).getPayOptionDetails();
    if (payOptionDetails == null || payOptionDetails.isEmpty()) {
      return;
    }
    for (int idx = 0; idx < payOptionDetails.size(); idx++) {
      Object detail = payOptionDetails.get(idx);
      if (detail == null) {
        continue;
      }
      try {
        String payMethodStr = getPayMethodString(detail);
        if (payMethodStr != null && !payMethodStr.isEmpty() && !SANDBOX_ALLOWED_PAY_METHODS.contains(payMethodStr.trim())) {
          throw new DanaException(
              "In sandbox, payMethod must be one of " + SANDBOX_ALLOWED_PAY_METHODS + "; got " + payMethodStr + " in payOptionDetails[" + idx + "]");
        }
        String payOptionStr = getPayOptionString(detail);
        if (payOptionStr != null && !payOptionStr.isEmpty() && !payOptionAllowedInSandbox(payOptionStr)) {
          throw new DanaException(
              "In sandbox, payOption must be one of " + SANDBOX_ALLOWED_PAY_OPTIONS + " (or suffix like VIRTUAL_ACCOUNT_BRI); got " + payOptionStr + " in payOptionDetails[" + idx + "]");
        }
      } catch (DanaException e) {
        throw e;
      } catch (Exception e) {
        // Skip if we cannot access fields
      }
    }
  }

  private static String getPayMethodString(Object payOptionDetail) {
    try {
      java.lang.reflect.Method m = payOptionDetail.getClass().getMethod("getPayMethod");
      Object v = m.invoke(payOptionDetail);
      if (v == null) return null;
      if (v instanceof Enum) return ((Enum<?>) v).name();
      if (v instanceof String) return (String) v;
      return String.valueOf(v);
    } catch (Exception e) {
      return null;
    }
  }

  private static String getPayOptionString(Object payOptionDetail) {
    try {
      java.lang.reflect.Method m = payOptionDetail.getClass().getMethod("getPayOption");
      Object v = m.invoke(payOptionDetail);
      if (v == null) return null;
      if (v instanceof PayOptionDetail.PayOptionEnum) return ((PayOptionDetail.PayOptionEnum) v).getValue();
      if (v instanceof Enum) return ((Enum<?>) v).name();
      if (v instanceof String) return (String) v;
      return String.valueOf(v);
    } catch (Exception e) {
      return null;
    }
  }
}
