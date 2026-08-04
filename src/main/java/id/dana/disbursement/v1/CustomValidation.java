package id.dana.disbursement.v1;

import id.dana.disbursement.v1.model.BankAccountInquiryRequest;
import id.dana.disbursement.v1.model.BankAccountInquiryRequestAdditionalInfo;
import id.dana.disbursement.v1.model.DanaAccountInquiryRequest;
import id.dana.disbursement.v1.model.DanaAccountInquiryRequestAdditionalInfo;
import id.dana.disbursement.v1.model.TransferToBankRequest;
import id.dana.disbursement.v1.model.TransferToBankRequestAdditionalInfo;
import id.dana.disbursement.v1.model.TransferToDanaRequest;
import id.dana.disbursement.v1.model.TransferToDanaRequestAdditionalInfo;
import id.dana.invoker.model.exception.DanaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * CustomValidation for Disbursement API: registry, aggregated {@link DanaException} contexts, and validators.
 *
 * <p>In sandbox, clears ignored fields ({@code accountType}, {@code beneficiaryAccountName}) so user values
 * do not affect requests. Also rejects blank required {@code additionalInfo} fields.
 */
public final class CustomValidation {

  private static final java.util.Set<String> ALLOWED_ACCOUNT_TYPES =
      Collections.unmodifiableSet(new java.util.HashSet<>(java.util.Arrays.asList(
          "MERCHANT_DEPOSIT_ACCOUNT",
          "SETTLEMENT_ACCOUNT",
          "DIVISION_DEPOSIT_ACCOUNT")));

  private CustomValidation() {}

  private static final Map<String, List<Consumer<Object>>> validationRegistry = new HashMap<>();

  static {
    List<Consumer<Object>> bankAccountInquiry = new ArrayList<>();
    bankAccountInquiry.add(CustomValidation::stripSandboxIgnoredFieldsBankAccountInquiry);
    bankAccountInquiry.add(CustomValidation::validateAccountTypeBankAccountInquiry);
    bankAccountInquiry.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyBankAccountInquiry);
    validationRegistry.put("BankAccountInquiryRequest", bankAccountInquiry);

