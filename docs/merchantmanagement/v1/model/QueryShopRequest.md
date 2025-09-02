

# QueryShopRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant identifier. Required when shopIdType is EXTERNAL_ID |  [optional] |
|**shopId** | **String** | Shop identifier. Length depends on shopIdType - INNER_ID (21 max), EXTERNAL_ID (64 max) |  |
|**shopIdType** | [**ShopIdTypeEnum**](#ShopIdTypeEnum) | Shop identifier type |  |


<a name="ShopIdTypeEnum"></a>
## Enum: ShopIdTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| INNER_ID | "INNER_ID" |  |
| EXTERNAL_ID | "EXTERNAL_ID" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryShopRequest.ShopIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        ShopIdTypeEnum exampleEnum = ShopIdTypeEnum.INNER_ID;
    }
}
```



