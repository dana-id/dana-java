

# VirtualAccountInfo


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**virtualAccountCode** | **String** | Virtual account code. Present if successfully processed and payment method is VIRTUAL_ACCOUNT |  [optional] |
|**virtualAccountExpiryTime** | **String** | Expiry time of virtual account, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time). Present if successfully processed and payment method is VIRTUAL_ACCOUNT |  [optional] |
|**signature** | **String** | Signature of virtual account. Present if successfully processed and payment method is VIRTUAL_ACCOUNT |  [optional] |



