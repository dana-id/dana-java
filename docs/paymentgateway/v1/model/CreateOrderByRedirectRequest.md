

# CreateOrderByRedirectRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalInfo** | [**CreateOrderByRedirectAdditionalInfo**](CreateOrderByRedirectAdditionalInfo.md) |  |  [optional] |
|**partnerReferenceNo** | **String** | Transaction identifier on partner system |  |
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**validUpTo** | **String** | The time when the payment will be automatically expired, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**disabledPayMethods** | **String** | Payment method(s) that cannot be used for this |  [optional] |
|**urlParams** | [**List&lt;UrlParam&gt;**](UrlParam.md) | Notify URL that DANA must send the payment notification to |  |


## Implemented Interfaces

* CreateOrderRequest


