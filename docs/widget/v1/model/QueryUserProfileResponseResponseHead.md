

# QueryUserProfileResponseResponseHead


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **String** | API version |  [optional] |
|**function** | [**FunctionEnum**](#FunctionEnum) | API interface |  [optional] |
|**clientId** | **String** | Client ID provided by DANA, used to identify partner and application system |  [optional] |
|**respTime** | **String** | Response time, dateTime with timezone, which follows the ISO-8601 standard. Refer to RFC 3339 Section 5.6 |  [optional] |
|**reqMsgId** | **String** | Each request will be assigned with a unique id (uuid) |  [optional] |
|**reserve** | **String** | Reserved for future implementation (Key/Value) |  [optional] |


<a name="FunctionEnum"></a>
## Enum: FunctionEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| DANA_MEMBER_QUERY_QUERY_USER_PROFILE | "dana.member.query.queryUserProfile" |  |

### Usage Example
```java
import id.dana.widget.v1.model.QueryUserProfileResponseResponseHead.FunctionEnum;

public class Example {
    public static void main(String[] args) {
        FunctionEnum exampleEnum = FunctionEnum.DANA_MEMBER_QUERY_QUERY_USER_PROFILE;
    }
}
```