    List<Consumer<Object>> transferToBank = new ArrayList<>();
    transferToBank.add(CustomValidation::stripSandboxIgnoredFieldsTransferToBank);
    transferToBank.add(CustomValidation::validateAccountTypeTransferToBank);
    transferToBank.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyTransferToBank);
    validationRegistry.put("TransferToBankRequest", transferToBank);

    List<Consumer<Object>> transferToDana = new ArrayList<>();
    transferToDana.add(CustomValidation::stripSandboxIgnoredFieldsTransferToDana);
    transferToDana.add(CustomValidation::validateAccountTypeTransferToDana);
    transferToDana.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyTransferToDana);
    validationRegistry.put("TransferToDanaRequest", transferToDana);

    List<Consumer<Object>> danaAccountInquiry = new ArrayList<>();
    danaAccountInquiry.add(CustomValidation::stripSandboxIgnoredFieldsDanaAccountInquiry);
    danaAccountInquiry.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyDanaAccountInquiry);
    validationRegistry.put("DanaAccountInquiryRequest", danaAccountInquiry);
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

  private static final String SANDBOX_POSITIVE_BENEFICIARY_ACCOUNT_NUMBER = "2460888509";
  private static final String SANDBOX_POSITIVE_BENEFICIARY_BANK_CODE = "014";
  private static final long SANDBOX_MAX_AMOUNT = 20000000L;

  private static final String SANDBOX_POSITIVE_BANK_HINT =
      "For testing positive case in sandbox use beneficiaryAccountNumber "
          + SANDBOX_POSITIVE_BENEFICIARY_ACCOUNT_NUMBER
          + " and beneficiaryBankCode "
          + SANDBOX_POSITIVE_BENEFICIARY_BANK_CODE;

  private static final String SANDBOX_AMOUNT_MAX_HINT =
      "In sandbox, amount.value must not exceed " + SANDBOX_MAX_AMOUNT;

  private static final String SANDBOX_DANA_BALANCE_LIMIT_HINT =
      "Make sure DANA balance not exceeding limit of 21000000 after topup";

  /**
   * Augment Disbursement responses in sandbox with account/amount guidance.
   */
  public static void customValidationResponse(Object request, Object response) {
    if (!isSandbox() || request == null || response == null) {
      return;
    }
    applySandboxDisbursementHints(request, response);
  }

  /**
   * Enrich Disbursement HTTP-error bodies in sandbox (same tip rules as success-path hook).
   */
  public static void enrichDisbursementError(Object request, Object response) {
    if (!isSandbox() || request == null || response == null) {
      return;
    }
    applySandboxDisbursementHints(request, response);
  }

  private static void applySandboxDisbursementHints(Object request, Object response) {
    String responseCode = getResponseCode(response);
    String responseMessage = getResponseMessage(response);

    String updated = responseMessage == null ? "" : responseMessage;

    if (isBankTransferRequest(request) && shouldAppendPositiveBankHint(responseCode)) {
      updated = appendSandboxHint(
          updated,
          SANDBOX_POSITIVE_BANK_HINT,
          SANDBOX_POSITIVE_BENEFICIARY_ACCOUNT_NUMBER,
          "beneficiarybankcode " + SANDBOX_POSITIVE_BENEFICIARY_BANK_CODE);
    }

    if (request instanceof TransferToDanaRequest) {
      if (shouldAppendDanaBalanceHint(responseCode, responseMessage)) {
        updated = appendSandboxHint(updated, SANDBOX_DANA_BALANCE_LIMIT_HINT, "21000000", "after topup");
      }
    } else if (shouldAppendAmountMaxHint(responseMessage)) {
      updated = appendSandboxHint(updated, SANDBOX_AMOUNT_MAX_HINT, String.valueOf(SANDBOX_MAX_AMOUNT));
    }

    if (!updated.equals(responseMessage == null ? "" : responseMessage)) {
      setResponseMessage(response, updated);
    }
  }

  private static boolean isBankTransferRequest(Object request) {
    return request instanceof BankAccountInquiryRequest || request instanceof TransferToBankRequest;
  }

  private static boolean shouldAppendPositiveBankHint(String responseCode) {
    return trimStr(responseCode).startsWith("500");
  }

  private static boolean shouldAppendDanaBalanceHint(String responseCode, String responseMessage) {
    String msg = responseMessage == null ? "" : responseMessage.toLowerCase();
    if (msg.contains("exceed") || msg.contains("melebihi")) {
      return true;
    }
    return "4033802".equals(trimStr(responseCode));
  }

  private static boolean shouldAppendAmountMaxHint(String responseMessage) {
    String msg = responseMessage == null ? "" : responseMessage.toLowerCase();
    return msg.contains("exceed") || msg.contains("melebihi");
  }

  private static String getResponseCode(Object response) {
    try {
      Object value = response.getClass().getMethod("getResponseCode").invoke(response);
      return value == null ? "" : String.valueOf(value);
    } catch (ReflectiveOperationException ignored) {
      return "";
    }
  }

  private static String getResponseMessage(Object response) {
    try {
      Object value = response.getClass().getMethod("getResponseMessage").invoke(response);
      return value == null ? "" : String.valueOf(value);
    } catch (ReflectiveOperationException ignored) {
      return "";
    }
  }

  private static void setResponseMessage(Object response, String message) {
    try {
      response.getClass().getMethod("setResponseMessage", String.class).invoke(response, message);
    } catch (ReflectiveOperationException ignored) {
      // response model may be read-only in some contexts
    }
  }

  private static String appendSandboxHint(String responseMessage, String hint, String... alreadyPresentMarkers) {
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

  private static String trimStr(String s) {
    return s == null ? "" : s.trim();
  }

  /**
   * Normalizes accountType whether the generated model uses {@code String} or {@code AccountTypeEnum}.
   */
  private static String accountTypeValue(Object accountType) {
    if (accountType == null) {
      return "";
    }
    if (accountType instanceof String) {
      return trimStr((String) accountType);
    }
    try {
      Object raw = accountType.getClass().getMethod("getValue").invoke(accountType);
      return trimStr(raw == null ? null : String.valueOf(raw));
    } catch (ReflectiveOperationException ignored) {
      return trimStr(String.valueOf(accountType));
    }
  }

  private static void requireNonEmpty(String value, String fieldPath) {
    if (trimStr(value).isEmpty()) {
      throw new DanaException(Collections.singletonList(
          ctx(fieldPath, fieldPath + " is required and cannot be empty")));
    }
  }

  private static void validateAccountTypeValue(String value, String fieldPath) {
    if (!ALLOWED_ACCOUNT_TYPES.contains(value)) {
      throw new DanaException(Collections.singletonList(ctx(fieldPath,
          fieldPath + " must be one of [MERCHANT_DEPOSIT_ACCOUNT, SETTLEMENT_ACCOUNT, DIVISION_DEPOSIT_ACCOUNT]; got "
              + value)));
    }
  }

  /** In sandbox, accountType, beneficiaryAccountName, externalDivisionId, and chargeTarget are ignored. */
  private static void stripSandboxIgnoredFieldsBankAccountInquiry(Object request) {
    if (!isSandbox() || !(request instanceof BankAccountInquiryRequest)) {
      return;
    }
    BankAccountInquiryRequestAdditionalInfo info =
        ((BankAccountInquiryRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    info.setAccountType(null);
    info.setBeneficiaryAccountName(null);
    info.setExternalDivisionId(null);
    info.setChargeTarget(null);
  }

  private static void stripSandboxIgnoredFieldsTransferToBank(Object request) {
    if (!isSandbox() || !(request instanceof TransferToBankRequest)) {
      return;
    }
    TransferToBankRequest req = (TransferToBankRequest) request;
    req.setAccountType(null);
    TransferToBankRequestAdditionalInfo info = req.getAdditionalInfo();
    if (info != null) {
      info.setBeneficiaryAccountName(null);
      info.setExternalDivisionId(null);
      info.setChargeTarget(null);
    }
  }

  private static void stripSandboxIgnoredFieldsTransferToDana(Object request) {
    if (!isSandbox() || !(request instanceof TransferToDanaRequest)) {
      return;
    }
    TransferToDanaRequestAdditionalInfo info =
        ((TransferToDanaRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    info.setAccountType(null);
    info.setExternalDivisionId(null);
    info.setChargeTarget(null);
  }

  private static void stripSandboxIgnoredFieldsDanaAccountInquiry(Object request) {
    if (!isSandbox() || !(request instanceof DanaAccountInquiryRequest)) {
      return;
    }
    DanaAccountInquiryRequestAdditionalInfo info =
        ((DanaAccountInquiryRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    info.setExternalDivisionId(null);
    info.setChargeTarget(null);
  }

  /** Non-sandbox: if accountType is set, it must be a valid enum value. Empty is allowed (no default). */
  private static void validateAccountTypeBankAccountInquiry(Object request) {
    if (isSandbox() || !(request instanceof BankAccountInquiryRequest)) {
      return;
    }
    BankAccountInquiryRequestAdditionalInfo info =
        ((BankAccountInquiryRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    String accountType = accountTypeValue(info.getAccountType());
    if (accountType.isEmpty()) {
      return;
    }
    validateAccountTypeValue(accountType, "additionalInfo.accountType");
  }

  private static void validateAccountTypeTransferToBank(Object request) {
    if (isSandbox() || !(request instanceof TransferToBankRequest)) {
      return;
    }
    TransferToBankRequest req = (TransferToBankRequest) request;
    String accountType = accountTypeValue(req.getAccountType());
    if (accountType.isEmpty()) {
      return;
    }
    validateAccountTypeValue(accountType, "accountType");
  }

  private static void validateAccountTypeTransferToDana(Object request) {
    if (isSandbox() || !(request instanceof TransferToDanaRequest)) {
      return;
    }
    TransferToDanaRequestAdditionalInfo info =
        ((TransferToDanaRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    String accountType = accountTypeValue(info.getAccountType());
    if (accountType.isEmpty()) {
      return;
    }
    validateAccountTypeValue(accountType, "additionalInfo.accountType");
  }

  private static void validateRequiredAdditionalInfoNotEmptyBankAccountInquiry(Object request) {
    if (!(request instanceof BankAccountInquiryRequest)) {
      return;
    }
    BankAccountInquiryRequestAdditionalInfo info =
        ((BankAccountInquiryRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    List<Map<String, String>> contexts = new ArrayList<>();
    if (trimStr(info.getFundType()).isEmpty()) {
      contexts.add(ctx("additionalInfo.fundType",
          "additionalInfo.fundType is required and cannot be empty"));
    }
    if (trimStr(info.getBeneficiaryBankCode()).isEmpty()) {
      contexts.add(ctx("additionalInfo.beneficiaryBankCode",
          "additionalInfo.beneficiaryBankCode is required and cannot be empty"));
    }
    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
  }

  private static void validateRequiredAdditionalInfoNotEmptyTransferToBank(Object request) {
    if (!(request instanceof TransferToBankRequest)) {
      return;
    }
    TransferToBankRequestAdditionalInfo info =
        ((TransferToBankRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    requireNonEmpty(info.getFundType(), "additionalInfo.fundType");
  }

  private static void validateRequiredAdditionalInfoNotEmptyTransferToDana(Object request) {
    if (!(request instanceof TransferToDanaRequest)) {
      return;
    }
    TransferToDanaRequestAdditionalInfo info =
        ((TransferToDanaRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    requireNonEmpty(info.getFundType(), "additionalInfo.fundType");
  }

  private static void validateRequiredAdditionalInfoNotEmptyDanaAccountInquiry(Object request) {
    if (!(request instanceof DanaAccountInquiryRequest)) {
      return;
    }
    DanaAccountInquiryRequestAdditionalInfo info =
        ((DanaAccountInquiryRequest) request).getAdditionalInfo();
    if (info == null) {
      return;
    }
    requireNonEmpty(info.getFundType(), "additionalInfo.fundType");
  }
}
