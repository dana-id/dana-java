

# RefundOrderResponse


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**originalCaptureNo** | **String** | DANA's capture identifier. Use to refund the corresponding capture order |  [optional] |
|**refundNo** | **String** | Refund number identifier on DANA system |  [optional] |
|**partnerRefundNo** | **String** | Reference number from merchant for the refund |  |
|**refundAmount** | [**Money**](Money.md) | Refund amount. Contains two sub-fields - 1. Value (Amount, including the cents) and 2. Currency (Currency code based on ISO) |  |
|**refundTime** | **String** | Refund time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



