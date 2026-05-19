

# MerchantContactAddress

Merchant contact address (`registeredAddress`, `businessAddress`, `taxAddress`)

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**address1** | **String** | Address line 1 |  [optional] |
|**address2** | **String** | Address line 2 |  [optional] |
|**country** | **String** | Country name |  [optional] |
|**province** | **String** | Province name |  [optional] |
|**city** | **String** | City name |  [optional] |
|**area** | **String** | Area name |  [optional] |
|**zipcode** | **String** | Zipcode |  [optional] |
|**contactAddressType** | [**ContactAddressTypeEnum**](#ContactAddressTypeEnum) | Contact address type |  [optional] |


<a name="ContactAddressTypeEnum"></a>
## Enum: ContactAddressTypeEnum

| Name | Value | Description |
| - | - | - |
| `OFFICE_ADD` | "OFFICE_ADD" | Office address |
| `REG_ADD` | "REG_ADD" | Registered address |
| `HOME_ADD` | "HOME_ADD" | Home address |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantContactAddress.ContactAddressTypeEnum;

public class Example {
    public static void main(String[] args) {
        ContactAddressTypeEnum exampleEnum = ContactAddressTypeEnum.OFFICE_ADD;
    }
}
```



