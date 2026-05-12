

# AssetCardListItem

One row in `assetCardList` (response body)

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**contactBizType** | [**ContactBizTypeEnum**](#ContactBizTypeEnum) | Contact business type (`ContactBizTypeEnum`) |  |
|**cardIndexNo** | **String** | Card index number |  |
|**cardNoLength** | **String** | Card number length based on card index number |  |
|**maskedCardNo** | **String** | Card number (masked) |  |
|**assetType** | [**AssetTypeEnum**](#AssetTypeEnum) | Asset / card type (`AssetCardTypeEnum`) |  |
|**holderName** | **Map&lt;String, Object&gt;** | Holder name (JSON object per DANA spec) |  |
|**instLogoUrl** | **String** | Institution logo URL |  [optional] |
|**instId** | **String** | Institution identifier |  |
|**instOfficialName** | **String** | Institution official name based on `instId` |  |
|**expiryYear** | **String** | Expiry year (e.g. debit, credit, virtual account) |  |
|**expiryMonth** | **String** | Expiry month |  |
|**verified** | [**VerifiedEnum**](#VerifiedEnum) | Whether the user's card is verified |  |
|**bindingId** | **String** | Asset card bind identifier |  [optional] |
|**defaultAsset** | [**DefaultAssetEnum**](#DefaultAssetEnum) | Whether this asset is the user's default payment |  [optional] |
|**enableStatus** | [**EnableStatusEnum**](#EnableStatusEnum) | Whether the card status is enabled; `\"true\"` when `enableOnly` in request was true |  [optional] |
|**directDebit** | [**DirectDebitEnum**](#DirectDebitEnum) | Whether payment uses direct debit |  [optional] |


<a name="ContactBizTypeEnum"></a>
## Enum: ContactBizTypeEnum

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
import id.dana.merchantmanagement.v1.model.AssetCardListItem.ContactBizTypeEnum;

public class Example {
    public static void main(String[] args) {
        ContactBizTypeEnum exampleEnum = ContactBizTypeEnum.TRANSFER_HIS;
    }
}
```


<a name="AssetTypeEnum"></a>
## Enum: AssetTypeEnum

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
import id.dana.merchantmanagement.v1.model.AssetCardListItem.AssetTypeEnum;

public class Example {
    public static void main(String[] args) {
        AssetTypeEnum exampleEnum = AssetTypeEnum.CHECKING_ACCOUNT;
    }
}
```


<a name="VerifiedEnum"></a>
## Enum: VerifiedEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.AssetCardListItem.VerifiedEnum;

public class Example {
    public static void main(String[] args) {
        VerifiedEnum exampleEnum = VerifiedEnum.TRUE;
    }
}
```


<a name="DefaultAssetEnum"></a>
## Enum: DefaultAssetEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.AssetCardListItem.DefaultAssetEnum;

public class Example {
    public static void main(String[] args) {
        DefaultAssetEnum exampleEnum = DefaultAssetEnum.TRUE;
    }
}
```


<a name="EnableStatusEnum"></a>
## Enum: EnableStatusEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.AssetCardListItem.EnableStatusEnum;

public class Example {
    public static void main(String[] args) {
        EnableStatusEnum exampleEnum = EnableStatusEnum.TRUE;
    }
}
```


<a name="DirectDebitEnum"></a>
## Enum: DirectDebitEnum

| Name | Value | Description |
| - | - | - |
| `TRUE` | "true" |  |
| `FALSE` | "false" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.AssetCardListItem.DirectDebitEnum;

public class Example {
    public static void main(String[] args) {
        DirectDebitEnum exampleEnum = DirectDebitEnum.TRUE;
    }
}
```



