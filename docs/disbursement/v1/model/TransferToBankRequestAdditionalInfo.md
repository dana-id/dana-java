

# TransferToBankRequestAdditionalInfo

Additional information

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fundType** | **String** | Additional information of withdraw fund type, i.e.&lt;br&gt; MERCHANT_WITHDRAW_FOR_CORPORATE  |  |
|**externalDivisionId** | **String** | Additional information of external division identifier. (fundType: MERCHANT_WITHDRAW_FOR_CORPORATE)&lt;br&gt; Notes: The required of this parameter is Optional, but if \&quot;additionalInfo.chargeTarget\&quot; has value DIVISION then the required of this parameter will be changed to Mandatory  |  [optional] |
|**chargeTarget** | [**ChargeTargetEnum**](#ChargeTargetEnum) | Additional information of charge target. The values are:&lt;br&gt; • null&lt;br&gt; • DIVISION&lt;br&gt; • MERCHANT&lt;br&gt; Notes: If the value is DIVISION, externalDivisionId will be Mandatory  |  [optional] |
|**needNotify** | **Boolean** | Additional information of flag result notification on transaction completed (result sync/async) |  [optional] |
|**beneficiaryAccountName** | **String** | Additional information of beneficiary account name for validation purpose |  [optional] |
|**accessToken** | **String** | Contains customer token, which has been obtained from binding process, refer to Account Binding &amp; Unbinding documentation&lt;br&gt; If request is coming from user interaction, this field is mandatory. If not, just filled customerNumber  |  [optional] |



## Enum: ChargeTargetEnum

| Name | Value |
|---- | -----|
| DIVISION | &quot;DIVISION&quot; |
| MERCHANT | &quot;MERCHANT&quot; |



