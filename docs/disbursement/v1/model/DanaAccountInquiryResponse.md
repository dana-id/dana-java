

# DanaAccountInquiryResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**referenceNo** | **String** | Transaction identifier on DANA system |  [optional] |
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction<br> Notes:<br> If the partner receives a timeout or an unexpected response from DANA and partner expects to perform retry request to DANA, please use the partnerReferenceNo that is the same as the one used in the transaction request process before  |  [optional] |
|**sessionId** | **String** | Session identifier |  [optional] |
|**customerNumber** | **String** | Customer account number, in format 628xxx |  [optional] |
|**customerName** | **String** | Customer account name |  |
|**customerMonthlyInLimit** | **String** | Limitation of transfer to DANA balance for customer per month |  [optional] |
|**minAmount** | [**Money**](Money.md) | Minimal amount. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  |
|**maxAmount** | [**Money**](Money.md) | Maximal amount. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:<br> 1. Value: Transaction amount, including the cents<br> 2. Currency: Currency code based on ISO  |  |
|**feeAmount** | [**Money**](Money.md) | Fee amount. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  |
|**feeType** | **String** | Type of fee for each transfer to DANA transaction. Such as admin fee |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



