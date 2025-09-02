

# TransferToBankInquiryStatusResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request, value always 00 |  |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**latestTransactionStatus** | [**LatestTransactionStatusEnum**](#LatestTransactionStatusEnum) | Status of latest transaction:<br> 00 - Success<br> 01 - Initiated<br> 02 - Paying<br> 03 - Pending<br> 04 - Refunded<br> 05 - Cancelled<br> 06 - Failed<br> 07 - Not found  |  |
|**transactionStatusDesc** | **String** | Description of transaction status |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |


<a name="LatestTransactionStatusEnum"></a>
## Enum: LatestTransactionStatusEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| _00 | "00" | Success |
| _01 | "01" | Initiated |
| _02 | "02" | Paying |
| _03 | "03" | Pending |
| _04 | "04" | Refunded |
| _05 | "05" | Cancelled |
| _06 | "06" | Failed |
| _07 | "07" | Not found |

### Usage Example
```java
import id.dana.disbursement.v1.model.TransferToBankInquiryStatusResponse.LatestTransactionStatusEnum;

public class Example {
    public static void main(String[] args) {
        LatestTransactionStatusEnum exampleEnum = LatestTransactionStatusEnum._00;
    }
}
```



