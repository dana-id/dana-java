

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
|**apiVersion** | **String** | API version flag. Use > 2 for new attributes |  [optional] |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type. Required if apiVersion > 2 |  [optional] |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. Required if apiVersion > 2 |  [optional] |
|**ownerName** | [**UserName**](UserName.md) |  |  [optional] |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner ID type. Required if apiVersion > 2 |  [optional] |
|**ownerIdNo** | **String** | Owner ID number. Required if apiVersion > 2 |  [optional] |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  [optional] |
|**shopOwning** | [**ShopOwningEnum**](#ShopOwningEnum) | Shop ownership type. Required if apiVersion > 2 |  [optional] |
|**deviceNumber** | **String** | Device number. Required if apiVersion > 2 |  [optional] |
|**posNumber** | **String** | POS number. Required if apiVersion > 2 |  [optional] |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director PICs. Required if apiVersion > 2 |  [optional] |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non-director PICs. Required if apiVersion > 2 |  [optional] |
|**shopBizType** | **String** | Shop business type |  [optional] |
|**extInfo** | **Map&lt;String, Object&gt;** | Extended information |  [optional] |


<a name="ShopParentTypeEnum"></a>
## Enum: ShopParentTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| MERCHANT | "MERCHANT" |  |
| DIVISION | "DIVISION" |  |
| EXTERNAL_DIVISION | "EXTERNAL_DIVISION" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateShopRequest.ShopParentTypeEnum;

public class Example {
    public static void main(String[] args) {
        ShopParentTypeEnum exampleEnum = ShopParentTypeEnum.MERCHANT;
    }
}
```


<a name="SizeTypeEnum"></a>
## Enum: SizeTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| UMI | "UMI" |  |
| UKE | "UKE" |  |
| UME | "UME" |  |
| UBE | "UBE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateShopRequest.SizeTypeEnum;

public class Example {
    public static void main(String[] args) {
        SizeTypeEnum exampleEnum = SizeTypeEnum.UMI;
    }
}
```


<a name="LoyaltyEnum"></a>
## Enum: LoyaltyEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| TRUE | "true" |  |
| FALSE | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateShopRequest.LoyaltyEnum;

public class Example {
    public static void main(String[] args) {
        LoyaltyEnum exampleEnum = LoyaltyEnum.TRUE;
    }
}
```


<a name="BusinessEntityEnum"></a>
## Enum: BusinessEntityEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| PT | "pt" |  |
| CV | "cv" |  |
| INDIVIDU | "individu" |  |
| USAHA_DAGANG | "usaha_dagang" |  |
| YAYASAN | "yayasan" |  |
| KOPERASI | "koperasi" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateShopRequest.BusinessEntityEnum;

public class Example {
    public static void main(String[] args) {
        BusinessEntityEnum exampleEnum = BusinessEntityEnum.PT;
    }
}
```


<a name="OwnerIdTypeEnum"></a>
## Enum: OwnerIdTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| KTP | "KTP" |  |
| SIM | "SIM" |  |
| PASSPORT | "PASSPORT" |  |
| SIUP | "SIUP" |  |
| NIB | "NIB" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateShopRequest.OwnerIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        OwnerIdTypeEnum exampleEnum = OwnerIdTypeEnum.KTP;
    }
}
```


<a name="ShopOwningEnum"></a>
## Enum: ShopOwningEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| DIRECT_OWNED | "DIRECT_OWNED" |  |
| FRANCHISED | "FRANCHISED" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateShopRequest.ShopOwningEnum;

public class Example {
    public static void main(String[] args) {
        ShopOwningEnum exampleEnum = ShopOwningEnum.DIRECT_OWNED;
    }
}
```



