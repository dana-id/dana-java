

# QueryMerchantResourceResponseResponseHead


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**version** | **String** | API version |  [optional] |
|**function** | [**FunctionEnum**](#FunctionEnum) | API interface |  [optional] |
|**clientId** | **String** | Client ID provided by DANA, used to identify partner and application system |  [optional] |
|**respTime** | **String** | DateTime with timezone, which follows the ISO-8601 standard. Refer to RFC 3339 Section 5.6 |  [optional] |
|**reqMsgId** | **String** | Request message ID |  [optional] |


<a name="FunctionEnum"></a>
## Enum: FunctionEnum

| Name | Value | Description |
| - | - | - |
| `DANA_MERCHANT_QUERY_MERCHANT_RESOURCE` | "dana.merchant.queryMerchantResource" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryMerchantResourceResponseResponseHead.FunctionEnum;

public class Example {
    public static void main(String[] args) {
        FunctionEnum exampleEnum = FunctionEnum.DANA_MERCHANT_QUERY_MERCHANT_RESOURCE;
    }
}
```



