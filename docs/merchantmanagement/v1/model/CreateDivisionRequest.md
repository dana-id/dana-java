

# CreateDivisionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**apiVersion** | **String** | API Version. As per the respective API reference. Must be &gt; 2 |  |
|**merchantId** | **String** | Merchant identifier |  |
|**parentDivisionId** | **String** | Parent division identifier. Required when parentRoleType is DIVISION or EXTERNAL_DIVISION. Length depends on parentRoleType - DIVISION (21 max), EXTERNAL_DIVISION (64 max) |  [optional] |
|**parentRoleType** | [**ParentRoleTypeEnum**](#ParentRoleTypeEnum) | Type of parent role |  |
|**divisionName** | **String** | Division name |  |
|**divisionAddress** | [**AddressInfo**](AddressInfo.md) |  |  |
|**divisionDescription** | **String** | Division description |  [optional] |
|**divisionType** | [**DivisionTypeEnum**](#DivisionTypeEnum) | Division type |  |
|**externalDivisionId** | **String** | External division identifier |  |
|**logoUrlMap** | **Map&lt;String, String&gt;** | Logo URL map with base64 encoded images. Keys can be LOGO, PC_LOGO, MOBILE_LOGO |  [optional] |
|**extInfo** | [**CreateDivisionRequestExtInfo**](CreateDivisionRequestExtInfo.md) |  |  |
|**mccCodes** | **List&lt;String&gt;** | Merchant category codes |  |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. \&quot;individu\&quot; entity can only use KTP and SIM. Other entities can use SIUP and NIB |  |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type |  |
|**ownerName** | [**UserName**](UserName.md) |  |  |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner identifier type |  |
|**ownerIdNo** | **String** | Owner identifier number. Length depends on ownerIdType - KTP (16), SIM (12-14), Passport (8), NIB (&gt;&#x3D;13), SIUP (free text) |  |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director as a PIC of sub merchant |  |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non director which become a PIC of sub merchant |  |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type |  |
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



## Enum: BusinessEntityEnum

| Name | Value |
|---- | -----|
| PT | &quot;pt&quot; |
| CV | &quot;cv&quot; |
| INDIVIDU | &quot;individu&quot; |
| USAHA_DAGANG | &quot;usaha_dagang&quot; |
| YAYASAN | &quot;yayasan&quot; |
| KOPERASI | &quot;koperasi&quot; |



## Enum: OwnerIdTypeEnum

| Name | Value |
|---- | -----|
| KTP | &quot;KTP&quot; |
| SIM | &quot;SIM&quot; |
| PASSPORT | &quot;PASSPORT&quot; |
| SIUP | &quot;SIUP&quot; |
| NIB | &quot;NIB&quot; |



## Enum: SizeTypeEnum

| Name | Value |
|---- | -----|
| UMI | &quot;UMI&quot; |
| UKE | &quot;UKE&quot; |
| UME | &quot;UME&quot; |
| UBE | &quot;UBE&quot; |
| URE | &quot;URE&quot; |



## Enum: PgDivisionFlagEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



