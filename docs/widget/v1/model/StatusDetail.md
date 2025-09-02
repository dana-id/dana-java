

# StatusDetail


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**acquirementStatus** | [**AcquirementStatusEnum**](#AcquirementStatusEnum) | The status of acquirement |  |
|**frozen** | **String** | Whether the frozen is true or not |  [optional] |
|**cancelled** | **String** | Whether the cancelled is true or not |  [optional] |


<a name="AcquirementStatusEnum"></a>
## Enum: AcquirementStatusEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| INIT | "INIT" | Order is created but not paid yet |
| SUCCESS | "SUCCESS" | Order is succeeded |
| CLOSED | "CLOSED" | Order is closed |
| PAYING | "PAYING" | Order is paid but not finish |
| MERCHANT_ACCEPT | "MERCHANT_ACCEPT" | Order is accepted by merchant after order is paid for PAY-CONFIRM |
| CANCELLED | "CANCELLED" | Order is cancelled |

### Usage Example
```java
import id.dana.widget.v1.model.StatusDetail.AcquirementStatusEnum;

public class Example {
    public static void main(String[] args) {
        AcquirementStatusEnum exampleEnum = AcquirementStatusEnum.INIT;
    }
}
```



