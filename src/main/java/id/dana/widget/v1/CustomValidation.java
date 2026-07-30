package id.dana.widget.v1;

import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DateValidation;
import id.dana.widget.v1.model.ApplyTokenAuthorizationCodeRequest;
import id.dana.widget.v1.model.ApplyTokenRefreshTokenRequest;
import id.dana.widget.v1.model.EnvInfo;
import id.dana.widget.v1.model.Money;
import id.dana.widget.v1.model.WidgetPaymentRequest;
import id.dana.widget.v1.model.WidgetPaymentRequestAdditionalInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * CustomValidation for Widget API: registry, aggregated {@link DanaException} contexts, and validators.
 */
public final class CustomValidation {

  /** Sandbox maximum amount (major units) for Widget payment. */
  private static final double SANDBOX_MAX_AMOUNT = 10000000d;

  private CustomValidation() {}

  private static final Map<String, List<Consumer<Object>>> validationRegistry = new HashMap<>();

  static {
    List<Consumer<Object>> w = new ArrayList<>();
    w.add(CustomValidation::defaultSourcePlatform);
    w.add(CustomValidation::validateRequiredAdditionalInfoFieldsNotEmpty);
    w.add(CustomValidation::validateSandboxAmount);
    w.add(CustomValidation::validateValidUpToWidgetPaymentRequest);
    validationRegistry.put("WidgetPaymentRequest", w);

    List<Consumer<Object>> authCode = new ArrayList<>();
    authCode.add(CustomValidation::validateApplyTokenAuthCodeAuthorizationCode);
    validationRegistry.put("ApplyTokenAuthorizationCodeRequest", authCode);

    List<Consumer<Object>> refresh = new ArrayList<>();
    refresh.add(CustomValidation::validateApplyTokenAuthCodeRefreshToken);
    validationRegistry.put("ApplyTokenRefreshTokenRequest", refresh);
  }

  public static void customValidation(Object request) {
    if (request == null) {
      return;
    }
    String className = request.getClass().getSimpleName();
    List<Consumer<Object>> validators = validationRegistry.get(className);
    if (validators == null) {
      return;
    }
    List<Map<String, String>> aggregated = new ArrayList<>();
    for (Consumer<Object> validator : validators) {
      try {
        validator.accept(request);
      } catch (DanaException e) {
        mergeDanaException(aggregated, e);
      }
    }
    if (!aggregated.isEmpty()) {
      throw new DanaException(aggregated);
    }
  }

  private static void mergeDanaException(List<Map<String, String>> aggregated, DanaException e) {
    if (e.getValidationContexts() != null && !e.getValidationContexts().isEmpty()) {
      aggregated.addAll(e.getValidationContexts());
    } else if (e.getMessage() != null) {
      aggregated.add(ctx("validation", e.getMessage()));
    }
  }

  private static Map<String, String> ctx(String field, String message) {
    Map<String, String> m = new LinkedHashMap<>();
    m.put("field", field);
    m.put("message", message);
    return m;
  }

  private static String trimStr(String s) {
    return s == null ? "" : s.trim();
  }

  /**
   * Sets {@code envInfo.sourcePlatform} to {@link EnvInfo.SourcePlatformEnum#IPG} when null or empty.
   */
  private static void defaultSourcePlatform(Object request) {
    if (!(request instanceof WidgetPaymentRequest)) {
      return;
    }
    WidgetPaymentRequestAdditionalInfo info =
        ((WidgetPaymentRequest) request).getAdditionalInfo();
    if (info == null || info.getEnvInfo() == null) {
      return;
    }
    EnvInfo envInfo = info.getEnvInfo();
    EnvInfo.SourcePlatformEnum sourcePlatform = envInfo.getSourcePlatform();
    if (sourcePlatform == null
        || EnvInfo.SourcePlatformEnum.UNSPECIFIED.equals(sourcePlatform)
        || trimStr(sourcePlatform.getValue()).isEmpty()) {
      envInfo.setSourcePlatform(EnvInfo.SourcePlatformEnum.IPG);
    }
  }

