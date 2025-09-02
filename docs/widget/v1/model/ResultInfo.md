

# ResultInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**resultStatus** | [**ResultStatusEnum**](#ResultStatusEnum) | Result status (S=Success, F=Failure, U=Unknown) |  |
|**resultCodeId** | **String** | Result code identifier |  |
|**resultCode** | **String** | Result code |  |
|**resultMsg** | **String** | Result message |  |


<a name="ResultStatusEnum"></a>
## Enum: ResultStatusEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| S | "S" | Success |
| F | "F" | Failure |
| U | "U" | Unknown |

### Usage Example
```java
import id.dana.widget.v1.model.ResultInfo.ResultStatusEnum;

public class Example {
    public static void main(String[] args) {
        ResultStatusEnum exampleEnum = ResultStatusEnum.S;
    }
}
```



