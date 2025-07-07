

# CancelOrderRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**reason** | **String** | Cancellation reason |  [optional] |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub fields - Value (Transaction amount, including the cents) and Currency (Currency code based on ISO 4217) |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



