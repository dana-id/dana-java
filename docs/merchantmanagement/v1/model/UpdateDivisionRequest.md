

# UpdateDivisionRequest


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
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
|**apiVersion** | **String** | API version flag. Use > 2 for new attributes |  [optional] |
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. Required when apiVersion > 2. \"individu\" entity can only use KTP and SIM. Other entities can use SIUP and NIB |  [optional] |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type. Required when apiVersion > 2 |  [optional] |
|**businessEndDate** | **String** | Business end date, in format YYYY-MM-DD. Required when apiVersion > 2 |  [optional] |
|**ownerName** | [**UserName**](UserName.md) |  |  [optional] |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  [optional] |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner identifier type. Required when apiVersion > 2 |  [optional] |
|**ownerIdNo** | **String** | Owner identifier number. Required when apiVersion > 2. Length depends on ownerIdType - KTP (16), SIM (12-14), Passport (8), NIB (>=13), SIUP (free text) |  [optional] |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director as a PIC of sub merchant. Required when apiVersion > 2 |  [optional] |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non director which become a PIC of sub merchant. Required when apiVersion > 2 |  [optional] |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type. Required when apiVersion > 2 |  [optional] |
|**pgDivisionFlag** | [**PgDivisionFlagEnum**](#PgDivisionFlagEnum) | Flag if division is type PG |  [optional] |


<a name="DivisionTypeEnum"></a>
## Enum: DivisionTypeEnum

| Name | Value | Description |
| - | - | - |
| `REGION` | "REGION" |  |
| `AREA` | "AREA" |  |
| `BRANCH` | "BRANCH" |  |
| `OUTLET` | "OUTLET" |  |
| `STORE` | "STORE" |  |
| `KIOSK` | "KIOSK" |  |
| `STALL` | "STALL" |  |
| `COUNTER` | "COUNTER" |  |
| `BOOTH` | "BOOTH" |  |
| `POINT_OF_SALE` | "POINT_OF_SALE" |  |
| `VENDING_MACHINE` | "VENDING_MACHINE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest.DivisionTypeEnum;

public class Example {
    public static void main(String[] args) {
        DivisionTypeEnum exampleEnum = DivisionTypeEnum.REGION;
    }
}
```


<a name="DivisionIdTypeEnum"></a>
## Enum: DivisionIdTypeEnum

| Name | Value | Description |
| - | - | - |
| `INNER_ID` | "INNER_ID" |  |
| `EXTERNAL_ID` | "EXTERNAL_ID" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest.DivisionIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        DivisionIdTypeEnum exampleEnum = DivisionIdTypeEnum.INNER_ID;
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
import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest.BusinessEntityEnum;

public class Example {
    public static void main(String[] args) {
        BusinessEntityEnum exampleEnum = BusinessEntityEnum.PT;
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
import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest.OwnerIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        OwnerIdTypeEnum exampleEnum = OwnerIdTypeEnum.KTP;
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
| `URE` | "URE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest.SizeTypeEnum;

public class Example {
    public static void main(String[] args) {
        SizeTypeEnum exampleEnum = SizeTypeEnum.UMI;
    }
}
```


<a name="PgDivisionFlagEnum"></a>
## Enum: PgDivisionFlagEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest.PgDivisionFlagEnum;

public class Example {
    public static void main(String[] args) {
        PgDivisionFlagEnum exampleEnum = PgDivisionFlagEnum.TRUE;
    }
}
```



