

# Oauth2UrlDataSeamlessData

Option for binding process.Please refer sample below to know how to include seamlessData

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bizScenario** | **String** | User’s bizScenario |  [optional] |
|**mobileNumber** | **String** | User's phone number. If this field is filled in, the user must log in with the number that has been included |  [optional] |
|**verifiedTime** | **String** | Value which states that the mobile number that has been included in seamlessData has verified ownership and does not require OTP verification by the provider, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**externalUid** | **String** | User identifier on partner application |  [optional] |
|**deviceId** | **String** | User's device identifier |  [optional] |
|**skipRegisterConsult** | **Boolean** | Identifier to differentiate seamless registration flow. The possible values are true or false |  [optional] |



