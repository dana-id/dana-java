

# WidgetPaymentRequest


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction |  |
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** |  |  [optional] |
|**amount** | [**Money**](Money.md) |  |  |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**validUpTo** | **String** | The time when the payment will be automatically expired, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**pointOfInitiation** | **String** | Used for getting more info regarding source of request of the user |  [optional] |
|**disabledPayMethods** | **String** | Payment method(s) that cannot be used for this payment |  [optional] |
|**payOptionDetails** | [**List&lt;PayOptionDetail&gt;**](PayOptionDetail.md) | Payment option that will be used for this payment |  [optional] |
|**additionalInfo** | [**WidgetPaymentRequestAdditionalInfo**](WidgetPaymentRequestAdditionalInfo.md) |  |  |
|**urlParams** | [**List&lt;UrlParam&gt;**](UrlParam.md) | Notify URL that DANA must send the payment notification to |  [optional] |



