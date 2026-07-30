

# TransferToBankRequest


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction<br> Notes:<br> If the partner receives a timeout or an unexpected response from DANA and partner expects to perform retry request to DANA, please use the partnerReferenceNo that is the same as the one used in the transaction request process before  |  [optional] |
|**customerNumber** | **String** | Customer account number, in format 628xxx |  |
|**accountType** | [**AccountTypeEnum**](#AccountTypeEnum) | Customer account type  |  [optional] |
|**beneficiaryAccountNumber** | **String** | Beneficiary account number |  |
|**beneficiaryBankCode** | **String** | Beneficiary Bank code |  |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO  |  |
|**additionalInfo** | [**TransferToBankRequestAdditionalInfo**](TransferToBankRequestAdditionalInfo.md) |  |  |


<a name="AccountTypeEnum"></a>
## Enum: AccountTypeEnum

| Name | Value | Description |
| - | - | - |
| `MERCHANT_DEPOSIT_ACCOUNT` | "MERCHANT_DEPOSIT_ACCOUNT" | Merchant deposit account |
| `SETTLEMENT_ACCOUNT` | "SETTLEMENT_ACCOUNT" | Settlement account |
| `DIVISION_DEPOSIT_ACCOUNT` | "DIVISION_DEPOSIT_ACCOUNT" | Division deposit account |

### Usage Example
```java
import id.dana.disbursement.v1.model.TransferToBankRequest.AccountTypeEnum;

public class Example {
    public static void main(String[] args) {
        AccountTypeEnum exampleEnum = AccountTypeEnum.MERCHANT_DEPOSIT_ACCOUNT;
    }
}
```



