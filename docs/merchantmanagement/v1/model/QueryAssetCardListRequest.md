

# QueryAssetCardListRequest

Business fields mapped to `request.body` in the JSON envelope (head/signature are handled by the client/runtime).

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**memberId** | **String** | User identifier or merchant identifier |  |
|**bindingId** | **String** | Asset card bind identifier |  [optional] |
|**enableOnly** | [**EnableOnlyEnum**](#EnableOnlyEnum) | Return only active cards when `\"true\"` |  [optional] |
|**contactBizTypeList** | [**List<ContactBizTypeListEnum>**](#List<ContactBizTypeListEnum>) | Contact biz type list (`ContactBizTypeEnum`) |  [optional] |
|**assetTypeList** | [**List<AssetTypeListEnum>**](#List<AssetTypeListEnum>) | Asset type list (`AssetCardTypeEnum`) |  [optional] |


<a name="EnableOnlyEnum"></a>
## Enum: EnableOnlyEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryAssetCardListRequest.EnableOnlyEnum;

public class Example {
    public static void main(String[] args) {
        EnableOnlyEnum exampleEnum = EnableOnlyEnum.TRUE;
    }
}
```


<a name="List<ContactBizTypeListEnum>"></a>
## Enum: List<ContactBizTypeListEnum>

| Name | Value | Description |
| - | - | - |
| `TRANSFER_HIS` | "TRANSFER_HIS" | History of transfer transaction |
| `DIRECT_TRANSFER` | "DIRECT_TRANSFER" | Transfer from virtual bank card |
| `GENERAL_CARD` | "GENERAL_CARD" | Bank card used for general purpose |
| `DIRECTPAY_CARD` | "DIRECTPAY_CARD" | Bank card used for direct payment |
| `PAYMENT_CARD` | "PAYMENT_CARD" | Bank card for payment card |
| `CASHOUT_CARD` | "CASHOUT_CARD" | Bank card used for cashout |
| `IMPS_ACCOUNT` | "IMPS_ACCOUNT" | Bank card used for BCA |
| `INVESTMENT_ACCOUNT` | "INVESTMENT_ACCOUNT" | Investment account |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryAssetCardListRequest.List<ContactBizTypeListEnum>;

public class Example {
    public static void main(String[] args) {
        List<ContactBizTypeListEnum> exampleEnum = List<ContactBizTypeListEnum>.TRANSFER_HIS;
    }
}
```


<a name="List<AssetTypeListEnum>"></a>
## Enum: List<AssetTypeListEnum>

| Name | Value | Description |
| - | - | - |
| `CHECKING_ACCOUNT` | "CHECKING_ACCOUNT" | Checking account |
| `SAVINGS_ACCOUNT` | "SAVINGS_ACCOUNT" | User's savings account |
| `LOAN_ACCOUNT` | "LOAN_ACCOUNT" | User's loan account |
| `IMPS_ACCOUNT` | "IMPS_ACCOUNT" | Immediate payment service account |
| `DEBIT_CARD` | "DEBIT_CARD" | User's debit card |
| `CREDIT_CARD` | "CREDIT_CARD" | User's credit card |
| `SECURED_CREDIT_CARD` | "SECURED_CREDIT_CARD" | Secured credit card |
| `VA_ACCOUNT` | "VA_ACCOUNT" | Virtual account |
| `OTC_ACCOUNT` | "OTC_ACCOUNT" | On the counter account |
| `REFUND_ACCOUNT` | "REFUND_ACCOUNT" | User's refund account |
| `CREDIT_ACCOUNT` | "CREDIT_ACCOUNT" | User's credit account |
| `LOAN` | "LOAN" | User's loan account paylater |
| `MUTUAL_FUNDS_ACCOUNT` | "MUTUAL_FUNDS_ACCOUNT" | User's mutual fund account |
| `INVESTMENT` | "INVESTMENT" | User's investment account |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryAssetCardListRequest.List<AssetTypeListEnum>;

public class Example {
    public static void main(String[] args) {
        List<AssetTypeListEnum> exampleEnum = List<AssetTypeListEnum>.CHECKING_ACCOUNT;
    }
}
```



