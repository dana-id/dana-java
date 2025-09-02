

# Oauth2UrlData

Data needed to construct Oauth2Url

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**externalId** | **String** | Identifier from merchant |  |
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**seamlessData** | [**Oauth2UrlDataSeamlessData**](Oauth2UrlDataSeamlessData.md) |  |  [optional] |
|**scopes** | **List&lt;String&gt;** | The scopes of the authorization |  [optional] |
|**redirectUrl** | **String** | When user authorization is success, the user will be redirected to this URL |  |
|**state** | **String** | Random string for CSRF protection purposes |  [optional] |
|**lang** | **String** | Service language code. ISO 639-1 |  [optional] |
|**allowRegistration** | **String** | If value equals true, provider may enable registration process during binding. Default true |  [optional] |
|**mode** | [**ModeEnum**](#ModeEnum) | Mode of the authorization. The possible values are API or DEEPLINK |  [optional] |


<a name="ModeEnum"></a>
## Enum: ModeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| API | "API" |  |
| DEEPLINK | "DEEPLINK" |  |

### Usage Example
```java
import id.dana.widget.v1.model.Oauth2UrlData.ModeEnum;

public class Example {
    public static void main(String[] args) {
        ModeEnum exampleEnum = ModeEnum.API;
    }
}
```



