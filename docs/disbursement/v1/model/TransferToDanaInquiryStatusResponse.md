

# TransferToDanaInquiryStatusResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request, value always 38 |  |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO  |  |
|**latestTransactionStatus** | [**LatestTransactionStatusEnum**](#LatestTransactionStatusEnum) | Status of latest transaction:&lt;br&gt; 00 - Success&lt;br&gt; 01 - Initiated&lt;br&gt; 02 - Paying&lt;br&gt; 03 - Pending&lt;br&gt; 04 - Refunded&lt;br&gt; 05 - Cancelled&lt;br&gt; 06 - Failed&lt;br&gt; 07 - Not found  |  |
|**transactionStatusDesc** | **String** | Description of transaction status |  |
|**additionalInfo** | **Object** | Additional information |  [optional] |



## Enum: LatestTransactionStatusEnum

| Name | Value |
|---- | -----|
| _00 | &quot;00&quot; |
| _01 | &quot;01&quot; |
| _02 | &quot;02&quot; |
| _03 | &quot;03&quot; |
| _04 | &quot;04&quot; |
| _05 | &quot;05&quot; |
| _06 | &quot;06&quot; |
| _07 | &quot;07&quot; |



