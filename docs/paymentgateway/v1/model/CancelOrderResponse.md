

# CancelOrderResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**responseCode** | **String** | Response code. Refer to https://dashboard.dana.id/api-docs/read/117#HTML-API-CancelOrder-ResponseCodeandMessage |  |
|**responseMessage** | **String** | Response message. Refer to https://dashboard.dana.id/api-docs/read/117#HTML-API-CancelOrder-ResponseCodeandMessage |  |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system. Present if successfully processed |  [optional] |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**cancelTime** | **String** | Cancellation date time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time). Present if successfully processed |  [optional] |
|**transactionDate** | **String** | Transaction date, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



