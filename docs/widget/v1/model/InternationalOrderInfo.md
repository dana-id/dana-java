

# InternationalOrderInfo

Additional information for international orders (non-IDR currency transactions)

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originOrderAmount** | [**Money**](Money.md) | Origin order amount in the original currency. Contains value (amount including cents) and currency (code based on ISO) |  [optional] |
|**exchangeRate** | [**InternationalOrderInfoExchangeRate**](InternationalOrderInfoExchangeRate.md) |  |  [optional] |
|**totalAmount** | [**Money**](Money.md) | Total amount after conversion. Contains value (amount including cents) and currency (code based on ISO) |  [optional] |
|**paymentPromoInfo** | [**PaymentPromoInfo**](PaymentPromoInfo.md) | Define the detail of payment promo information, contains promotion that handled and set by merchant |  [optional] |
|**refundPromoInfo** | [**RefundPromoInfo**](RefundPromoInfo.md) | Define the detail of refund promo information |  [optional] |



