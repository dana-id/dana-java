

# OrderApiObject


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**orderTitle** | **String** | Additional information of order title |  |
|**merchantTransType** | **String** | Additional information of merchant transaction type |  [optional] |
|**buyer** | [**Buyer**](Buyer.md) | Additional information of buyer |  [optional] |
|**goods** | [**List&lt;Goods&gt;**](Goods.md) | Additional information of goods |  [optional] |
|**shippingInfo** | [**List&lt;ShippingInfo&gt;**](ShippingInfo.md) | Additional information of shipping info |  [optional] |
|**extendInfo** | **String** | Additional information of extend |  [optional] |
|**createdTime** | **String** | Additional information of created time |  [optional] |
|**orderMemo** | **String** | Additional information of order |  [optional] |
|**scenario** | [**ScenarioEnum**](#ScenarioEnum) | For Payment Gateway scenario, need to fill it as API |  [optional] |


<a name="ScenarioEnum"></a>
## Enum: ScenarioEnum

| Name | Value | Description |
| - | - | - |
| `API` | "API" | For Payment Gateway scenario, need to fill it as API |

### Usage Example
```java
import id.dana.paymentgateway.v1.model.OrderApiObject.ScenarioEnum;

public class Example {
    public static void main(String[] args) {
        ScenarioEnum exampleEnum = ScenarioEnum.API;
    }
}
```



