

# ActorContext


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**actorId** | **String** | Actor identifier |  [optional] |
|**actorType** | [**ActorTypeEnum**](#ActorTypeEnum) | Actor type. The enums:<br> * USER - User<br> * MERCHANT - Merchant<br> * MERCHANT_OPERATOR - Merchant operator<br> * BACK_OFFICE - Back office<br> * SYSTEM - System<br>  |  [optional] |


<a name="ActorTypeEnum"></a>
## Enum: ActorTypeEnum

| Name | Value | Description |
| - | - | - |
| `USER` | "USER" | User |
| `MERCHANT` | "MERCHANT" | Merchant |
| `MERCHANT_OPERATOR` | "MERCHANT_OPERATOR" | Merchant operator |
| `BACK_OFFICE` | "BACK_OFFICE" | Back office |
| `SYSTEM` | "SYSTEM" | System |

### Usage Example
```java
import id.dana.paymentgateway.v1.model.ActorContext.ActorTypeEnum;

public class Example {
    public static void main(String[] args) {
        ActorTypeEnum exampleEnum = ActorTypeEnum.USER;
    }
}
```



