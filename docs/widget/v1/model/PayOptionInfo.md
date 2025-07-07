

# PayOptionInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payMethod** | [**PayMethodEnum**](#PayMethodEnum) | Payment method name. The enums:&lt;br&gt;   * BALANCE - Payment method with balance&lt;br&gt;   * COUPON - Payment method with coupon&lt;br&gt;   * NET_BANKING - Payment method with internet banking&lt;br&gt;   * CREDIT_CARD - Payment method with credit card&lt;br&gt;   * DEBIT_CARD - Payment method with debit card&lt;br&gt;   * VIRTUAL_ACCOUNT - Payment method with virtual account&lt;br&gt;   * OTC - Payment method with OTC&lt;br&gt;   * DIRECT_DEBIT_CREDIT_CARD - Payment method with direct debit of credit card&lt;br&gt;   * DIRECT_DEBIT_DEBIT_CARD - Payment method with direct debit of debit card&lt;br&gt;   * ONLINE_CREDIT - Payment method with online Credit&lt;br&gt;   * LOAN_CREDIT - Payment method with DANA Cicil&lt;br&gt;   * NETWORK_PAY - Payment method with e-wallet  |  |
|**payOption** | [**PayOptionEnum**](#PayOptionEnum) | Payment option which shows the provider of this payment. The enums:&lt;br&gt;   * NETWORK_PAY_PG_SPAY - Payment method with ShopeePay e-wallet&lt;br&gt;   * NETWORK_PAY_PG_OVO - Payment method with OVO e-wallet&lt;br&gt;   * NETWORK_PAY_PG_GOPAY - Payment method with GoPay e-wallet&lt;br&gt;   * NETWORK_PAY_PG_LINKAJA - Payment method with LinkAja e-wallet&lt;br&gt;   * NETWORK_PAY_PG_CARD - Payment method with Card&lt;br&gt;   * VIRTUAL_ACCOUNT_BCA - Payment method with BCA virtual account&lt;br&gt;   * VIRTUAL_ACCOUNT_BNI - Payment method with BNI virtual account&lt;br&gt;   * VIRTUAL_ACCOUNT_MANDIRI - Payment method with Mandiri virtual account&lt;br&gt;   * VIRTUAL_ACCOUNT_BRI - Payment method with BRI virtual account&lt;br&gt;   * VIRTUAL_ACCOUNT_BTPN - Payment method with BTPN virtual account&lt;br&gt;   * VIRTUAL_ACCOUNT_CIMB - Payment method with CIMB virtual account&lt;br&gt;   * VIRTUAL_ACCOUNT_PERMATA - Payment method with Permata virtual account&lt;br&gt;  |  [optional] |
|**payAmount** | [**Money**](Money.md) | Pay amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**transAmount** | [**Money**](Money.md) | Trans amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**chargeAmount** | [**Money**](Money.md) | Charge amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**payOptionBillExtendInfo** | **String** | Extend information of pay option bill |  [optional] |
|**extendInfo** | **String** | Extend information |  [optional] |
|**paymentCode** | **String** | Payment code |  [optional] |



## Enum: PayMethodEnum

| Name | Value |
|---- | -----|
| BALANCE | &quot;BALANCE&quot; |
| COUPON | &quot;COUPON&quot; |
| NET_BANKING | &quot;NET_BANKING&quot; |
| CREDIT_CARD | &quot;CREDIT_CARD&quot; |
| DEBIT_CARD | &quot;DEBIT_CARD&quot; |
| VIRTUAL_ACCOUNT | &quot;VIRTUAL_ACCOUNT&quot; |
| OTC | &quot;OTC&quot; |
| DIRECT_DEBIT_CREDIT_CARD | &quot;DIRECT_DEBIT_CREDIT_CARD&quot; |
| DIRECT_DEBIT_DEBIT_CARD | &quot;DIRECT_DEBIT_DEBIT_CARD&quot; |
| ONLINE_CREDIT | &quot;ONLINE_CREDIT&quot; |
| LOAN_CREDIT | &quot;LOAN_CREDIT&quot; |
| NETWORK_PAY | &quot;NETWORK_PAY&quot; |



## Enum: PayOptionEnum

| Name | Value |
|---- | -----|
| NETWORK_PAY_PG_SPAY | &quot;NETWORK_PAY_PG_SPAY&quot; |
| NETWORK_PAY_PG_OVO | &quot;NETWORK_PAY_PG_OVO&quot; |
| NETWORK_PAY_PG_GOPAY | &quot;NETWORK_PAY_PG_GOPAY&quot; |
| NETWORK_PAY_PG_LINKAJA | &quot;NETWORK_PAY_PG_LINKAJA&quot; |
| NETWORK_PAY_PG_CARD | &quot;NETWORK_PAY_PG_CARD&quot; |
| VIRTUAL_ACCOUNT_BCA | &quot;VIRTUAL_ACCOUNT_BCA&quot; |
| VIRTUAL_ACCOUNT_BNI | &quot;VIRTUAL_ACCOUNT_BNI&quot; |
| VIRTUAL_ACCOUNT_MANDIRI | &quot;VIRTUAL_ACCOUNT_MANDIRI&quot; |
| VIRTUAL_ACCOUNT_BRI | &quot;VIRTUAL_ACCOUNT_BRI&quot; |
| VIRTUAL_ACCOUNT_BTPN | &quot;VIRTUAL_ACCOUNT_BTPN&quot; |
| VIRTUAL_ACCOUNT_CIMB | &quot;VIRTUAL_ACCOUNT_CIMB&quot; |
| VIRTUAL_ACCOUNT_PERMATA | &quot;VIRTUAL_ACCOUNT_PERMATA&quot; |



