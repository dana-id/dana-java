

# UrlParam


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | URL link |  |
|**type** | [**TypeEnum**](#TypeEnum) | Url param. The enums:<br> * PAY_RETURN - When finish payment, DANA will notify to the URL that has been defined by<br> * NOTIFICATION - After the payment, the user will be redirected to merchant page, this is mandatory<br>  |  |
|**isDeeplink** | **String** | Deeplink URL or not |  |


<a name="TypeEnum"></a>
## Enum: TypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| PAY_RETURN | "PAY_RETURN" | When finish payment, DANA will notify to the URL that has been defined by |
| NOTIFICATION | "NOTIFICATION" | After the payment, the user will be redirected to merchant page, this is mandatory |

### Usage Example
```java
import id.dana.widget.v1.model.UrlParam.TypeEnum;

public class Example {
    public static void main(String[] args) {
        TypeEnum exampleEnum = TypeEnum.PAY_RETURN;
    }
}
```



