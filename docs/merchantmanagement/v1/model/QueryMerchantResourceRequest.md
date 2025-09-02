

# QueryMerchantResourceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestMerchantId** | **String** | This is a merchantId of DANA |  |
|**merchantResourceInfoList** | [**List<MerchantResourceInfoListEnum>**](#List<MerchantResourceInfoListEnum>) | This is a constant merchant resource info request, currently available for value of constant these: MERCHANT_DEPOSIT_BALANCE MERCHANT_AVAILABLE_BALANCE MERCHANT_TOTAL_BALANCE value for this request can't be empty or wrong constant info  |  |


<a name="List<MerchantResourceInfoListEnum>"></a>
## Enum: List<MerchantResourceInfoListEnum>

| Name | Value | Description |
| ---- | ----- | ----------- |
| MERCHANT_DEPOSIT_BALANCE | "MERCHANT_DEPOSIT_BALANCE" |  |
| MERCHANT_AVAILABLE_BALANCE | "MERCHANT_AVAILABLE_BALANCE" |  |
| MERCHANT_TOTAL_BALANCE | "MERCHANT_TOTAL_BALANCE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryMerchantResourceRequest.List<MerchantResourceInfoListEnum>;

public class Example {
    public static void main(String[] args) {
        List<MerchantResourceInfoListEnum> exampleEnum = List<MerchantResourceInfoListEnum>.MERCHANT_DEPOSIT_BALANCE;
    }
}
```



