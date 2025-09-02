

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


<a name="ParentRoleTypeEnum"></a>
## Enum: ParentRoleTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| MERCHANT | "MERCHANT" |  |
| DIVISION | "DIVISION" |  |
| EXTERNAL_DIVISION | "EXTERNAL_DIVISION" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.DivisionResourceInfo.ParentRoleTypeEnum;

public class Example {
    public static void main(String[] args) {
        ParentRoleTypeEnum exampleEnum = ParentRoleTypeEnum.MERCHANT;
    }
}
```


<a name="DivisionTypeEnum"></a>
## Enum: DivisionTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| REGION | "REGION" |  |
| AREA | "AREA" |  |
| BRANCH | "BRANCH" |  |
| OUTLET | "OUTLET" |  |
| STORE | "STORE" |  |
| KIOSK | "KIOSK" |  |
| STALL | "STALL" |  |
| COUNTER | "COUNTER" |  |
| BOOTH | "BOOTH" |  |
| POINT_OF_SALE | "POINT_OF_SALE" |  |
| VENDING_MACHINE | "VENDING_MACHINE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.DivisionResourceInfo.DivisionTypeEnum;

public class Example {
    public static void main(String[] args) {
        DivisionTypeEnum exampleEnum = DivisionTypeEnum.REGION;
    }
}
```


<a name="PgDivisionFlagEnum"></a>
## Enum: PgDivisionFlagEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| TRUE | "true" |  |
| FALSE | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.DivisionResourceInfo.PgDivisionFlagEnum;

public class Example {
    public static void main(String[] args) {
        PgDivisionFlagEnum exampleEnum = PgDivisionFlagEnum.TRUE;
    }
}
```



