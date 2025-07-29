

# UpdateShopRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shopId** | **String** | Shop identifier. Length depends on shopIdType - INNER_ID (21 max), EXTERNAL_ID (64 max) |  |
|**merchantId** | **String** | Merchant identifier |  |
|**shopIdType** | [**ShopIdTypeEnum**](#ShopIdTypeEnum) | Shop identifier type |  |
|**mainName** | **String** | Shop name |  [optional] |
|**shopAddress** | [**AddressInfo**](AddressInfo.md) |  |  |
|**shopDesc** | **String** | Shop description |  [optional] |
|**newExternalShopId** | **String** | New external shop identifier |  [optional] |
|**mccCodes** | **List&lt;String&gt;** | Merchant category code |  [optional] |
|**logoUrlMap** | **Map&lt;String, String&gt;** | Logo URL map with base64 encoded images. Keys can be LOGO, PC_LOGO, MOBILE_LOGO |  [optional] |
|**extInfo** | **Map&lt;String, Object&gt;** | Extend information |  [optional] |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type |  [optional] |
|**ln** | **String** | Longitude of shop&#39;s location |  [optional] |
|**lat** | **String** | Latitude of shop&#39;s location |  [optional] |
|**loyalty** | [**LoyaltyEnum**](#LoyaltyEnum) | Flag for loyalty category |  [optional] |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**ownerName** | [**UserName**](UserName.md) |  |  [optional] |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  [optional] |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner identifier type |  [optional] |
|**ownerIdNo** | **String** | Owner identifier number. Length depends on ownerIdType - KTP (16), SIM (12-14), Passport (8), NIB (&gt;&#x3D;13), SIUP (free text) |  [optional] |
|**deviceNumber** | **String** | Device number |  [optional] |
|**posNumber** | **String** | POS number |  [optional] |
|**apiVersion** | **String** | API version flag. Use &gt; 2 for new attributes |  [optional] |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type |  [optional] |
|**shopOwning** | [**ShopOwningEnum**](#ShopOwningEnum) | Shop owning information |  [optional] |
|**shopBizType** | [**ShopBizTypeEnum**](#ShopBizTypeEnum) | Shop business type |  [optional] |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. \&quot;individu\&quot; entity can only use KTP and SIM. Other entities can use SIUP and NIB |  [optional] |
|**businessEndDate** | **String** | Business end date, in format YYYY-MM-dd |  [optional] |
|**taxNo** | **String** | Tax number (NPWP). Must be 15 digits |  [optional] |
|**taxAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**brandName** | **String** | Brand name on legal name or tax name |  [optional] |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director as a PIC of shop |  [optional] |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non director which become an PIC of shop |  [optional] |



## Enum: ShopIdTypeEnum

| Name | Value |
|---- | -----|
| INNER_ID | &quot;INNER_ID&quot; |
| EXTERNAL_ID | &quot;EXTERNAL_ID&quot; |



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



## Enum: OwnerIdTypeEnum

| Name | Value |
|---- | -----|
| KTP | &quot;KTP&quot; |
| SIM | &quot;SIM&quot; |
| PASSPORT | &quot;PASSPORT&quot; |
| SIUP | &quot;SIUP&quot; |
| NIB | &quot;NIB&quot; |



## Enum: BusinessEntityEnum

| Name | Value |
|---- | -----|
| PT | &quot;pt&quot; |
| CV | &quot;cv&quot; |
| INDIVIDU | &quot;individu&quot; |
| USAHA_DAGANG | &quot;usaha_dagang&quot; |
| YAYASAN | &quot;yayasan&quot; |
| KOPERASI | &quot;koperasi&quot; |



## Enum: ShopOwningEnum

| Name | Value |
|---- | -----|
| DIRECT_OWNED | &quot;DIRECT_OWNED&quot; |
| FRANCHISED | &quot;FRANCHISED&quot; |



## Enum: ShopBizTypeEnum

| Name | Value |
|---- | -----|
| ONLINE | &quot;ONLINE&quot; |
| OFFLINE | &quot;OFFLINE&quot; |



