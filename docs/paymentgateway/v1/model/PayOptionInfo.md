

# PayOptionInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payMethod** | [**PayMethodEnum**](#PayMethodEnum) | Payment method name. The enums:<br>   * BALANCE - Payment method with balance<br>   * COUPON - Payment method with coupon<br>   * NET_BANKING - Payment method with internet banking<br>   * CREDIT_CARD - Payment method with credit card<br>   * DEBIT_CARD - Payment method with debit card<br>   * VIRTUAL_ACCOUNT - Payment method with virtual account<br>   * OTC - Payment method with OTC<br>   * DIRECT_DEBIT_CREDIT_CARD - Payment method with direct debit of credit card<br>   * DIRECT_DEBIT_DEBIT_CARD - Payment method with direct debit of debit card<br>   * ONLINE_CREDIT - Payment method with online Credit<br>   * LOAN_CREDIT - Payment method with DANA Cicil<br>   * NETWORK_PAY - Payment method with e-wallet   * CARD - Payment method with Card  |  |
|**payOption** | [**PayOptionEnum**](#PayOptionEnum) | Payment option which shows the provider of this payment. The enums:<br>   * NETWORK_PAY_PG_SPAY - Payment method with ShopeePay e-wallet<br>   * NETWORK_PAY_PG_OVO - Payment method with OVO e-wallet<br>   * NETWORK_PAY_PG_GOPAY - Payment method with GoPay e-wallet<br>   * NETWORK_PAY_PG_LINKAJA - Payment method with LinkAja e-wallet<br>   * NETWORK_PAY_PG_CARD - Payment method with Card<br>   * VIRTUAL_ACCOUNT_BCA - Payment method with BCA virtual account<br>   * VIRTUAL_ACCOUNT_BNI - Payment method with BNI virtual account<br>   * VIRTUAL_ACCOUNT_MANDIRI - Payment method with Mandiri virtual account<br>   * VIRTUAL_ACCOUNT_BRI - Payment method with BRI virtual account<br>   * VIRTUAL_ACCOUNT_BTPN - Payment method with BTPN virtual account<br>   * VIRTUAL_ACCOUNT_CIMB - Payment method with CIMB virtual account<br>   * VIRTUAL_ACCOUNT_PERMATA - Payment method with Permata virtual account<br>  |  [optional] |
|**payAmount** | [**Money**](Money.md) | Pay amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |
|**transAmount** | [**Money**](Money.md) | Trans amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |
|**chargeAmount** | [**Money**](Money.md) | Charge amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |
|**payOptionBillExtendInfo** | **String** | Extend information of pay option bill |  [optional] |
|**extendInfo** | **String** | Extend information |  [optional] |
|**paymentCode** | **String** | Payment code |  [optional] |


<a name="PayMethodEnum"></a>
## Enum: PayMethodEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| BALANCE | "BALANCE" | Payment method with balance |
| COUPON | "COUPON" | Payment method with coupon |
| NET_BANKING | "NET_BANKING" | Payment method with internet banking |
| CREDIT_CARD | "CREDIT_CARD" | Payment method with credit card |
| DEBIT_CARD | "DEBIT_CARD" | Payment method with debit card |
| VIRTUAL_ACCOUNT | "VIRTUAL_ACCOUNT" | Payment method with virtual account |
| OTC | "OTC" | Payment method with OTC |
| DIRECT_DEBIT_CREDIT_CARD | "DIRECT_DEBIT_CREDIT_CARD" | Payment method with direct debit of credit card |
| DIRECT_DEBIT_DEBIT_CARD | "DIRECT_DEBIT_DEBIT_CARD" | Payment method with direct debit of debit card |
| ONLINE_CREDIT | "ONLINE_CREDIT" | Payment method with online Credit |
| LOAN_CREDIT | "LOAN_CREDIT" | Payment method with DANA Cicil |
| NETWORK_PAY | "NETWORK_PAY" | Payment method with e-wallet |
| CARD | "CARD" | Payment method with Card |

### Usage Example
```java
import id.dana.paymentgateway.v1.model.PayOptionInfo.PayMethodEnum;

public class Example {
    public static void main(String[] args) {
        PayMethodEnum exampleEnum = PayMethodEnum.BALANCE;
    }
}
```


<a name="PayOptionEnum"></a>
## Enum: PayOptionEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| NETWORK_PAY_PG_SPAY | "NETWORK_PAY_PG_SPAY" | Payment method with ShopeePay e-wallet |
| NETWORK_PAY_PG_OVO | "NETWORK_PAY_PG_OVO" | Payment method with OVO e-wallet |
| NETWORK_PAY_PG_GOPAY | "NETWORK_PAY_PG_GOPAY" | Payment method with GoPay e-wallet |
| NETWORK_PAY_PG_LINKAJA | "NETWORK_PAY_PG_LINKAJA" | Payment method with LinkAja e-wallet |
| NETWORK_PAY_PG_CARD | "NETWORK_PAY_PG_CARD" | Payment method with Card |
| VIRTUAL_ACCOUNT_BCA | "VIRTUAL_ACCOUNT_BCA" | Payment method with BCA virtual account |
| VIRTUAL_ACCOUNT_BNI | "VIRTUAL_ACCOUNT_BNI" | Payment method with BNI virtual account |
| VIRTUAL_ACCOUNT_MANDIRI | "VIRTUAL_ACCOUNT_MANDIRI" | Payment method with Mandiri virtual account |
| VIRTUAL_ACCOUNT_BRI | "VIRTUAL_ACCOUNT_BRI" | Payment method with BRI virtual account |
| VIRTUAL_ACCOUNT_BTPN | "VIRTUAL_ACCOUNT_BTPN" | Payment method with BTPN virtual account |
| VIRTUAL_ACCOUNT_CIMB | "VIRTUAL_ACCOUNT_CIMB" | Payment method with CIMB virtual account |
| VIRTUAL_ACCOUNT_PERMATA | "VIRTUAL_ACCOUNT_PERMATA" | Payment method with Permata virtual account |

### Usage Example
```java
import id.dana.paymentgateway.v1.model.PayOptionInfo.PayOptionEnum;

public class Example {
    public static void main(String[] args) {
        PayOptionEnum exampleEnum = PayOptionEnum.NETWORK_PAY_PG_SPAY;
    }
}
```



