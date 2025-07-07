

# RefundPromoInfo

Information about the refund promotion that was applied

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**promoId** | **String** | Promotion identifier |  |
|**promoName** | **String** | Promotion name |  |
|**promoType** | [**PromoTypeEnum**](#PromoTypeEnum) | Type of promotion |  |
|**refundAmount** | [**Money**](Money.md) | Refund amount from this promotion. Contains value (amount including cents) and currency (code based on ISO) |  |



## Enum: PromoTypeEnum

| Name | Value |
|---- | -----|
| CASH_BACK | &quot;CASH_BACK&quot; |
| DISCOUNT | &quot;DISCOUNT&quot; |
| VOUCHER | &quot;VOUCHER&quot; |
| POINT | &quot;POINT&quot; |



