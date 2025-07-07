

# FinishNotifyRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on DANA system |  |
|**originalReferenceNo** | **String** | Original transaction identifier on partner system |  |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**merchantId** | **String** | Unique identifier per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  |
|**latestTransactionStatus** | **String** | Transaction status code:&lt;br&gt; - 00 &#x3D; Success, the order has been paid&lt;br&gt; - 05 &#x3D; Cancelled, the order has been closed because it is expired&lt;br&gt;  |  |
|**transactionStatusDesc** | **String** | Description of transaction status |  [optional] |
|**createdTime** | **String** | Transaction created time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  |
|**finishedTime** | **String** | Transaction finished time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**additionalInfo** | [**FinishNotifyRequestAdditionalInfo**](FinishNotifyRequestAdditionalInfo.md) | Additional information |  [optional] |



