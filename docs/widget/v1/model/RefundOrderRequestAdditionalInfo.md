

# RefundOrderRequestAdditionalInfo

Additional information

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payoutAccountNo** | **String** | Additional information of payout account number. This param need to be filled if want to refund to specific payout account not that specified by DANA |  [optional] |
|**refundAppliedTime** | **String** | Additional information of refund applied time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**actorType** | **String** | Additional information of actor type, refer to ActorTypeEnum |  [optional] |
|**returnChargeToPayer** | **String** | Additional information of return charge to payer |  [optional] |
|**destination** | **String** | Additional information of destination |  [optional] |
|**envInfo** | **Object** | Additional information of environment |  |
|**auditInfo** | **Object** | Additional information of audit |  [optional] |
|**actorContext** | **Object** | Additional information of actor context |  [optional] |
|**refundOptionBill** | **List&lt;Object&gt;** | Additional information of refund option bill |  [optional] |
|**extendInfo** | **String** | Additional information of extend |  [optional] |
|**asyncRefund** | **String** | Additional information of async refund to determine the process of refund whether sync or async. The values is true/false |  [optional] |



