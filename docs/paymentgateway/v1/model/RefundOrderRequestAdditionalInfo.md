

# RefundOrderRequestAdditionalInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payoutAccountNo** | **String** | Additional information of payout account number. This param need to be filled if want to refund to specific payout account not that specified by DANA |  [optional] |
|**refundAppliedTime** | **String** | Additional information of refund applied time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**actorType** | [**ActorTypeEnum**](#ActorTypeEnum) | Additional information of actor type. The enums:<br> * USER - User<br> * MERCHANT - Merchant<br> * MERCHANT_OPERATOR - Merchant operator<br> * BACK_OFFICE - Back office<br> * SYSTEM - System<br>  |  [optional] |
|**returnChargeToPayer** | **String** | Additional information of return charge to payer |  [optional] |
|**destination** | **String** | Additional information of destination |  [optional] |
|**envInfo** | [**EnvInfo**](EnvInfo.md) | Additional information of environment |  [optional] |
|**auditInfo** | [**AuditInfo**](AuditInfo.md) | Additional information of audit |  [optional] |
|**actorContext** | [**ActorContext**](ActorContext.md) | Additional information of actor context |  [optional] |
|**refundOptionBill** | [**List&lt;RefundOptionBill&gt;**](RefundOptionBill.md) | Additional information of refund option bill |  [optional] |
|**extendInfo** | **String** | Additional information of extend |  [optional] |
|**asyncRefund** | **String** | Additional information of async refund to determine the process of refund whether sync or async. The values is true/false |  [optional] |


<a name="ActorTypeEnum"></a>
## Enum: ActorTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| USER | "USER" | User |
| MERCHANT | "MERCHANT" | Merchant |
| MERCHANT_OPERATOR | "MERCHANT_OPERATOR" | Merchant operator |
| BACK_OFFICE | "BACK_OFFICE" | Back office |
| SYSTEM | "SYSTEM" | System |

### Usage Example
```java
import id.dana.paymentgateway.v1.model.RefundOrderRequestAdditionalInfo.ActorTypeEnum;

public class Example {
    public static void main(String[] args) {
        ActorTypeEnum exampleEnum = ActorTypeEnum.USER;
    }
}
```



