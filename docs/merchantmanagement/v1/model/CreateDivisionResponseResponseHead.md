

# CreateDivisionResponseResponseHead


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **String** | API version |  [optional] |
|**function** | [**FunctionEnum**](#FunctionEnum) | API interface |  [optional] |
|**clientId** | **String** | Client ID provided by DANA, used to identify partner and application system |  [optional] |
|**clientSecret** | **String** | As a secret key of client. Assigned client secret during registration |  [optional] |
|**respTime** | **String** | Response time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**reqMsgId** | **String** | Request message ID |  [optional] |
|**reserve** | **String** | Reserved for future implementation (Key/Value) |  [optional] |



## Enum: FunctionEnum

| Name | Value |
|---- | -----|
| DANA_MERCHANT_DIVISION_CREATE_DIVISION | &quot;dana.merchant.division.createDivision&quot; |



