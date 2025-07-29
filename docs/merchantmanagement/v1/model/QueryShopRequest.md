

# QueryShopRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant identifier. Required when shopIdType is EXTERNAL_ID |  [optional] |
|**shopId** | **String** | Shop identifier. Length depends on shopIdType - INNER_ID (21 max), EXTERNAL_ID (64 max) |  |
|**shopIdType** | [**ShopIdTypeEnum**](#ShopIdTypeEnum) | Shop identifier type |  |



## Enum: ShopIdTypeEnum

| Name | Value |
|---- | -----|
| INNER_ID | &quot;INNER_ID&quot; |
| EXTERNAL_ID | &quot;EXTERNAL_ID&quot; |



