

# QueryPaymentResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**responseCode** | **String** | Response code. Refer to https://dashboard.dana.id/api-docs/read/126#HTML-API-QueryPayment-ResponseCodeandMessage |  |
|**responseMessage** | **String** | Response message. Refer to https://dashboard.dana.id/api-docs/read/126#HTML-API-QueryPayment-ResponseCodeandMessage |  |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system. Present if transaction found |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system. Present if transaction found |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request:&lt;br&gt; - IPG Cashier Pay - SNAP: 54&lt;br&gt; - QRIS CPM (Acquirer) - SNAP: 60&lt;br&gt; - QRIS MPM (Acquirer) - SNAP: 47&lt;br&gt; - Payment Gateway: 54&lt;br&gt;  |  |
|**latestTransactionStatus** | **String** | Category code for the status of the transaction. The values include:&lt;br&gt; - 00 &#x3D; Success, the order has been successfully in final state and paid&lt;br&gt; - 01 &#x3D; Initiated, the order has been created, but has not been paid&lt;br&gt; - 02 &#x3D; Paying, the order is in process, not in final state, payment is success&lt;br&gt; - 05 &#x3D; Cancelled, the order has been closed&lt;br&gt; - 07 &#x3D; Not found, the order is not found&lt;br&gt;  |  |
|**transactionStatusDesc** | **String** | Description of transaction status |  [optional] |
|**originalResponseCode** | **String** | Original response code |  [optional] |
|**originalResponseMessage** | **String** | Original response message |  [optional] |
|**sessionId** | **String** | Session identifier |  [optional] |
|**requestID** | **String** | Transaction request identifier |  [optional] |
|**transAmount** | [**Money**](Money.md) | Trans amount. Present if transaction found. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Present if transaction found. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**feeAmount** | [**Money**](Money.md) | Fee amount. Present if transaction found. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO&lt;br&gt;  |  [optional] |
|**paidTime** | **String** | Transaction paid time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time). Present if transaction is paid |  [optional] |
|**title** | **String** | Brief description. Present if transaction found |  [optional] |
|**additionalInfo** | [**QueryPaymentResponseAdditionalInfo**](QueryPaymentResponseAdditionalInfo.md) | Additional information |  [optional] |



