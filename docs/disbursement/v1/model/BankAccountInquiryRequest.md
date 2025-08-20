

# BankAccountInquiryRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction&lt;br&gt; Notes:&lt;br&gt; If the partner receives a timeout or an unexpected response from DANA and partner expects to perform retry request to DANA, please use the partnerReferenceNo that is the same as the one used in the transaction request process before  |  [optional] |
|**customerNumber** | **String** | Customer account number, in format 628xxx |  |
|**beneficiaryAccountNumber** | **String** | Beneficiary account number |  |
|**amount** | [**Money**](Money.md) | Amount. Contains two sub-fields:&lt;br&gt; 1. Value: Transaction amount, including the cents&lt;br&gt; 2. Currency: Currency code based on ISO  |  |
|**additionalInfo** | [**BankAccountInquiryRequestAdditionalInfo**](BankAccountInquiryRequestAdditionalInfo.md) |  |  |



