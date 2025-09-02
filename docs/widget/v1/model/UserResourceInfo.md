

# UserResourceInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**resourceType** | [**ResourceTypeEnum**](#ResourceTypeEnum) | Type of user resource |  |
|**value** | **String** | Resource value |  |


<a name="ResourceTypeEnum"></a>
## Enum: ResourceTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| BALANCE | "BALANCE" |  |
| TRANSACTION_URL | "TRANSACTION_URL" |  |
| MASK_DANA_ID | "MASK_DANA_ID" |  |
| TOPUP_URL | "TOPUP_URL" |  |
| OTT | "OTT" |  |
| USER_KYC | "USER_KYC" |  |

### Usage Example
```java
import id.dana.widget.v1.model.UserResourceInfo.ResourceTypeEnum;

public class Example {
    public static void main(String[] args) {
        ResourceTypeEnum exampleEnum = ResourceTypeEnum.BALANCE;
    }
}
```



