

# TransferToDanaResponse


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**referenceNo** | **String** | Transaction identifier on DANA system |  [optional] |
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction<br> Notes:<br> If the partner receives a timeout or an unexpected response from DANA and partner expects to perform retry request to DANA, please use the partnerReferenceNo that is the same as the one used in the transaction request process before  |  |
|**sessionId** | **String** | Session identifier |  [optional] |
|**customerNumber** | **String** | Customer account number, in format 628xxx |  [optional] |
|**customerName** | **String** | Customer account name |  [optional] |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO  |  |
|**additionalInfo** | **Object** | Additional information |  [optional] |



