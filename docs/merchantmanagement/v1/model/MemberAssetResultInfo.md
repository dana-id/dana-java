

# MemberAssetResultInfo

Result information for member asset Open APIs (`resultInfo` per DANA spec)

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**resultStatus** | [**ResultStatusEnum**](#ResultStatusEnum) | Request status (`ResultStatus`). S=Success, F=Failure, U=Unknown |  |
|**resultCodeId** | **String** | Result code identifier (`ResultCodeId`) |  |
|**resultCode** | **String** | Result code (`ResultCode`) |  |
|**resultMsg** | **String** | Result message (`ResultMsg`). Optional per API contract |  [optional] |


<a name="ResultStatusEnum"></a>
## Enum: ResultStatusEnum

| Name | Value | Description |
| - | - | - |
| `S` | "S" | Success |
| `F` | "F" | Failure |
| `U` | "U" | Unknown |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MemberAssetResultInfo.ResultStatusEnum;

public class Example {
    public static void main(String[] args) {
        ResultStatusEnum exampleEnum = ResultStatusEnum.S;
    }
}
```



