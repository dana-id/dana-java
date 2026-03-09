

# UserResourceInfo


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**resourceType** | [**ResourceTypeEnum**](#ResourceTypeEnum) | Type of user resource |  |
|**value** | **String** | Resource value |  |


<a name="ResourceTypeEnum"></a>
## Enum: ResourceTypeEnum

| Name | Value | Description |
| - | - | - |
| `BALANCE` | "BALANCE" | Query balance of user in DANA |
| `TOPUP_URL` | "TOPUP_URL" | Obtain the top up URL for merchant to redirect |
| `TRANSACTION_URL` | "TRANSACTION_URL" | Obtain the transaction URL for merchant to redirect |
| `OTT` | "OTT" | Obtain the OTT of URLs including TOPUP/TRANSACTION/CASHIER/CHECKOUT_URL |
| `MASK_DANA_ID` | "MASK_DANA_ID" | The masked identifier from DANA side |
| `USER_KYC` | "USER_KYC" | KYC level. 00 = KYC level 0, 02 = KYC level 2 |
| `LOGIN_ID` | "LOGIN_ID" | Login identifier of the user, currently it's only set to phone number |
| `CLEAR_TEXT_DANA_ID` | "CLEAR_TEXT_DANA_ID" | The unmasked identifier from DANA side |
| `NICKNAME` | "NICKNAME" | Nickname of the user in DANA |
| `FULLNAME` | "FULLNAME" | Full name of the user in DANA |
| `KTP_NUMBER` | "KTP_NUMBER" | KTP number of the user in DANA |
| `KTP_PHOTO_DATA` | "KTP_PHOTO_DATA" | KTP photo binary data in base64 of the user in DANA |
| `SELFIE_PHOTO_DATA` | "SELFIE_PHOTO_DATA" | Selfie photo binary data in base64 of the user in DANA |
| `AVATAR_URL` | "AVATAR_URL" | Location of avatar photo of the user in DANA |
| `MASKED_FULLNAME` | "MASKED_FULLNAME" | Masked full name of the user in DANA |

### Usage Example
```java
import id.dana.widget.v1.model.UserResourceInfo.ResourceTypeEnum;

public class Example {
    public static void main(String[] args) {
        ResourceTypeEnum exampleEnum = ResourceTypeEnum.BALANCE;
    }
}
```



