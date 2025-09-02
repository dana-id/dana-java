

# ApplyTokenAuthorizationCodeRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalInfo** | **Map&lt;String, Object&gt;** | Additional information |  [optional] |
|**grantType** | [**GrantTypeEnum**](#GrantTypeEnum) | Apply token request type. The value is AUTHORIZATION_CODE |  |
|**authCode** | **String** | Authorization code. Please refer to https://dashboard.dana.id/api-docs/read/125. Required if grantType is AUTHORIZATION_CODE |  |
|**refreshToken** | **String** | This token is used for refresh session if existing token has been expired |  [optional] |


<a name="GrantTypeEnum"></a>
## Enum: GrantTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| AUTHORIZATION_CODE | "AUTHORIZATION_CODE" |  |

### Usage Example
```java
import id.dana.widget.v1.model.ApplyTokenAuthorizationCodeRequest.GrantTypeEnum;

public class Example {
    public static void main(String[] args) {
        GrantTypeEnum exampleEnum = GrantTypeEnum.AUTHORIZATION_CODE;
    }
}
```


## Implemented Interfaces

* ApplyTokenRequest


