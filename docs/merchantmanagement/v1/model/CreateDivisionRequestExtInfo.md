

# CreateDivisionRequestExtInfo

Extended information

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**PIC_EMAIL** | **String** | PIC email address |  [optional] |
|**PIC_PHONENUMBER** | **String** | PIC phone number |  [optional] |
|**SUBMITTER_EMAIL** | **String** | Submitter email address |  [optional] |
|**GOODS_SOLD_TYPE** | [**GOODSSOLDTYPEEnum**](#GOODSSOLDTYPEEnum) | Type of goods sold |  [optional] |
|**USECASE** | **String** | Use case type |  [optional] |
|**USER_PROFILING** | [**USERPROFILINGEnum**](#USERPROFILINGEnum) | User profiling type |  [optional] |
|**AVG_TICKET** | **String** | Average ticket size |  [optional] |
|**OMZET** | **String** | Revenue range |  [optional] |
|**EXT_URLS** | **String** | External URLs |  [optional] |
|**BRAND_NAME** | **String** | Brand name |  [optional] |


<a name="GOODSSOLDTYPEEnum"></a>
## Enum: GOODSSOLDTYPEEnum

| Name | Value | Description |
| - | - | - |
| `DIGITAL` | "DIGITAL" |  |
| `PHYSICAL` | "PHYSICAL" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateDivisionRequestExtInfo.GOODSSOLDTYPEEnum;

public class Example {
    public static void main(String[] args) {
        GOODSSOLDTYPEEnum exampleEnum = GOODSSOLDTYPEEnum.DIGITAL;
    }
}
```


<a name="USERPROFILINGEnum"></a>
## Enum: USERPROFILINGEnum

| Name | Value | Description |
| - | - | - |
| `B2_B` | "B2B" |  |
| `B2_C` | "B2C" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.CreateDivisionRequestExtInfo.USERPROFILINGEnum;

public class Example {
    public static void main(String[] args) {
        USERPROFILINGEnum exampleEnum = USERPROFILINGEnum.B2_B;
    }
}
```



