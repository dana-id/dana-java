

# QueryDivisionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant identifier. Required when divisionIdType is EXTERNAL_ID |  [optional] |
|**divisionId** | **String** | Division identifier or external identifier. Length depends on divisionIdType - INNER_ID (21 max), EXTERNAL_ID (64 max) |  |
|**divisionIdType** | [**DivisionIdTypeEnum**](#DivisionIdTypeEnum) | Division identifier type |  |



## Enum: DivisionIdTypeEnum

| Name | Value |
|---- | -----|
| INNER_ID | &quot;INNER_ID&quot; |
| EXTERNAL_ID | &quot;EXTERNAL_ID&quot; |



