

# QueryUserProfileRequest


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**userResources** | [**List<UserResourcesEnum>**](#List<UserResourcesEnum>) | The resource type list that the merchant server wants to get from DANA |  |


<a name="List<UserResourcesEnum>"></a>
## Enum: List<UserResourcesEnum>

| Name | Value | Description |
| - | - | - |
| `BALANCE` | "BALANCE" |  |
| `TRANSACTION_URL` | "TRANSACTION_URL" |  |
| `MASK_DANA_ID` | "MASK_DANA_ID" |  |
| `TOPUP_URL` | "TOPUP_URL" |  |
| `OTT` | "OTT" |  |
| `USER_KYC` | "USER_KYC" |  |

### Usage Example
```java
import id.dana.widget.v1.model.QueryUserProfileRequest.List<UserResourcesEnum>;

public class Example {
    public static void main(String[] args) {
        List<UserResourcesEnum> exampleEnum = List<UserResourcesEnum>.BALANCE;
    }
}
```



