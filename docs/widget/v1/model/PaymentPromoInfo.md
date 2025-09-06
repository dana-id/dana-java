

# PaymentPromoInfo

Information about the payment promotion that was applied

## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**promoId** | **String** | Promotion identifier |  |
|**promoName** | **String** | Promotion name |  |
|**promoType** | [**PromoTypeEnum**](#PromoTypeEnum) | Type of promotion |  |
|**savingsAmount** | [**Money**](Money.md) | Savings amount from this promotion. Contains value (amount including cents) and currency (code based on ISO) |  |


<a name="PromoTypeEnum"></a>
## Enum: PromoTypeEnum

| Name | Value | Description |
| - | - | - |
| `CASH_BACK` | "CASH_BACK" |  |
| `DISCOUNT` | "DISCOUNT" |  |
| `VOUCHER` | "VOUCHER" |  |
| `POINT` | "POINT" |  |

### Usage Example
```java
import id.dana.widget.v1.model.PaymentPromoInfo.PromoTypeEnum;

public class Example {
    public static void main(String[] args) {
        PromoTypeEnum exampleEnum = PromoTypeEnum.CASH_BACK;
    }
}
```



