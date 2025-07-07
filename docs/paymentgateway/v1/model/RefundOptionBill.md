

# RefundOptionBill


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**payMethod** | [**PayMethodEnum**](#PayMethodEnum) | Payment method name. The enums:&lt;br&gt;   * BALANCE - Payment method with balance&lt;br&gt;   * COUPON - Payment method with coupon&lt;br&gt;   * NET_BANKING - Payment method with internet banking&lt;br&gt;   * CREDIT_CARD - Payment method with credit card&lt;br&gt;   * DEBIT_CARD - Payment method with debit card&lt;br&gt;   * VIRTUAL_ACCOUNT - Payment method with virtual account&lt;br&gt;   * OTC - Payment method with OTC&lt;br&gt;   * DIRECT_DEBIT_CREDIT_CARD - Payment method with direct debit of credit card&lt;br&gt;   * DIRECT_DEBIT_DEBIT_CARD - Payment method with direct debit of debit card&lt;br&gt;   * ONLINE_CREDIT - Payment method with online Credit&lt;br&gt;   * LOAN_CREDIT - Payment method with DANA Cicil&lt;br&gt;  |  [optional] |
|**transAmount** | [**Money**](Money.md) | Trans amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |



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



