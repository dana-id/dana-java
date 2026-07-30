package id.dana.paymentgateway.v1;

import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DateValidation;
import id.dana.paymentgateway.v1.model.Buyer;
import id.dana.paymentgateway.v1.model.CreateOrderByApiRequest;
import id.dana.paymentgateway.v1.model.CreateOrderByRedirectAdditionalInfo;
import id.dana.paymentgateway.v1.model.CreateOrderByRedirectRequest;
import id.dana.paymentgateway.v1.model.CreateOrderResponse;
import id.dana.paymentgateway.v1.model.CreateOrderByApiAdditionalInfo;
import id.dana.paymentgateway.v1.model.EnvInfo;
import id.dana.paymentgateway.v1.model.Goods;
import id.dana.paymentgateway.v1.model.Money;
import id.dana.paymentgateway.v1.model.OrderApiObject;
import id.dana.paymentgateway.v1.model.OrderRedirectObject;
import id.dana.paymentgateway.v1.model.PayOptionAdditionalInfo;
import id.dana.paymentgateway.v1.model.PayOptionDetail;
import id.dana.paymentgateway.v1.model.ShippingInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * CustomValidation
 *
 * <p>Validations are registered in the validationRegistry and executed via {@link #customValidation(Object)} with
 * aggregated {@link DanaException} contexts (field/message pairs).
 */
public final class CustomValidation {

  /** Money value pattern: digits (1-16) + "." + exactly 2 digits (e.g. 10000.00) */
  private static final Pattern MONEY_VALUE_PATTERN = Pattern.compile("^\\d{1,16}\\.\\d{2}$");

  /** Sandbox maximum amount (major units) for Payment Gateway create order. */
  private static final double SANDBOX_MAX_AMOUNT = 10000000d;

  private static final String NETWORK_PAY_PG_CARD = "NETWORK_PAY_PG_CARD";

  private static final Set<String> CREDIT_DEBIT_CARD_PAY_METHODS =
      Collections.unmodifiableSet(new HashSet<>(Arrays.asList("CREDIT_CARD", "DEBIT_CARD")));

  private static final Set<String> EWALLET_PAY_OPTIONS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
      "NETWORK_PAY_PG_SPAY",
      "NETWORK_PAY_PG_OVO",
      "NETWORK_PAY_PG_GOPAY",
      "NETWORK_PAY_PG_LINKAJA")));

  private CustomValidation() {}

  private static final Map<String, List<Consumer<Object>>> validationRegistry = new HashMap<>();

  static {
    List<Consumer<Object>> createOrderByApiValidators = new ArrayList<>();
    createOrderByApiValidators.add(CustomValidation::defaultSourcePlatform);
    createOrderByApiValidators.add(CustomValidation::validateAdditionalInfoRequired);
    createOrderByApiValidators.add(CustomValidation::validateRequiredAdditionalInfoFieldsNotEmpty);
    createOrderByApiValidators.add(CustomValidation::validateMoneyValuePattern);
    createOrderByApiValidators.add(CustomValidation::validateSandboxAmount);
    createOrderByApiValidators.add(CustomValidation::validateValidUpToCreateOrderRequest);
    createOrderByApiValidators.add(CustomValidation::validateExternalStoreIdForQris);
    createOrderByApiValidators.add(CustomValidation::validatePartnerReferenceNoForQris);
    createOrderByApiValidators.add(CustomValidation::validateSandboxPayMethodAndPayOption);
    createOrderByApiValidators.add(CustomValidation::validateConditionalPayOptionAdditionalInfoCreateOrderRequest);
    createOrderByApiValidators.add(CustomValidation::validateOptionalFieldsWithRequiredNestedCreateOrderRequest);
    validationRegistry.put("CreateOrderByApiRequest", createOrderByApiValidators);

    List<Consumer<Object>> createOrderByRedirectValidators = new ArrayList<>();
    createOrderByRedirectValidators.add(CustomValidation::defaultSourcePlatform);
    createOrderByRedirectValidators.add(CustomValidation::validateAdditionalInfoRequired);
    createOrderByRedirectValidators.add(CustomValidation::validateRequiredAdditionalInfoFieldsNotEmpty);
    createOrderByRedirectValidators.add(CustomValidation::validateMoneyValuePattern);
    createOrderByRedirectValidators.add(CustomValidation::validateSandboxAmount);
    createOrderByRedirectValidators.add(CustomValidation::validateValidUpToCreateOrderRequest);
    createOrderByRedirectValidators.add(CustomValidation::validateSandboxPayMethodAndPayOption);
    createOrderByRedirectValidators.add(CustomValidation::validateConditionalPayOptionAdditionalInfoCreateOrderRequest);
    createOrderByRedirectValidators.add(CustomValidation::validateOptionalFieldsWithRequiredNestedCreateOrderRequest);
    validationRegistry.put("CreateOrderByRedirectRequest", createOrderByRedirectValidators);
  }

  /**
   * Run all validators for the request type and aggregate validation failures into one {@link DanaException}.
   */
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

  private static final String SANDBOX_QRIS_GUIDANCE_HINT_SUCCESS =
      "If you want to use QRIS and it is not showing in payment methods, make sure you already fill externalStoreId. "
          + "See https://dashboard.dana.id/sandbox/submerchants in the external shop id section.";

  private static final String SANDBOX_QRIS_GUIDANCE_HINT_ERROR =
      "If you want to use QRIS, make sure you fill externalStoreId. "
          + "See https://dashboard.dana.id/sandbox/submerchants in the external shop id section. "
          + "For QRIS, partnerReferenceNo max is 25 chars.";

  private static final String SANDBOX_SUB_MERCHANT_ID_GUIDANCE_HINT =
      "Make sure your subMerchantId exists. You can see it at "
          + "https://dashboard.dana.id/sandbox/submerchants in the External Division ID section.";

  /**
   * Augment successful CreateOrder responses in sandbox (QRIS SUCCESS / subMerchantId guidance).
   */
  public static void customValidationResponse(Object request, Object response) {
    if (!isSandbox() || request == null || response == null) {
      return;
    }
    if (!(response instanceof CreateOrderResponse)) {
      return;
    }
    CreateOrderResponse createOrderResponse = (CreateOrderResponse) response;

    if (request instanceof CreateOrderByRedirectRequest) {
      CreateOrderByRedirectRequest redirectRequest = (CreateOrderByRedirectRequest) request;
      String externalStoreId = redirectRequest.getExternalStoreId();
      if (externalStoreId == null || externalStoreId.trim().isEmpty()) {
        createOrderResponse.setResponseMessage(
            appendSandboxHint(
                createOrderResponse.getResponseMessage(),
                SANDBOX_QRIS_GUIDANCE_HINT_SUCCESS,
                "externalstoreid"));
      }
    }

    String subMerchantId = extractSubMerchantId(request);
    if (subMerchantId != null && !subMerchantId.isEmpty()
        && isBusinessErrorResponse(createOrderResponse.getResponseCode())) {
      createOrderResponse.setResponseMessage(
          appendSandboxHint(
              createOrderResponse.getResponseMessage(),
              SANDBOX_SUB_MERCHANT_ID_GUIDANCE_HINT,
              "submerchantid",
              "externaldivisionid"));
    }
  }

  /**
   * Enrich CreateOrder HTTP-error bodies in sandbox.
   * SubMerchant guidance goes on responseMessage; redirect missing externalStoreId gets ERROR QRIS
   * wording (incl. partnerReferenceNo max 25) on responseMessage (Java returns body, does not throw).
   */
  public static void enrichCreateOrderError(Object request, Object response) {
    if (!isSandbox() || request == null || response == null) {
      return;
    }
    if (!(response instanceof CreateOrderResponse)) {
      return;
    }
    CreateOrderResponse createOrderResponse = (CreateOrderResponse) response;

    String subMerchantId = extractSubMerchantId(request);
    if (subMerchantId != null && !subMerchantId.isEmpty()
        && isBusinessErrorResponse(createOrderResponse.getResponseCode())) {
      createOrderResponse.setResponseMessage(
          appendSandboxHint(
              createOrderResponse.getResponseMessage(),
              SANDBOX_SUB_MERCHANT_ID_GUIDANCE_HINT,
              "submerchantid",
              "externaldivisionid"));
    }

    if (request instanceof CreateOrderByRedirectRequest) {
      CreateOrderByRedirectRequest redirectRequest = (CreateOrderByRedirectRequest) request;
      String externalStoreId = redirectRequest.getExternalStoreId();
      if (externalStoreId == null || externalStoreId.trim().isEmpty()) {
        createOrderResponse.setResponseMessage(
            appendSandboxHint(
                createOrderResponse.getResponseMessage(),
                SANDBOX_QRIS_GUIDANCE_HINT_ERROR,
                "externalstoreid",
                "partnerreferenceno"));
      }
    }
  }

  private static String extractSubMerchantId(Object request) {
    if (request instanceof CreateOrderByApiRequest) {
      return trimStr(((CreateOrderByApiRequest) request).getSubMerchantId());
    }
    if (request instanceof CreateOrderByRedirectRequest) {
      return trimStr(((CreateOrderByRedirectRequest) request).getSubMerchantId());
    }
    return "";
  }

  private static boolean isBusinessErrorResponse(String responseCode) {
    String code = trimStr(responseCode);
    return code.isEmpty() || !code.startsWith("200");
  }

  private static String appendSandboxHint(
      String responseMessage, String hint, String... alreadyPresentMarkers) {
    String msg = responseMessage == null ? "" : responseMessage.trim();
    String lowerMsg = msg.toLowerCase();
    for (String marker : alreadyPresentMarkers) {
      if (marker != null && !marker.isEmpty() && lowerMsg.contains(marker.toLowerCase())) {
        return msg;
      }
    }
    if (msg.isEmpty()) {
      return hint;
    }
    if (msg.endsWith(".")) {
      return msg + " " + hint;
    }
    return msg + ". " + hint;
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

  /**
   * Sets {@code envInfo.sourcePlatform} to {@link EnvInfo.SourcePlatformEnum#IPG} when null or empty.
   */
  private static void defaultSourcePlatform(Object request) {
    if (request == null) {
      return;
    }
    EnvInfo envInfo = null;
    if (request instanceof CreateOrderByApiRequest) {
      CreateOrderByApiAdditionalInfo ai = ((CreateOrderByApiRequest) request).getAdditionalInfo();
      if (ai != null) {
        envInfo = ai.getEnvInfo();
      }
    } else if (request instanceof CreateOrderByRedirectRequest) {
      CreateOrderByRedirectAdditionalInfo ai =
          ((CreateOrderByRedirectRequest) request).getAdditionalInfo();
      if (ai != null) {
        envInfo = ai.getEnvInfo();
      }
    }
    if (envInfo == null) {
      return;
    }
    EnvInfo.SourcePlatformEnum sourcePlatform = envInfo.getSourcePlatform();
    if (sourcePlatform == null
        || EnvInfo.SourcePlatformEnum.UNSPECIFIED.equals(sourcePlatform)
        || trimStr(sourcePlatform.getValue()).isEmpty()) {
      envInfo.setSourcePlatform(EnvInfo.SourcePlatformEnum.IPG);
    }
  }

  /**
   * Rejects blank required additionalInfo fields ({@code mcc}, {@code envInfo.terminalType}).
   */
  private static void validateRequiredAdditionalInfoFieldsNotEmpty(Object request) {
    if (request == null) {
      return;
    }
    String mcc = null;
    EnvInfo envInfo = null;
    if (request instanceof CreateOrderByApiRequest) {
      CreateOrderByApiAdditionalInfo ai = ((CreateOrderByApiRequest) request).getAdditionalInfo();
      if (ai == null) {
        return;
      }
      mcc = ai.getMcc();
      envInfo = ai.getEnvInfo();
    } else if (request instanceof CreateOrderByRedirectRequest) {
      CreateOrderByRedirectAdditionalInfo ai =
          ((CreateOrderByRedirectRequest) request).getAdditionalInfo();
      if (ai == null) {
        return;
      }
      mcc = ai.getMcc();
      envInfo = ai.getEnvInfo();
    } else {
      return;
    }
    List<Map<String, String>> contexts = new ArrayList<>();
    if (trimStr(mcc).isEmpty()) {
      contexts.add(ctx("additionalInfo.mcc",
          "additionalInfo.mcc is required and cannot be empty"));
    }
    EnvInfo.TerminalTypeEnum terminalType = envInfo != null ? envInfo.getTerminalType() : null;
    if (terminalType == null || trimStr(terminalType.getValue()).isEmpty()) {
      contexts.add(ctx("additionalInfo.envInfo.terminalType",
          "additionalInfo.envInfo.terminalType is required and cannot be empty"));
    }
    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
  }

  private static void validateAdditionalInfoRequired(Object request) {
    if (request == null) {
      return;
    }
    if (request instanceof CreateOrderByApiRequest) {
      if (((CreateOrderByApiRequest) request).getAdditionalInfo() == null) {
        throw new DanaException(Collections.singletonList(
            ctx("additionalInfo", "additionalInfo is required")));
      }
    } else if (request instanceof CreateOrderByRedirectRequest) {
      if (((CreateOrderByRedirectRequest) request).getAdditionalInfo() == null) {
        throw new DanaException(Collections.singletonList(
            ctx("additionalInfo", "additionalInfo is required")));
      }
    }
  }

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
      throw new DanaException(Collections.singletonList(ctx("amount.value", "amount.value is required")));
    }
    if (!MONEY_VALUE_PATTERN.matcher(value).matches()) {
      throw new DanaException(Collections.singletonList(ctx("amount.value",
          "amount.value must match pattern (e.g. 10000.00): got " + value)));
    }
  }

  /** In sandbox, amount.value must not exceed {@link #SANDBOX_MAX_AMOUNT}. */
  private static void validateSandboxAmount(Object request) {
    if (request == null || !isSandbox()) {
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
        throw new DanaException(Collections.singletonList(
            ctx("validUpTo", "validUpTo validation failed: " + e.getMessage())));
      }
    }
  }

  private static void validateExternalStoreIdForQris(Object request) {
    if (request == null || !(request instanceof CreateOrderByApiRequest)) {
      return;
    }
    CreateOrderByApiRequest apiRequest = (CreateOrderByApiRequest) request;
    List<PayOptionDetail> payOptionDetails = apiRequest.getPayOptionDetails();
    String externalStoreId = apiRequest.getExternalStoreId();
    if (payOptionDetails == null || payOptionDetails.isEmpty()) {
      return;
    }
    boolean hasQris = false;
    for (PayOptionDetail detail : payOptionDetails) {
      if (detail == null || detail.getPayOption() == null) {
        continue;
      }
      if (PayOptionDetail.PayOptionEnum.NETWORK_PAY_PG_QRIS.equals(detail.getPayOption())) {
        hasQris = true;
        break;
      }
    }
    if (hasQris && (externalStoreId == null || externalStoreId.trim().isEmpty())) {
      throw new DanaException(Collections.singletonList(ctx("externalStoreId",
          "externalStoreId is required when payOption is NETWORK_PAY_PG_QRIS")));
    }
  }

  private static void validatePartnerReferenceNoForQris(Object request) {
    if (request == null || !(request instanceof CreateOrderByApiRequest)) {
      return;
    }
    CreateOrderByApiRequest apiRequest = (CreateOrderByApiRequest) request;
    List<PayOptionDetail> payOptionDetails = apiRequest.getPayOptionDetails();
    if (payOptionDetails == null || payOptionDetails.isEmpty()) {
      return;
    }
    boolean hasQris = false;
    for (PayOptionDetail detail : payOptionDetails) {
      if (detail == null || detail.getPayOption() == null) {
        continue;
      }
      if (PayOptionDetail.PayOptionEnum.NETWORK_PAY_PG_QRIS.equals(detail.getPayOption())) {
        hasQris = true;
        break;
      }
    }
    if (hasQris && trimStr(apiRequest.getPartnerReferenceNo()).length() > 25) {
      throw new DanaException(Collections.singletonList(ctx("partnerReferenceNo",
          "partnerReferenceNo must be at most 25 characters when payOption is NETWORK_PAY_PG_QRIS")));
    }
  }

  private static final Set<String> SANDBOX_ALLOWED_PAY_METHODS = Collections.unmodifiableSet(new HashSet<>(
      Arrays.asList("BALANCE", "CREDIT_CARD", "DEBIT_CARD", "VIRTUAL_ACCOUNT", "NETWORK_PAY")));

  private static final Set<String> SANDBOX_ALLOWED_PAY_OPTIONS = Collections.unmodifiableSet(new HashSet<>(
      Arrays.asList("CARD", "QRIS", "BRI", "PANI", "CIMB", "BTPN", "BSI_PAYMENT")));

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

  private static void validateSandboxPayMethodAndPayOption(Object request) {
    if (request == null || !isSandbox() || !(request instanceof CreateOrderByApiRequest)) {
      return;
    }
    List<PayOptionDetail> payOptionDetails = ((CreateOrderByApiRequest) request).getPayOptionDetails();
    if (payOptionDetails == null || payOptionDetails.isEmpty()) {
      return;
    }
    for (int idx = 0; idx < payOptionDetails.size(); idx++) {
      PayOptionDetail detail = payOptionDetails.get(idx);
      if (detail == null) {
        continue;
      }
      String payMethodStr = getPayMethodString(detail);
      if (payMethodStr != null && !payMethodStr.isEmpty()
          && !SANDBOX_ALLOWED_PAY_METHODS.contains(payMethodStr.trim())) {
        throw new DanaException(Collections.singletonList(ctx(
            "payOptionDetails[" + idx + "].payMethod",
            "In sandbox, payMethod must be one of " + SANDBOX_ALLOWED_PAY_METHODS + "; got " + payMethodStr)));
      }
      String payOptionStr = getPayOptionString(detail);
      if (payOptionStr != null && !payOptionStr.isEmpty() && !payOptionAllowedInSandbox(payOptionStr)) {
        throw new DanaException(Collections.singletonList(ctx(
            "payOptionDetails[" + idx + "].payOption",
            "In sandbox, payOption must be one of " + SANDBOX_ALLOWED_PAY_OPTIONS
                + " (or suffix like VIRTUAL_ACCOUNT_BRI); got " + payOptionStr)));
      }
    }
  }

  private static String getPayMethodString(PayOptionDetail detail) {
    if (detail.getPayMethod() == null) {
      return null;
    }
    return detail.getPayMethod().name();
  }

  private static String getPayOptionString(PayOptionDetail detail) {
    if (detail.getPayOption() == null) {
      return null;
    }
    return detail.getPayOption().getValue();
  }

  private static String trimStr(String s) {
    return s == null ? "" : s.trim();
  }

  private static int runeLen(String s) {
    if (s == null) {
      return 0;
    }
    return s.codePointCount(0, s.length());
  }

  /**
   * Requires {@link PayOptionAdditionalInfo#getPhoneNumber()} for card / card pay option / e-wallet pay options.
   */
  private static void validateConditionalPayOptionAdditionalInfoCreateOrderRequest(Object request) {
    if (request == null || !(request instanceof CreateOrderByApiRequest)) {
      return;
    }
    List<PayOptionDetail> payOptionDetails = ((CreateOrderByApiRequest) request).getPayOptionDetails();
    if (payOptionDetails == null || payOptionDetails.isEmpty()) {
      return;
    }
    List<Map<String, String>> contexts = new ArrayList<>();
    for (int i = 0; i < payOptionDetails.size(); i++) {
      PayOptionDetail detail = payOptionDetails.get(i);
      if (detail == null) {
        continue;
      }
      String payMethod = trimStr(getPayMethodString(detail));
      String payOption = trimStr(getPayOptionString(detail));
      PayOptionAdditionalInfo additionalInfo = detail.getAdditionalInfo();
      String phoneRaw = additionalInfo != null ? additionalInfo.getPhoneNumber() : null;
      String phoneNumber = trimStr(phoneRaw);

      boolean isCard = CREDIT_DEBIT_CARD_PAY_METHODS.contains(payMethod) || NETWORK_PAY_PG_CARD.equals(payOption);
      boolean isEwallet = EWALLET_PAY_OPTIONS.contains(payOption);

      if (isCard || isEwallet) {
        String field = "payOptionDetails[" + i + "].additionalInfo.phoneNumber";
        if (phoneNumber.isEmpty()) {
          contexts.add(ctx(field,
              "phoneNumber is required for card/e-wallet payment (payOptionDetails[" + i + "])"));
        } else {
          int ln = runeLen(phoneNumber);
          if (ln < 1 || ln > 15) {
            contexts.add(ctx(field,
                "phoneNumber must be between 1 and 15 characters (payOptionDetails[" + i + "])"));
          }
        }
      }
    }
    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
  }

  /**
   * When optional nested objects are present, require their mandatory sub-fields (buyer, goods, shipping).
   */
  private static void validateOptionalFieldsWithRequiredNestedCreateOrderRequest(Object request) {
    if (request == null) {
      return;
    }
    Buyer buyer = null;
    List<Goods> goods = null;
    List<ShippingInfo> shippingInfo = null;
    if (request instanceof CreateOrderByApiRequest) {
      CreateOrderByApiAdditionalInfo ai = ((CreateOrderByApiRequest) request).getAdditionalInfo();
      if (ai != null && ai.getOrder() != null) {
        OrderApiObject order = ai.getOrder();
        buyer = order.getBuyer();
        goods = order.getGoods();
        shippingInfo = order.getShippingInfo();
      }
    } else if (request instanceof CreateOrderByRedirectRequest) {
      CreateOrderByRedirectAdditionalInfo ai = ((CreateOrderByRedirectRequest) request).getAdditionalInfo();
      if (ai != null && ai.getOrder() != null) {
        OrderRedirectObject order = ai.getOrder();
        buyer = order.getBuyer();
        goods = order.getGoods();
        shippingInfo = order.getShippingInfo();
      }
    }
    if (buyer == null && (goods == null || goods.isEmpty()) && (shippingInfo == null || shippingInfo.isEmpty())) {
      return;
    }
    List<Map<String, String>> contexts = new ArrayList<>();
    if (buyer != null) {
      String extType = trimStr(buyer.getExternalUserType());
      String extId = trimStr(buyer.getExternalUserId());
      boolean hasType = !extType.isEmpty();
      boolean hasId = !extId.isEmpty();
      if (hasId && !hasType) {
        contexts.add(ctx("additionalInfo.order.buyer.externalUserType",
            "externalUserType is required when externalUserId is filled"));
      }
      if (hasType && !hasId) {
        contexts.add(ctx("additionalInfo.order.buyer.externalUserId",
            "externalUserId is required when externalUserType is filled"));
      }
    }

    if (goods != null && !goods.isEmpty()) {
      for (int i = 0; i < goods.size(); i++) {
        Goods g = goods.get(i);
        if (g == null) {
          continue;
        }
        String prefix = "additionalInfo.order.goods[" + i + "]";
        if (trimStr(g.getName()).isEmpty()) {
          contexts.add(ctx(prefix + ".name", "name is required when goods is filled"));
        }
        if (trimStr(g.getMerchantGoodsId()).isEmpty()) {
          contexts.add(ctx(prefix + ".merchantGoodsId",
              "merchantGoodsId is required when goods is filled"));
        }
        if (trimStr(g.getDescription()).isEmpty()) {
          contexts.add(ctx(prefix + ".description",
              "description is required when goods is filled"));
        }
        if (trimStr(g.getCategory()).isEmpty()) {
          contexts.add(ctx(prefix + ".category", "category is required when goods is filled"));
        }
        if (trimStr(g.getQuantity()).isEmpty()) {
          contexts.add(ctx(prefix + ".quantity", "quantity is required when goods is filled"));
        }
        Money price = g.getPrice();
        if (price == null || trimStr(price.getValue()).isEmpty()) {
          contexts.add(ctx(prefix + ".price.value",
              "price.value is required when goods is filled"));
        }
        if (price == null || trimStr(price.getCurrency()).isEmpty()) {
          contexts.add(ctx(prefix + ".price.currency",
              "price.currency is required when goods is filled"));
        }
      }
    }

    if (shippingInfo != null && !shippingInfo.isEmpty()) {
      for (int i = 0; i < shippingInfo.size(); i++) {
        ShippingInfo s = shippingInfo.get(i);
        if (s == null) {
          continue;
        }
        String prefix = "additionalInfo.order.shippingInfo[" + i + "]";
        if (trimStr(s.getMerchantShippingId()).isEmpty()) {
          contexts.add(ctx(prefix + ".merchantShippingId",
              "merchantShippingId is required when shippingInfo is filled"));
        }
        if (trimStr(s.getCountryName()).isEmpty()) {
          contexts.add(ctx(prefix + ".countryName",
              "countryName is required when shippingInfo is filled"));
        }
        if (trimStr(s.getStateName()).isEmpty()) {
          contexts.add(ctx(prefix + ".stateName",
              "stateName is required when shippingInfo is filled"));
        }
        if (trimStr(s.getCityName()).isEmpty()) {
          contexts.add(ctx(prefix + ".cityName",
              "cityName is required when shippingInfo is filled"));
        }
        if (trimStr(s.getAddress1()).isEmpty()) {
          contexts.add(ctx(prefix + ".address1",
              "address1 is required when shippingInfo is filled"));
        }
        if (trimStr(s.getFirstName()).isEmpty()) {
          contexts.add(ctx(prefix + ".firstName",
              "firstName is required when shippingInfo is filled"));
        }
        if (trimStr(s.getLastName()).isEmpty()) {
          contexts.add(ctx(prefix + ".lastName",
              "lastName is required when shippingInfo is filled"));
        }
        if (trimStr(s.getZipCode()).isEmpty()) {
          contexts.add(ctx(prefix + ".zipCode",
              "zipCode is required when shippingInfo is filled"));
        }
      }
    }

    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
  }
}
