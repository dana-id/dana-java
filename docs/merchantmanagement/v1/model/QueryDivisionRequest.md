

# QueryDivisionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**merchantId** | **String** | Merchant identifier. Required when divisionIdType is EXTERNAL_ID |  [optional] |
|**divisionId** | **String** | Division identifier or external identifier. Length depends on divisionIdType - INNER_ID (21 max), EXTERNAL_ID (64 max) |  |
|**divisionIdType** | [**DivisionIdTypeEnum**](#DivisionIdTypeEnum) | Division identifier type |  |


<a name="DivisionIdTypeEnum"></a>
## Enum: DivisionIdTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| INNER_ID | "INNER_ID" |  |
| EXTERNAL_ID | "EXTERNAL_ID" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.QueryDivisionRequest.DivisionIdTypeEnum;

public class Example {
    public static void main(String[] args) {
        DivisionIdTypeEnum exampleEnum = DivisionIdTypeEnum.INNER_ID;
    }
}
```



