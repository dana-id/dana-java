

# UpdateDivisionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant identifier |  |
|**divisionId** | **String** | Division identifier. Required when divisionIdType is INNER_ID |  [optional] |
|**divisionName** | **String** | Division name |  |
|**divisionAddress** | [**AddressInfo**](AddressInfo.md) |  |  |
|**divisionDescription** | **String** | Division description |  [optional] |
|**divisionType** | [**DivisionTypeEnum**](#DivisionTypeEnum) | Division type |  |
|**divisionIdType** | [**DivisionIdTypeEnum**](#DivisionIdTypeEnum) | Division identifier type |  |
|**externalDivisionId** | **String** | External division identifier. Required when divisionIdType is EXTERNAL_ID |  [optional] |
|**newExternalDivisionId** | **String** | New external division identifier |  |
|**logoUrlMap** | **Map&lt;String, String&gt;** | Logo URL map with base64 encoded images. Keys can be LOGO, PC_LOGO, MOBILE_LOGO |  [optional] |
|**mccCodes** | **List&lt;String&gt;** | Merchant category codes |  |
|**extInfo** | **Map&lt;String, Object&gt;** | Extended information |  |
|**apiVersion** | **String** | API version flag. Use &gt; 2 for new attributes |  [optional] |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. Required when apiVersion &gt; 2. \&quot;individu\&quot; entity can only use KTP and SIM. Other entities can use SIUP and NIB |  [optional] |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type. Required when apiVersion &gt; 2 |  [optional] |
|**businessEndDate** | **String** | Business end date, in format YYYY-MM-DD. Required when apiVersion &gt; 2 |  [optional] |
|**ownerName** | [**UserName**](UserName.md) |  |  [optional] |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  [optional] |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner identifier type. Required when apiVersion &gt; 2 |  [optional] |
|**ownerIdNo** | **String** | Owner identifier number. Required when apiVersion &gt; 2. Length depends on ownerIdType - KTP (16), SIM (12-14), Passport (8), NIB (&gt;&#x3D;13), SIUP (free text) |  [optional] |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director as a PIC of sub merchant. Required when apiVersion &gt; 2 |  [optional] |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non director which become a PIC of sub merchant. Required when apiVersion &gt; 2 |  [optional] |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type. Required when apiVersion &gt; 2 |  [optional] |
|**pgDivisionFlag** | [**PgDivisionFlagEnum**](#PgDivisionFlagEnum) | Flag if division is type PG |  [optional] |



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



## Enum: DivisionIdTypeEnum

| Name | Value |
|---- | -----|
| INNER_ID | &quot;INNER_ID&quot; |
| EXTERNAL_ID | &quot;EXTERNAL_ID&quot; |



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



