

# QueryMerchantInfoResponseResponseHead


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**version** | **String** | API version |  [optional] |
|**function** | [**FunctionEnum**](#FunctionEnum) | API interface |  [optional] |
|**clientId** | **String** | Client ID provided by DANA, used to identify partner and application system |  [optional] |
|**respTime** | **String** | DateTime with timezone (ISO-8601), GMT+7 (Jakarta time) |  [optional] |
|**reqMsgId** | **String** | Request message ID |  [optional] |
|**clientSecret** | **String** | As a secret key of client. Assigned client secret during registration |  [optional] |
|**reserve** | **Object** |  |  [optional] |


<a name="FunctionEnum"></a>
## Enum: FunctionEnum

| Name | Value | Description |
| - | - | - |
| `DANA_AP_BIZPROD_BIZ_SERVICE_OPENAPI_MERCHANT_QUERY_MERCHANT_INFO` | "dana.ap.bizprod.biz.service.openapi.merchant.queryMerchantInfo" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryMerchantInfoResponseResponseHead.FunctionEnum;

public class Example {
    public static void main(String[] args) {
        FunctionEnum exampleEnum = FunctionEnum.DANA_AP_BIZPROD_BIZ_SERVICE_OPENAPI_MERCHANT_QUERY_MERCHANT_INFO;
    }
}
```



