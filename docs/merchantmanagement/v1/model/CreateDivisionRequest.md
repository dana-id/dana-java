

# CreateDivisionRequest


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**apiVersion** | **String** | API Version. As per the respective API reference. Must be > 2 |  |
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
|**businessDocs** | [**List&lt;BusinessDocs&gt;**](BusinessDocs.md) | Business documents. \"individu\" entity can only use KTP and SIM. Other entities can use SIUP and NIB |  |
|**businessEntity** | [**BusinessEntityEnum**](#BusinessEntityEnum) | Business entity type |  |
|**ownerName** | [**UserName**](UserName.md) |  |  |
|**ownerPhoneNumber** | [**MobileNoInfo**](MobileNoInfo.md) |  |  |
|**ownerIdType** | [**OwnerIdTypeEnum**](#OwnerIdTypeEnum) | Owner identifier type |  |
|**ownerIdNo** | **String** | Owner identifier number. Length depends on ownerIdType - KTP (16), SIM (12-14), Passport (8), NIB (>=13), SIUP (free text) |  |
|**ownerAddress** | [**AddressInfo**](AddressInfo.md) |  |  |
|**directorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Director as a PIC of sub merchant |  |
|**nonDirectorPics** | [**List&lt;PicInfo&gt;**](PicInfo.md) | Non director which become a PIC of sub merchant |  |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type |  |
|**pgDivisionFlag** | [**PgDivisionFlagEnum**](#PgDivisionFlagEnum) | Flag if division is type PG |  [optional] |


<a name="ParentRoleTypeEnum"></a>
## Enum: ParentRoleTypeEnum

| Name | Value | Description |
| - | - | - |
| `MERCHANT` | "MERCHANT" |  |
| `DIVISION` | "DIVISION" |  |
| `EXTERNAL_DIVISION` | "EXTERNAL_DIVISION" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateDivisionRequest.ParentRoleTypeEnum;

public class Example {
    public static void main(String[] args) {
        ParentRoleTypeEnum exampleEnum = ParentRoleTypeEnum.MERCHANT;
    }
}
```


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
import id.dana.merchantmanagement.v1.model.CreateDivisionRequest.DivisionTypeEnum;

public class Example {
    public static void main(String[] args) {
        DivisionTypeEnum exampleEnum = DivisionTypeEnum.REGION;
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
import id.dana.merchantmanagement.v1.model.CreateDivisionRequest.BusinessEntityEnum;

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
import id.dana.merchantmanagement.v1.model.CreateDivisionRequest.OwnerIdTypeEnum;

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
import id.dana.merchantmanagement.v1.model.CreateDivisionRequest.SizeTypeEnum;

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
import id.dana.merchantmanagement.v1.model.CreateDivisionRequest.PgDivisionFlagEnum;

public class Example {
    public static void main(String[] args) {
        PgDivisionFlagEnum exampleEnum = PgDivisionFlagEnum.TRUE;
    }
}
```



