

# TransferToBankInquiryStatusRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originalPartnerReferenceNo** | **String** | Original transaction identifier on partner system<br> Notes:<br> Required to be filled using the partnerReferenceNo that is the same as the one used in Transfer to Bank  |  [optional] |
|**originalReferenceNo** | **String** | Original transaction identifier on DANA system |  [optional] |
|**originalExternalId** | **String** | Original external identifier on header message |  [optional] |
|**serviceCode** | **String** | Transaction type indicator is based on the service code of the original transaction request, value always 00 |  |
|**additionalInfo** | **Object** | Additional information |  [optional] |



