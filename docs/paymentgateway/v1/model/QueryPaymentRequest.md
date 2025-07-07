

# QueryPaymentRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system. Required if originalReferenceNo is not filled |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system. Required if originalPartnerReferenceNo is not filled |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request:&lt;br&gt; - IPG Cashier Pay - SNAP: 54&lt;br&gt; - QRIS CPM (Acquirer) - SNAP: 60&lt;br&gt; - QRIS MPM (Acquirer) - SNAP: 47&lt;br&gt; - Payment Gateway: 54&lt;br&gt;  |  |
|**transactionDate** | **String** | Transaction date, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**merchantId** | **String** | Merchant identifier that is unique per each merchant |  |
|**subMerchantId** | **String** | Information of sub merchant identifier |  [optional] |
|**externalStoreId** | **String** | Store identifier to indicate to which store this payment belongs to |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



