

# MerchantAccountInfo

One merchant account row (`accounts` in merchantInformation)

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**accountNo** | **String** | Merchant account number |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Merchant account status |  [optional] |
|**debitFreezeStatus** | [**DebitFreezeStatusEnum**](#DebitFreezeStatusEnum) | Debit freeze status (merchant cannot accept money from DANA when frozen/closed) |  [optional] |
|**creditFreezeStatus** | [**CreditFreezeStatusEnum**](#CreditFreezeStatusEnum) | Credit freeze status (merchant cannot disburse when frozen/closed) |  [optional] |
|**totalAmount** | **String** | Total amount as JSON string with `amount` and `currency` fields  |  [optional] |
|**availableAmount** | **String** | Available amount as JSON string with `amount` and `currency` fields  |  [optional] |
|**currency** | **String** | Currency code (ISO) |  [optional] |
|**accountType** | [**AccountTypeEnum**](#AccountTypeEnum) | Account type |  [optional] |


<a name="StatusEnum"></a>
## Enum: StatusEnum

| Name | Value | Description |
| - | - | - |
| `ENABLE` | "ENABLE" |  |
| `FROZEN` | "FROZEN" |  |
| `CLOSE` | "CLOSE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantAccountInfo.StatusEnum;

public class Example {
    public static void main(String[] args) {
        StatusEnum exampleEnum = StatusEnum.ENABLE;
    }
}
```


<a name="DebitFreezeStatusEnum"></a>
## Enum: DebitFreezeStatusEnum

| Name | Value | Description |
| - | - | - |
| `ENABLE` | "ENABLE" |  |
| `FROZEN` | "FROZEN" |  |
| `CLOSE` | "CLOSE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantAccountInfo.DebitFreezeStatusEnum;

public class Example {
    public static void main(String[] args) {
        DebitFreezeStatusEnum exampleEnum = DebitFreezeStatusEnum.ENABLE;
    }
}
```


<a name="CreditFreezeStatusEnum"></a>
## Enum: CreditFreezeStatusEnum

| Name | Value | Description |
| - | - | - |
| `ENABLE` | "ENABLE" |  |
| `FROZEN` | "FROZEN" |  |
| `CLOSE` | "CLOSE" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantAccountInfo.CreditFreezeStatusEnum;

public class Example {
    public static void main(String[] args) {
        CreditFreezeStatusEnum exampleEnum = CreditFreezeStatusEnum.ENABLE;
    }
}
```


<a name="AccountTypeEnum"></a>
## Enum: AccountTypeEnum

| Name | Value | Description |
| - | - | - |
| `MERCHANT_SETTLEMENT_ACCOUNT` | "MERCHANT_SETTLEMENT_ACCOUNT" | Settlement account |
| `MERCHANT_PAYABLE_ACCOUNT` | "MERCHANT_PAYABLE_ACCOUNT" | Payable account |
| `MERCHANT_DEPOSIT_ACCOUNT` | "MERCHANT_DEPOSIT_ACCOUNT" | Deposit account |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.MerchantAccountInfo.AccountTypeEnum;

public class Example {
    public static void main(String[] args) {
        AccountTypeEnum exampleEnum = AccountTypeEnum.MERCHANT_SETTLEMENT_ACCOUNT;
    }
}
```



