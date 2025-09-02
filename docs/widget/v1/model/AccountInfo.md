

# AccountInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**balanceType** | **String** | Account information of balance type to specify which balance type expected to be returned. Will return all available balance type if this parameter empty |  [optional] |
|**amount** | [**Money**](Money.md) | Account information of amount which include the net active amount. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**floatAmount** | [**Money**](Money.md) | Account information of float amount which include the inactive amount due to cut off period. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**holdAmount** | [**Money**](Money.md) | Account information of hold amount which include the unusable amount due to certain type of transaction. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**availableBalance** | [**Money**](Money.md) | Account information of available balance which include the active amount that can be used for transaction. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**ledgerBalance** | [**Money**](Money.md) | Account information of ledger balance which include the starting balance for this day. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**currentMultilateralLimit** | [**Money**](Money.md) | Account information of current multilateral limit. Contains two sub-fields:<br> 1. Value: Amount, including the cents<br> 2. Currency: Currency code based on ISO  |  [optional] |
|**registrationStatusCode** | **String** | Account information of customer registration status |  [optional] |
|**status** | **String** | Account information of status. The values include:<br> 1 = Active Account<br> 2 = Closed Account<br> 4 = New Account<br> 6 = Restricted Account<br> 7 = Frozen Account  |  [optional] |



