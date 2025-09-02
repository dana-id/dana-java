

# QueryPaymentRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request:<br> - IPG Cashier Pay - SNAP: 54<br> - QRIS CPM (Acquirer) - SNAP: 60<br> - QRIS MPM (Acquirer) - SNAP: 47<br> - Payment Gateway: 54<br>  |  |
|**transactionDate** | **String** | Transaction date in format YYYY-MM-DDTHH:mm:ss+07:00 (GMT+7, Jakarta time) |  [optional] |
|**amount** | [**Money**](Money.md) |  |  [optional] |
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



