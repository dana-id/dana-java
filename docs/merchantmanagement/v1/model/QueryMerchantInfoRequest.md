

# QueryMerchantInfoRequest

Business fields mapped to `request.body` in the JSON envelope (head/signature are handled by the client/runtime).

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**roleId** | **String** | Login identifier value (format depends on `loginType`, e.g. `{countryCode}-{mobileNo}` when `loginType` is `MOBILE_NO`) |  |
|**loginType** | [**LoginTypeEnum**](#LoginTypeEnum) | Login identifier type used with `roleId` |  |
|**isQueryAccount** | **Boolean** | When true, include merchant account list in the response |  [optional] |


<a name="LoginTypeEnum"></a>
## Enum: LoginTypeEnum

| Name | Value | Description |
| - | - | - |
| `ROLE` | "ROLE" |  |
| `MOBILE_NO` | "MOBILE_NO" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryMerchantInfoRequest.LoginTypeEnum;

public class Example {
    public static void main(String[] args) {
        LoginTypeEnum exampleEnum = LoginTypeEnum.ROLE;
    }
}
```



