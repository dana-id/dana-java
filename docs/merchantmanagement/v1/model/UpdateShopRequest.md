

# UpdateShopRequest


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
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
|**ln** | **String** | Longitude of shop's location |  [optional] |
|**lat** | **String** | Latitude of shop's location |  [optional] |
|**loyalty** | [**LoyaltyEnum**](#LoyaltyEnum) | Flag for loyalty category |  [optional] |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**ownerName** | [**UserName**](UserName.md) |  |  [optional] |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  [optional] |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner identifier type |  [optional] |
|**ownerIdNo** | **String** | Owner identifier number. Length depends on ownerIdType - KTP (16), SIM (12-14), Passport (8), NIB (>=13), SIUP (free text) |  [optional] |
|**deviceNumber** | **String** | Device number |  [optional] |
|**posNumber** | **String** | POS number |  [optional] |
|**apiVersion** | **String** | API version flag. Use > 2 for new attributes |  [optional] |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type |  [optional] |
|**shopOwning** | [**ShopOwningEnum**](#ShopOwningEnum) | Shop owning information |  [optional] |
|**shopBizType** | [**ShopBizTypeEnum**](#ShopBizTypeEnum) | Shop business type |  [optional] |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. \"individu\" entity can only use KTP and SIM. Other entities can use SIUP and NIB |  [optional] |
|**businessEndDate** | **String** | Business end date, in format YYYY-MM-dd |  [optional] |
|**taxNo** | **String** | Tax number (NPWP). Must be 15 digits |  [optional] |
|**taxAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**brandName** | **String** | Brand name on legal name or tax name |  [optional] |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director as a PIC of shop |  [optional] |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non director which become an PIC of shop |  [optional] |


<a name="ShopIdTypeEnum"></a>
## Enum: ShopIdTypeEnum

| Name | Value | Description |
| - | - | - |
| `INNER_ID` | "INNER_ID" |  |
| `EXTERNAL_ID` | "EXTERNAL_ID" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.ShopIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        ShopIdTypeEnum exampleEnum = ShopIdTypeEnum.INNER_ID;
    }
}
```


<a name="SizeTypeEnum"></a>
## Enum: SizeTypeEnum

| Name | Value | Description |
| - | - | - |
| `UMI` | "UMI" |  |
| `UKE` | "UKE" |  |
| `UME` | "UME" |  |
| `UBE` | "UBE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.SizeTypeEnum;

public class Example {
    public static void main(String[] args) {
        SizeTypeEnum exampleEnum = SizeTypeEnum.UMI;
    }
}
```


<a name="LoyaltyEnum"></a>
## Enum: LoyaltyEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.LoyaltyEnum;

public class Example {
    public static void main(String[] args) {
        LoyaltyEnum exampleEnum = LoyaltyEnum.TRUE;
    }
}
```


<a name="OwnerIdTypeEnum"></a>
## Enum: OwnerIdTypeEnum

| Name | Value | Description |
| - | - | - |
| `KTP` | "KTP" |  |
| `SIM` | "SIM" |  |
| `PASSPORT` | "PASSPORT" |  |
| `SIUP` | "SIUP" |  |
| `NIB` | "NIB" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.OwnerIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        OwnerIdTypeEnum exampleEnum = OwnerIdTypeEnum.KTP;
    }
}
```


<a name="BusinessEntityEnum"></a>
## Enum: BusinessEntityEnum

| Name | Value | Description |
| - | - | - |
| `PT` | "pt" |  |
| `CV` | "cv" |  |
| `INDIVIDU` | "individu" |  |
| `USAHA_DAGANG` | "usaha_dagang" |  |
| `YAYASAN` | "yayasan" |  |
| `KOPERASI` | "koperasi" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.BusinessEntityEnum;

public class Example {
    public static void main(String[] args) {
        BusinessEntityEnum exampleEnum = BusinessEntityEnum.PT;
    }
}
```


<a name="ShopOwningEnum"></a>
## Enum: ShopOwningEnum

| Name | Value | Description |
| - | - | - |
| `DIRECT_OWNED` | "DIRECT_OWNED" |  |
| `FRANCHISED` | "FRANCHISED" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.ShopOwningEnum;

public class Example {
    public static void main(String[] args) {
        ShopOwningEnum exampleEnum = ShopOwningEnum.DIRECT_OWNED;
    }
}
```


<a name="ShopBizTypeEnum"></a>
## Enum: ShopBizTypeEnum

| Name | Value | Description |
| - | - | - |
| `ONLINE` | "ONLINE" |  |
| `OFFLINE` | "OFFLINE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateShopRequest.ShopBizTypeEnum;

public class Example {
    public static void main(String[] args) {
        ShopBizTypeEnum exampleEnum = ShopBizTypeEnum.ONLINE;
    }
}
```



