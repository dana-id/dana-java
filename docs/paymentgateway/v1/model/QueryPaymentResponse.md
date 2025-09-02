

# QueryPaymentResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**responseCode** | **String** | Response code. Refer to https://dashboard.dana.id/api-docs/read/126#HTML-API-QueryPayment-ResponseCodeandMessage |  |
|**responseMessage** | **String** | Response message. Refer to https://dashboard.dana.id/api-docs/read/126#HTML-API-QueryPayment-ResponseCodeandMessage |  |
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system. Present if transaction found |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system. Present if transaction found |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request:<br> - IPG Cashier Pay - SNAP: 54<br> - QRIS CPM (Acquirer) - SNAP: 60<br> - QRIS MPM (Acquirer) - SNAP: 47<br> - Payment Gateway: 54<br>  |  |
|**latestTransactionStatus** | **String** | Category code for the status of the transaction. The values include:<br> - 00 = Success, the order has been successfully in final state and paid<br> - 01 = Initiated, the order has been created, but has not been paid<br> - 02 = Paying, the order is in process, not in final state, payment is success<br> - 05 = Cancelled, the order has been closed<br> - 07 = Not found, the order is not found<br>  |  |
|**transactionStatusDesc** | **String** | Description of transaction status |  [optional] |
|**originalResponseCode** | **String** | Original response code |  [optional] |
|**originalResponseMessage** | **String** | Original response message |  [optional] |
|**sessionId** | **String** | Session identifier |  [optional] |
|**requestID** | **String** | Transaction request identifier |  [optional] |
|**transAmount** | [**Money**](Money.md) | Trans amount. Present if transaction found. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Present if transaction found. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |
|**feeAmount** | [**Money**](Money.md) | Fee amount. Present if transaction found. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO<br>  |  [optional] |
|**paidTime** | **String** | Transaction paid time, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time). Present if transaction is paid |  [optional] |
|**title** | **String** | Brief description. Present if transaction found |  [optional] |
|**additionalInfo** | [**QueryPaymentResponseAdditionalInfo**](QueryPaymentResponseAdditionalInfo.md) | Additional information |  [optional] |



