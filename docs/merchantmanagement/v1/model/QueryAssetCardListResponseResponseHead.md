

# QueryAssetCardListResponseResponseHead


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**version** | **String** | API version |  [optional] |
|**function** | [**FunctionEnum**](#FunctionEnum) | API interface |  [optional] |
|**clientId** | **String** | Client ID provided by DANA, used to identify partner and application system |  [optional] |
|**respTime** | **String** | DateTime with timezone (ISO-8601) |  [optional] |
|**reqMsgId** | **String** | Request message ID |  [optional] |
|**clientSecret** | **String** | As a secret key of client. Assigned client secret during registration |  [optional] |
|**reserve** | **Object** |  |  [optional] |


<a name="FunctionEnum"></a>
## Enum: FunctionEnum

| Name | Value | Description |
| - | - | - |
| `DANA_MEMBER_ASSET_QUERY_ASSET_CARD_LIST` | "dana.member.asset.queryAssetCardList" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryAssetCardListResponseResponseHead.FunctionEnum;

public class Example {
    public static void main(String[] args) {
        FunctionEnum exampleEnum = FunctionEnum.DANA_MEMBER_ASSET_QUERY_ASSET_CARD_LIST;
    }
}
```



