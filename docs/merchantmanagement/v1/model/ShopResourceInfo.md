

# ShopResourceInfo


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**merchantId** | **String** | Merchant identifier |  [optional] |
|**parentDivisionId** | **String** | Parent division identifier |  [optional] |
|**parentRoleType** | **String** | Parent role type |  [optional] |
|**mainName** | **String** | Shop name |  [optional] |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type |  [optional] |
|**shopAddress** | [**AddressInfo**](AddressInfo.md) |  |  [optional] |
|**externalShopId** | **String** | External shop identifier |  [optional] |
|**logoUrlMap** | **Map&lt;String, String&gt;** | Logo URL map with base64 encoded images |  [optional] |
|**extInfo** | **Object** | Extended information |  [optional] |
|**ln** | **String** | Longitude |  [optional] |
|**lat** | **String** | Latitude |  [optional] |
|**nmid** | **String** | Network merchant identifier |  [optional] |


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
import id.dana.merchantmanagement.v1.model.ShopResourceInfo.SizeTypeEnum;

public class Example {
    public static void main(String[] args) {
        SizeTypeEnum exampleEnum = SizeTypeEnum.UMI;
    }
}
```



