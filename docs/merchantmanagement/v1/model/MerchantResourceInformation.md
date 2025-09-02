

# MerchantResourceInformation


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**resourceType** | [**ResourceTypeEnum**](#ResourceTypeEnum) | Type of merchant resource |  |
|**value** | **String** | JSON string containing amount and currency information |  |


<a name="ResourceTypeEnum"></a>
## Enum: ResourceTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| MERCHANT_DEPOSIT_BALANCE | "MERCHANT_DEPOSIT_BALANCE" |  |
| MERCHANT_AVAILABLE_BALANCE | "MERCHANT_AVAILABLE_BALANCE" |  |
| MERCHANT_TOTAL_BALANCE | "MERCHANT_TOTAL_BALANCE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantResourceInformation.ResourceTypeEnum;

public class Example {
    public static void main(String[] args) {
        ResourceTypeEnum exampleEnum = ResourceTypeEnum.MERCHANT_DEPOSIT_BALANCE;
    }
}
```



