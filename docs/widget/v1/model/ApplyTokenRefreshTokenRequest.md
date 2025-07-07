

# ApplyTokenRefreshTokenRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalInfo** | **Map&lt;String, Object&gt;** | Additional information |  [optional] |
|**grantType** | [**GrantTypeEnum**](#GrantTypeEnum) | Apply token request type. The value is REFRESH_TOKEN |  |
|**authCode** | **String** | Authorization code. Please refer to https://dashboard.dana.id/api-docs/read/125. Required if grantType is AUTHORIZATION_CODE |  [optional] |
|**refreshToken** | **String** | This token is used for refresh session if existing token has been expired |  |



## Enum: GrantTypeEnum

| Name | Value |
|---- | -----|
| REFRESH_TOKEN | &quot;REFRESH_TOKEN&quot; |


## Implemented Interfaces

* ApplyTokenRequest


