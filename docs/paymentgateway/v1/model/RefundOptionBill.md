

# RefundOptionBill


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**payMethod** | [**PayMethodEnum**](#PayMethodEnum) | Payment method name. The enums:<br>   * BALANCE - Payment method with balance<br>   * COUPON - Payment method with coupon<br>   * NET_BANKING - Payment method with internet banking<br>   * CREDIT_CARD - Payment method with credit card<br>   * DEBIT_CARD - Payment method with debit card<br>   * VIRTUAL_ACCOUNT - Payment method with virtual account<br>   * OTC - Payment method with OTC<br>   * DIRECT_DEBIT_CREDIT_CARD - Payment method with direct debit of credit card<br>   * DIRECT_DEBIT_DEBIT_CARD - Payment method with direct debit of debit card<br>   * ONLINE_CREDIT - Payment method with online Credit<br>   * LOAN_CREDIT - Payment method with DANA Cicil<br>   * NETWORK_PAY - Payment method with e-wallet<br>   * CARD - Payment method with card<br>  |  [optional] |
|**transAmount** | [**Money**](Money.md) | Trans amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |


<a name="PayMethodEnum"></a>
## Enum: PayMethodEnum

| Name | Value | Description |
| - | - | - |
| `BALANCE` | "BALANCE" | Payment method with balance |
| `COUPON` | "COUPON" | Payment method with coupon |
| `NET_BANKING` | "NET_BANKING" | Payment method with internet banking |
| `CREDIT_CARD` | "CREDIT_CARD" | Payment method with credit card |
| `DEBIT_CARD` | "DEBIT_CARD" | Payment method with debit card |
| `VIRTUAL_ACCOUNT` | "VIRTUAL_ACCOUNT" | Payment method with virtual account |
| `OTC` | "OTC" | Payment method with OTC |
| `DIRECT_DEBIT_CREDIT_CARD` | "DIRECT_DEBIT_CREDIT_CARD" | Payment method with direct debit of credit card |
| `DIRECT_DEBIT_DEBIT_CARD` | "DIRECT_DEBIT_DEBIT_CARD" | Payment method with direct debit of debit card |
| `ONLINE_CREDIT` | "ONLINE_CREDIT" | Payment method with online Credit |
| `LOAN_CREDIT` | "LOAN_CREDIT" | Payment method with DANA Cicil |
| `NETWORK_PAY` | "NETWORK_PAY" | Payment method with e-wallet |
| `CARD` | "CARD" | Payment method with card |

### Usage Example
```java
import id.dana.paymentgateway.v1.model.RefundOptionBill.PayMethodEnum;

public class Example {
    public static void main(String[] args) {
        PayMethodEnum exampleEnum = PayMethodEnum.BALANCE;
    }
}
```