  /**
   * Rejects blank required additionalInfo fields ({@code productCode},
   * {@code envInfo.terminalType}). Note: {@code mcc} may be an empty string for Widget.
   */
  private static void validateRequiredAdditionalInfoFieldsNotEmpty(Object request) {
    if (!(request instanceof WidgetPaymentRequest)) {
      return;
    }
    WidgetPaymentRequestAdditionalInfo info =
        ((WidgetPaymentRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    List<Map<String, String>> contexts = new ArrayList<>();
    if (trimStr(info.getProductCode()).isEmpty()) {
      contexts.add(ctx("additionalInfo.productCode",
          "additionalInfo.productCode is required and cannot be empty"));
    }
    EnvInfo envInfo = info.getEnvInfo();
    EnvInfo.TerminalTypeEnum terminalType = envInfo != null ? envInfo.getTerminalType() : null;
    if (terminalType == null || trimStr(terminalType.getValue()).isEmpty()) {
      contexts.add(ctx("additionalInfo.envInfo.terminalType",
          "additionalInfo.envInfo.terminalType is required and cannot be empty"));
    }
    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
  }

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

  /** In sandbox, amount.value must not exceed {@link #SANDBOX_MAX_AMOUNT}. */
  private static void validateSandboxAmount(Object request) {
    if (!(request instanceof WidgetPaymentRequest) || !isSandbox()) {
      return;
    }
    Money amount = ((WidgetPaymentRequest) request).getAmount();
    if (amount == null) {
      return;
    }
    String value = amount.getValue();
    if (value == null || value.trim().isEmpty()) {
      return;
    }
    try {
      double parsed = Double.parseDouble(value.trim());
      if (parsed > SANDBOX_MAX_AMOUNT) {
        throw new DanaException(Collections.singletonList(ctx(
            "amount.value",
            "in sandbox, amount.value must not exceed " + (long) SANDBOX_MAX_AMOUNT + "; got " + value)));
      }
    } catch (NumberFormatException ignored) {
      // format is validated elsewhere
    }
  }

  private static void validateValidUpToWidgetPaymentRequest(Object request) {
    if (!(request instanceof WidgetPaymentRequest)) {
      return;
    }
    WidgetPaymentRequest r = (WidgetPaymentRequest) request;
    if (r.getValidUpTo() != null) {
      try {
        DateValidation.validateValidUpToDate(r.getValidUpTo());
      } catch (IllegalArgumentException e) {
        throw new DanaException(Collections.singletonList(
            ctx("validUpTo", "validUpTo validation failed: " + e.getMessage())));
      }
    }
  }

  private static boolean containsForbiddenAuthCodeDelimiters(String authCode) {
    return authCode.indexOf('&') >= 0 || authCode.indexOf('=') >= 0;
  }

  private static void validateApplyTokenAuthCodeAuthorizationCode(Object request) {
    if (!(request instanceof ApplyTokenAuthorizationCodeRequest)) {
      return;
    }
    ApplyTokenAuthorizationCodeRequest r = (ApplyTokenAuthorizationCodeRequest) request;
    String authCode = r.getAuthCode();
    if (authCode != null && !authCode.isEmpty()
        && containsForbiddenAuthCodeDelimiters(authCode)) {
      throw new DanaException(Collections.singletonList(ctx("authCode",
          "authCode must not contain URL query delimiter characters ('&' or '=')")));
    }
  }

  private static void validateApplyTokenAuthCodeRefreshToken(Object request) {
    if (!(request instanceof ApplyTokenRefreshTokenRequest)) {
      return;
    }
    ApplyTokenRefreshTokenRequest r = (ApplyTokenRefreshTokenRequest) request;
    String authCode = r.getAuthCode();
    if (authCode == null) {
      return;
    }
    String trimmed = authCode.trim();
    if (trimmed.isEmpty()) {
      return;
    }
    if (containsForbiddenAuthCodeDelimiters(trimmed)) {
      throw new DanaException(Collections.singletonList(ctx("authCode",
          "authCode must not contain URL query delimiter characters ('&' or '=')")));
    }
  }
}
