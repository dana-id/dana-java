

# RefundOrderRequestAdditionalInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payoutAccountNo** | **String** | Additional information of payout account number. This param need to be filled if want to refund to specific payout account not that specified by DANA |  [optional] |
|**refundAppliedTime** | **String** | Additional information of refund applied time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**actorType** | [**ActorTypeEnum**](#ActorTypeEnum) | Additional information of actor type. The enums:&lt;br&gt; * USER - User&lt;br&gt; * MERCHANT - Merchant&lt;br&gt; * MERCHANT_OPERATOR - Merchant operator&lt;br&gt; * BACK_OFFICE - Back office&lt;br&gt; * SYSTEM - System&lt;br&gt;  |  [optional] |
|**returnChargeToPayer** | **String** | Additional information of return charge to payer |  [optional] |
|**destination** | **String** | Additional information of destination |  [optional] |
|**envInfo** | [**EnvInfo**](EnvInfo.md) | Additional information of environment |  [optional] |
|**auditInfo** | [**AuditInfo**](AuditInfo.md) | Additional information of audit |  [optional] |
|**actorContext** | [**ActorContext**](ActorContext.md) | Additional information of actor context |  [optional] |
|**refundOptionBill** | [**List&lt;RefundOptionBill&gt;**](RefundOptionBill.md) | Additional information of refund option bill |  [optional] |
|**extendInfo** | **String** | Additional information of extend |  [optional] |
|**asyncRefund** | **String** | Additional information of async refund to determine the process of refund whether sync or async. The values is true/false |  [optional] |



## Enum: ActorTypeEnum

| Name | Value |
|---- | -----|
| USER | &quot;USER&quot; |
| MERCHANT | &quot;MERCHANT&quot; |
| MERCHANT_OPERATOR | &quot;MERCHANT_OPERATOR&quot; |
| BACK_OFFICE | &quot;BACK_OFFICE&quot; |
| SYSTEM | &quot;SYSTEM&quot; |



