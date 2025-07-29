

# QueryMerchantResourceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestMerchantId** | **String** | This is a merchantId of DANA |  |
|**merchantResourceInfoList** | [**List&lt;MerchantResourceInfoListEnum&gt;**](#List&lt;MerchantResourceInfoListEnum&gt;) | This is a constant merchant resource info request, currently available for value of constant these: MERCHANT_DEPOSIT_BALANCE MERCHANT_AVAILABLE_BALANCE MERCHANT_TOTAL_BALANCE value for this request can&#39;t be empty or wrong constant info  |  |



## Enum: List&lt;MerchantResourceInfoListEnum&gt;

| Name | Value |
|---- | -----|
| MERCHANT_DEPOSIT_BALANCE | &quot;MERCHANT_DEPOSIT_BALANCE&quot; |
| MERCHANT_AVAILABLE_BALANCE | &quot;MERCHANT_AVAILABLE_BALANCE&quot; |
| MERCHANT_TOTAL_BALANCE | &quot;MERCHANT_TOTAL_BALANCE&quot; |



