

# DivisionResourceInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**divisionId** | **String** | Division identifier |  [optional] |
|**merchantId** | **String** | Merchant identifier |  [optional] |
|**parentRoleType** | [**ParentRoleTypeEnum**](#ParentRoleTypeEnum) | Parent role type |  [optional] |
|**contactAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**divisionDescription** | **String** | Division description |  [optional] |
|**divisionType** | [**DivisionTypeEnum**](#DivisionTypeEnum) | Division type |  [optional] |
|**divisionName** | **String** | Division name |  [optional] |
|**externalDivisionId** | **String** | External division identifier |  [optional] |
|**pgDivisionFlag** | [**PgDivisionFlagEnum**](#PgDivisionFlagEnum) | Flag if division is type PG |  [optional] |



## Enum: ParentRoleTypeEnum

| Name | Value |
|---- | -----|
| MERCHANT | &quot;MERCHANT&quot; |
| DIVISION | &quot;DIVISION&quot; |
| EXTERNAL_DIVISION | &quot;EXTERNAL_DIVISION&quot; |



## Enum: DivisionTypeEnum

| Name | Value |
|---- | -----|
| REGION | &quot;REGION&quot; |
| AREA | &quot;AREA&quot; |
| BRANCH | &quot;BRANCH&quot; |
| OUTLET | &quot;OUTLET&quot; |
| STORE | &quot;STORE&quot; |
| KIOSK | &quot;KIOSK&quot; |
| STALL | &quot;STALL&quot; |
| COUNTER | &quot;COUNTER&quot; |
| BOOTH | &quot;BOOTH&quot; |
| POINT_OF_SALE | &quot;POINT_OF_SALE&quot; |
| VENDING_MACHINE | &quot;VENDING_MACHINE&quot; |



## Enum: PgDivisionFlagEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



