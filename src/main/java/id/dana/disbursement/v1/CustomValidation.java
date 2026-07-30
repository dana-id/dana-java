package id.dana.disbursement.v1;

import id.dana.disbursement.v1.model.BankAccountInquiryRequest;
import id.dana.disbursement.v1.model.BankAccountInquiryRequestAdditionalInfo;
import id.dana.disbursement.v1.model.DanaAccountInquiryRequest;
import id.dana.disbursement.v1.model.DanaAccountInquiryRequestAdditionalInfo;
import id.dana.disbursement.v1.model.Money;
import id.dana.disbursement.v1.model.TransferToBankRequest;
import id.dana.disbursement.v1.model.TransferToBankRequestAdditionalInfo;
import id.dana.disbursement.v1.model.TransferToDanaRequest;
import id.dana.disbursement.v1.model.TransferToDanaRequestAdditionalInfo;
import id.dana.disbursement.v1.model.TransferToDanaResponse;
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

  private static final String SANDBOX_BENEFICIARY_ACCOUNT_NUMBER = "2460888509";
  private static final String SANDBOX_BENEFICIARY_BANK_CODE = "014";
  /** Sandbox maximum amount (major units) for Disbursement. */
  private static final double SANDBOX_MAX_AMOUNT = 20000000d;
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
    bankAccountInquiry.add(CustomValidation::validateSandboxBeneficiaryBankAccountInquiry);
    bankAccountInquiry.add(CustomValidation::validateSandboxAmount);
    bankAccountInquiry.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyBankAccountInquiry);
    validationRegistry.put("BankAccountInquiryRequest", bankAccountInquiry);

    List<Consumer<Object>> transferToBank = new ArrayList<>();
    transferToBank.add(CustomValidation::stripSandboxIgnoredFieldsTransferToBank);
    transferToBank.add(CustomValidation::validateAccountTypeTransferToBank);
    transferToBank.add(CustomValidation::validateSandboxBeneficiaryTransferToBank);
    transferToBank.add(CustomValidation::validateSandboxAmount);
    transferToBank.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyTransferToBank);
    validationRegistry.put("TransferToBankRequest", transferToBank);

    List<Consumer<Object>> transferToDana = new ArrayList<>();
    transferToDana.add(CustomValidation::stripSandboxIgnoredFieldsTransferToDana);
    transferToDana.add(CustomValidation::validateAccountTypeTransferToDana);
    transferToDana.add(CustomValidation::validateSandboxAmount);
    transferToDana.add(CustomValidation::validateRequiredAdditionalInfoNotEmptyTransferToDana);
    validationRegistry.put("TransferToDanaRequest", transferToDana);

    List<Consumer<Object>> danaAccountInquiry = new ArrayList<>();
    danaAccountInquiry.add(CustomValidation::stripSandboxIgnoredFieldsDanaAccountInquiry);
    danaAccountInquiry.add(CustomValidation::validateSandboxAmount);
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

  private static final String SANDBOX_DANA_BALANCE_LIMIT_HINT =
      "Make sure DANA balance not exceeding limit of 21000000 after topup";

  /**
   * Augment TransferToDana responses in sandbox on business errors.
   */
  public static void customValidationResponse(Object request, Object response) {
    if (!isSandbox() || request == null || response == null) {
      return;
    }
    if (!(request instanceof TransferToDanaRequest) || !(response instanceof TransferToDanaResponse)) {
      return;
    }
    TransferToDanaResponse transferToDanaResponse = (TransferToDanaResponse) response;
    if (!isBusinessErrorResponse(transferToDanaResponse.getResponseCode())) {
      return;
    }
    transferToDanaResponse.setResponseMessage(
        appendSandboxDanaBalanceHint(transferToDanaResponse.getResponseMessage()));
  }

  private static boolean isBusinessErrorResponse(String responseCode) {
    String code = trimStr(responseCode);
    return code.isEmpty() || !code.startsWith("200");
  }

  private static String appendSandboxDanaBalanceHint(String responseMessage) {
    String hint = SANDBOX_DANA_BALANCE_LIMIT_HINT;
    String msg = responseMessage == null ? "" : responseMessage.trim();
    String lowerMsg = msg.toLowerCase();
    if (lowerMsg.contains("21000000") || lowerMsg.contains("after topup")) {
      return msg;
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

  /** In sandbox, amount.value must not exceed {@link #SANDBOX_MAX_AMOUNT}. */
  private static void validateSandboxAmount(Object request) {
    if (request == null || !isSandbox()) {
      return;
    }
    Money amount = null;
    if (request instanceof BankAccountInquiryRequest) {
      amount = ((BankAccountInquiryRequest) request).getAmount();
    } else if (request instanceof TransferToBankRequest) {
      amount = ((TransferToBankRequest) request).getAmount();
    } else if (request instanceof TransferToDanaRequest) {
      amount = ((TransferToDanaRequest) request).getAmount();
    } else if (request instanceof DanaAccountInquiryRequest) {
      amount = ((DanaAccountInquiryRequest) request).getAmount();
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

  /** In sandbox, beneficiaryAccountNumber must be 2460888509 and beneficiaryBankCode must be 014. */
  private static void validateSandboxBeneficiaryBankAccountInquiry(Object request) {
    if (!isSandbox() || !(request instanceof BankAccountInquiryRequest)) {
      return;
    }
    BankAccountInquiryRequest req = (BankAccountInquiryRequest) request;
    List<Map<String, String>> contexts = new ArrayList<>();
    if (!SANDBOX_BENEFICIARY_ACCOUNT_NUMBER.equals(trimStr(req.getBeneficiaryAccountNumber()))) {
      contexts.add(ctx("beneficiaryAccountNumber",
          "in sandbox, beneficiaryAccountNumber must be " + SANDBOX_BENEFICIARY_ACCOUNT_NUMBER
              + "; got " + req.getBeneficiaryAccountNumber()));
    }
    BankAccountInquiryRequestAdditionalInfo info = req.getAdditionalInfo();
    String bankCode = info == null ? null : info.getBeneficiaryBankCode();
    if (!SANDBOX_BENEFICIARY_BANK_CODE.equals(trimStr(bankCode))) {
      contexts.add(ctx("additionalInfo.beneficiaryBankCode",
          "in sandbox, additionalInfo.beneficiaryBankCode must be " + SANDBOX_BENEFICIARY_BANK_CODE
              + "; got " + bankCode));
    }
    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
  }

  private static void validateSandboxBeneficiaryTransferToBank(Object request) {
    if (!isSandbox() || !(request instanceof TransferToBankRequest)) {
      return;
    }
    TransferToBankRequest req = (TransferToBankRequest) request;
    List<Map<String, String>> contexts = new ArrayList<>();
    if (!SANDBOX_BENEFICIARY_ACCOUNT_NUMBER.equals(trimStr(req.getBeneficiaryAccountNumber()))) {
      contexts.add(ctx("beneficiaryAccountNumber",
          "in sandbox, beneficiaryAccountNumber must be " + SANDBOX_BENEFICIARY_ACCOUNT_NUMBER
              + "; got " + req.getBeneficiaryAccountNumber()));
    }
    if (!SANDBOX_BENEFICIARY_BANK_CODE.equals(trimStr(req.getBeneficiaryBankCode()))) {
      contexts.add(ctx("beneficiaryBankCode",
          "in sandbox, beneficiaryBankCode must be " + SANDBOX_BENEFICIARY_BANK_CODE
              + "; got " + req.getBeneficiaryBankCode()));
    }
    if (!contexts.isEmpty()) {
      throw new DanaException(contexts);
    }
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
