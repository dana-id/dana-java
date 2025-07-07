

# UrlParam


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | URL link |  |
|**type** | [**TypeEnum**](#TypeEnum) | Url param. The enums:&lt;br&gt; * PAY_RETURN - When finish payment, DANA will notify to the URL that has been defined by&lt;br&gt; * NOTIFICATION - After the payment, the user will be redirected to merchant page, this is mandatory&lt;br&gt;  |  |
|**isDeeplink** | **String** | Deeplink URL or not |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PAY_RETURN | &quot;PAY_RETURN&quot; |
| NOTIFICATION | &quot;NOTIFICATION&quot; |



