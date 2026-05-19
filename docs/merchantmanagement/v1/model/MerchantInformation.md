

# MerchantInformation

Merchant profile detail (`merchantInformation` in response body)

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**phoneNumber** | **String** | Phone number |  [optional] |
|**merchantId** | **String** | Merchant identifier |  [optional] |
|**merchantType** | [**MerchantTypeEnum**](#MerchantTypeEnum) | Merchant type |  [optional] |
|**merchantSubType** | [**MerchantSubTypeEnum**](#MerchantSubTypeEnum) | Merchant sub type |  [optional] |
|**mccCodes** | **List&lt;String&gt;** | Merchant category codes (MCC) |  [optional] |
|**logoUrl** | **String** | Logo URL |  [optional] |
|**logoUrlMap** | **Map&lt;String, String&gt;** | Logo map. Keys may be `LOGO`, `PC_LOGO`, `MOBILE_LOGO`. Values are base64-encoded PNG image data.  |  [optional] |
|**shortNameCode** | **String** | Merchant short name code |  [optional] |
|**officialName** | **String** | Merchant official name |  [optional] |
|**englishName** | **String** | Merchant English name |  [optional] |
|**localName** | **String** | Merchant local (Indonesian) name |  [optional] |
|**certificate** | [**MerchantCertificateInfo**](MerchantCertificateInfo.md) |  |  [optional] |
|**registeredAddress** | [**MerchantContactAddress**](MerchantContactAddress.md) |  |  [optional] |
|**businessAddress** | [**MerchantContactAddress**](MerchantContactAddress.md) |  |  [optional] |
|**officeTelephone** | **String** | Merchant official telephone number |  [optional] |
|**faxTelephone** | **String** | Merchant official fax telephone number |  [optional] |
|**corporateOfficialName** | [**UserName**](UserName.md) |  |  [optional] |
|**corporateCertificate** | [**MerchantCorporateCertificate**](MerchantCorporateCertificate.md) |  |  [optional] |
|**contactOfficialName** | [**UserName**](UserName.md) |  |  [optional] |
|**contactMobileNo** | [**MerchantContactMobileNo**](MerchantContactMobileNo.md) |  |  [optional] |
|**contactTelephone** | **String** | Contact telephone number |  [optional] |
|**contactEmail** | [**MerchantContactEmail**](MerchantContactEmail.md) |  |  [optional] |
|**createdTime** | **String** | Merchant creation time, YYYY-MM-DDTHH:mm:ss+07:00 (GMT+7) |  [optional] |
|**modifiedTime** | **String** | Merchant last modified time, YYYY-MM-DDTHH:mm:ss+07:00 (GMT+7) |  [optional] |
|**merchantStatus** | [**MerchantStatusEnum**](#MerchantStatusEnum) | Merchant status |  [optional] |
|**registerSource** | **String** | Registered source platform |  [optional] |
|**sizeType** | [**SizeTypeEnum**](#SizeTypeEnum) | Size type |  [optional] |
|**platformMid** | **String** | Merchant platform identifier |  [optional] |
|**taxNo** | **String** | Tax number (NPWP), 15 digits |  [optional] |
|**accounts** | [**List&lt;MerchantAccountInfo&gt;**](MerchantAccountInfo.md) | Merchant account list (present when `isQueryAccount` is true in request) |  [optional] |
|**brandName** | **String** | Brand name on legal name or tax name |  [optional] |
|**taxAddress** | [**MerchantContactAddress**](MerchantContactAddress.md) |  |  [optional] |


<a name="MerchantTypeEnum"></a>
## Enum: MerchantTypeEnum

| Name | Value | Description |
| - | - | - |
| `INDIVIDUAL` | "INDIVIDUAL" | Individual merchant |
| `CORPORATION` | "CORPORATION" | Corporation merchant |
| `FINANCIAL_INST` | "FINANCIAL_INST" | Financial institution merchant |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantInformation.MerchantTypeEnum;

public class Example {
    public static void main(String[] args) {
        MerchantTypeEnum exampleEnum = MerchantTypeEnum.INDIVIDUAL;
    }
}
```


<a name="MerchantSubTypeEnum"></a>
## Enum: MerchantSubTypeEnum

| Name | Value | Description |
| - | - | - |
| `COMPANY_TYPE_22` | "COMPANY_TYPE_22" | Unit Perusahaan Tidak Berbadan Hukum |
| `COMPANY_TYPE_31` | "COMPANY_TYPE_31" | Rumah Tangga Industri dan Komersial Perorangan |
| `COMPANY_TYPE_41` | "COMPANY_TYPE_41" | Instansi Pemerintah |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantInformation.MerchantSubTypeEnum;

public class Example {
    public static void main(String[] args) {
        MerchantSubTypeEnum exampleEnum = MerchantSubTypeEnum.COMPANY_TYPE_22;
    }
}
```


<a name="MerchantStatusEnum"></a>
## Enum: MerchantStatusEnum

| Name | Value | Description |
| - | - | - |
| `PENDING` | "PENDING" |  |
| `ACTIVE` | "ACTIVE" |  |
| `FROZEN` | "FROZEN" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantInformation.MerchantStatusEnum;

public class Example {
    public static void main(String[] args) {
        MerchantStatusEnum exampleEnum = MerchantStatusEnum.PENDING;
    }
}
```


<a name="SizeTypeEnum"></a>
## Enum: SizeTypeEnum

| Name | Value | Description |
| - | - | - |
| `UMI` | "UMI" |  |
| `UKE` | "UKE" |  |
| `UME` | "UME" |  |
| `UBE` | "UBE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantInformation.SizeTypeEnum;

public class Example {
    public static void main(String[] args) {
        SizeTypeEnum exampleEnum = SizeTypeEnum.UMI;
    }
}
```



