

# MobileNoInfo


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**mobileNo** | **String** | Mobile number. Accepted formats: 0xxxxxxxx, 62xxxxxxx, 62-xxxxxxx, +62xxxxxx |  [optional] |
|**mobileId** | **String** | Mobile ID |  [optional] |
|**verified** | [**VerifiedEnum**](#VerifiedEnum) | Verification status |  [optional] |


<a name="VerifiedEnum"></a>
## Enum: VerifiedEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MobileNoInfo.VerifiedEnum;

public class Example {
    public static void main(String[] args) {
        VerifiedEnum exampleEnum = VerifiedEnum.TRUE;
    }
}
```



