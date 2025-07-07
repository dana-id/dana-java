

# StatusDetail


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**acquirementStatus** | [**AcquirementStatusEnum**](#AcquirementStatusEnum) | Acquirement status. The enums:&lt;br&gt; * INIT - Order is created but not paid yet&lt;br&gt; * SUCCESS - Order is succeeded&lt;br&gt; * CLOSED - Order is closed&lt;br&gt; * PAYING - Order is paid but not finish&lt;br&gt; * MERCHANT_ACCEPT - Order is accepted by merchant after order is paid for PAY-CONFIRM&lt;br&gt; * CANCELLED - Order is cancelled&lt;br&gt;  |  |
|**frozen** | **String** | Whether the frozen is true or not |  [optional] |
|**cancelled** | **String** | Whether the cancelled is true or not |  [optional] |



## Enum: AcquirementStatusEnum

| Name | Value |
|---- | -----|
| INIT | &quot;INIT&quot; |
| SUCCESS | &quot;SUCCESS&quot; |
| CLOSED | &quot;CLOSED&quot; |
| PAYING | &quot;PAYING&quot; |
| MERCHANT_ACCEPT | &quot;MERCHANT_ACCEPT&quot; |
| CANCELLED | &quot;CANCELLED&quot; |



