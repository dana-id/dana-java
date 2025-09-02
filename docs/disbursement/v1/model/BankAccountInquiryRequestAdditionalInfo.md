

# BankAccountInquiryRequestAdditionalInfo

Additional information

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fundType** | **String** | Additional information of withdraw fund type, i.e.<br> MERCHANT_WITHDRAW_FOR_CORPORATE  |  |
|**externalDivisionId** | **String** | Additional information of external division identifier. (fundType: MERCHANT_WITHDRAW_FOR_CORPORATE)<br> Notes: The required of this parameter is Optional, but if \"additionalInfo.chargeTarget\" has value DIVISION then the required of this parameter will be changed to Mandatory  |  [optional] |
|**chargeTarget** | [**ChargeTargetEnum**](#ChargeTargetEnum) | Additional information of charge target. The values are:<br> • null<br> • DIVISION<br> • MERCHANT<br> Notes: If the value is DIVISION, externalDivisionId will be Mandatory  |  [optional] |
|**beneficiaryBankCode** | **String** | Additional information of beneficiary Bank code |  |
|**beneficiaryAccountName** | **String** | Additional information of beneficiary account name for validation purpose |  [optional] |
|**accountType** | **String** | Additional information of account type |  [optional] |
|**accessToken** | **String** | Contains customer token, which has been obtained from binding process, refer to Account Binding & Unbinding documentation<br> If request is coming from user interaction, this field is mandatory. If not, just filled customerNumber  |  [optional] |


<a name="ChargeTargetEnum"></a>
## Enum: ChargeTargetEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| DIVISION | "DIVISION" |  |
| MERCHANT | "MERCHANT" |  |

### Usage Example
```java
import id.dana.disbursement.v1.model.BankAccountInquiryRequestAdditionalInfo.ChargeTargetEnum;

public class Example {
    public static void main(String[] args) {
        ChargeTargetEnum exampleEnum = ChargeTargetEnum.DIVISION;
    }
}
```



