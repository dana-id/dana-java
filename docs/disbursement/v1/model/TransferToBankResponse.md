

# TransferToBankResponse


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**referenceNo** | **String** | Transaction identifier on DANA system |  [optional] |
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction<br> Notes:<br> If the partner receives a timeout or an unexpected response from DANA and partner expects to perform retry request to DANA, please use the partnerReferenceNo that is the same as the one used in the transaction request process before  |  [optional] |
|**transactionDate** | **String** | Transaction date, in format YYYY-MM-DDTHH:mm:ss+07:00. Time must be in GMT+7 (Jakarta time) |  [optional] |
|**referenceNumber** | **String** | Reference number |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



