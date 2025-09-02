

# RefundOrderRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**originalCaptureNo** | **String** | DANA's capture identifier. Use to refund the corresponding capture order. Required if auth payment scenario |  [optional] |
|**partnerRefundNo** | **String** | Reference number from merchant for the refund |  |
|**refundAmount** | [**Money**](Money.md) | Refund amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**reason** | **String** | Refund reason |  [optional] |
|**additionalInfo** | [**RefundOrderRequestAdditionalInfo**](RefundOrderRequestAdditionalInfo.md) | Additional information |  [optional] |



