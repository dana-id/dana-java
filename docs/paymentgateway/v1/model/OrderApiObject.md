

# OrderApiObject


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orderTitle** | **String** | Additional information of order title |  |
|**merchantTransType** | **String** | Additional information of merchant transaction type |  [optional] |
|**buyer** | [**Buyer**](Buyer.md) | Additional information of buyer |  [optional] |
|**goods** | [**List&lt;Goods&gt;**](Goods.md) | Additional information of goods |  [optional] |
|**shippingInfo** | [**List&lt;ShippingInfo&gt;**](ShippingInfo.md) | Additional information of shipping info |  [optional] |
|**extendInfo** | **String** | Additional information of extend |  [optional] |
|**createdTime** | **String** | Additional information of created time |  [optional] |
|**orderMemo** | **String** | Additional information of order |  [optional] |
|**scenario** | [**ScenarioEnum**](#ScenarioEnum) | For Payment Gateway scenario, need to fill it as API |  [optional] |



## Enum: ScenarioEnum

| Name | Value |
|---- | -----|
| API | &quot;API&quot; |



