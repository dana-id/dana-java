

# BalanceInquiryResponse


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**responseCode** | **String** | Refer to response code list |  |
|**responseMessage** | **String** | Refer to response code list |  |
|**referenceNo** | **String** | Transaction identifier on DANA system |  [optional] |
|**partnerReferenceNo** | **String** | Unique transaction identifier on partner system which assigned to each transaction<br> Notes:<br> If the partner receives a timeout or an unexpected response from DANA and partner expects to perform retry request to DANA, please use the partnerReferenceNo that is the same as the one used in the transaction request process before  |  [optional] |
|**name** | **String** | Customer account name |  [optional] |
|**accountInfos** | [**List&lt;AccountInfo&gt;**](AccountInfo.md) | Account information |  [optional] |
|**additionalInfo** | **Object** | Additional information |  [optional] |



