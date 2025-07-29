

# CreateShopRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant id |  |
|**parentDivisionId** | **String** | Parent division ID. Required when shopParentType is DIVISION or EXTERNAL_DIVISION |  [optional] |
|**shopParentType** | [**ShopParentTypeEnum**](#ShopParentTypeEnum) | Parent type for the shop |  |
|**mainName** | **String** | Shop name |  |
|**shopAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**shopDesc** | **String** | Shop description |  [optional] |
|**externalShopId** | **String** | External shop identifier |  |
|**logoUrlMap** | **Map&lt;String, String&gt;** | Logo images encoded in base64. Keys can be LOGO, PC_LOGO, MOBILE_LOGO. Images must be PNG format. |  [optional] |
|**mccCodes** | **List&lt;String&gt;** | MCC codes |  [optional] |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type of the shop |  |
|**ln** | **String** | Longitude |  [optional] |
|**lat** | **String** | Latitude |  [optional] |
|**taxNo** | **String** | Tax number (NPWP). Must be 15 digits |  [optional] |
|**brandName** | **String** | Legal name/tax name |  [optional] |
|**taxAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**loyalty** | [**LoyaltyEnum**](#LoyaltyEnum) | Flag for loyalty category |  [optional] |
|**apiVersion** | **String** | API version flag. Use &gt; 2 for new attributes |  [optional] |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type. Required if apiVersion &gt; 2 |  [optional] |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. Required if apiVersion &gt; 2 |  [optional] |
|**ownerName** | [**UserName**](UserName.md) |  |  [optional] |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner ID type. Required if apiVersion &gt; 2 |  [optional] |
|**ownerIdNo** | **String** | Owner ID number. Required if apiVersion &gt; 2 |  [optional] |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  [optional] |
|**shopOwning** | [**ShopOwningEnum**](#ShopOwningEnum) | Shop ownership type. Required if apiVersion &gt; 2 |  [optional] |
|**deviceNumber** | **String** | Device number. Required if apiVersion &gt; 2 |  [optional] |
|**posNumber** | **String** | POS number. Required if apiVersion &gt; 2 |  [optional] |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director PICs. Required if apiVersion &gt; 2 |  [optional] |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non-director PICs. Required if apiVersion &gt; 2 |  [optional] |
|**shopBizType** | **String** | Shop business type |  [optional] |
|**extInfo** | **Map&lt;String, Object&gt;** | Extended information |  [optional] |



## Enum: ShopParentTypeEnum

| Name | Value |
|---- | -----|
| MERCHANT | &quot;MERCHANT&quot; |
| DIVISION | &quot;DIVISION&quot; |
| EXTERNAL_DIVISION | &quot;EXTERNAL_DIVISION&quot; |



## Enum: SizeTypeEnum

| Name | Value |
|---- | -----|
| UMI | &quot;UMI&quot; |
| UKE | &quot;UKE&quot; |
| UME | &quot;UME&quot; |
| UBE | &quot;UBE&quot; |



## Enum: LoyaltyEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



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



## Enum: ShopOwningEnum

| Name | Value |
|---- | -----|
| DIRECT_OWNED | &quot;DIRECT_OWNED&quot; |
| FRANCHISED | &quot;FRANCHISED&quot; |



