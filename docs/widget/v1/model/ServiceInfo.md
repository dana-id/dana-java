

# ServiceInfo


## Properties

| Name | Type | Description | Notes |
| - | - | - | - |
|**serviceType** | [**ServiceTypeEnum**](#ServiceTypeEnum) |  |  [optional] |
|**serviceScenario** | [**ServiceScenarioEnum**](#ServiceScenarioEnum) |  |  [optional] |
|**extendInfo** | **String** | Extend information |  [optional] |


<a name="ServiceTypeEnum"></a>
## Enum: ServiceTypeEnum

| Name | Value | Description |
| - | - | - |
| `PARKING` | "PARKING" |  |
| `INVESTMENT` | "INVESTMENT" |  |

### Usage Example
```java
import id.dana.widget.v1.model.ServiceInfo.ServiceTypeEnum;

public class Example {
    public static void main(String[] args) {
        ServiceTypeEnum exampleEnum = ServiceTypeEnum.PARKING;
    }
}
```


<a name="ServiceScenarioEnum"></a>
## Enum: ServiceScenarioEnum

| Name | Value | Description |
| - | - | - |
| `SCAN_AND_PAY` | "SCAN_AND_PAY" |  |
| `EXIT_AND_PAY` | "EXIT_AND_PAY" |  |
| `EMAS_PURCHASE` | "EMAS_PURCHASE" |  |

### Usage Example
```java
import id.dana.widget.v1.model.ServiceInfo.ServiceScenarioEnum;

public class Example {
    public static void main(String[] args) {
        ServiceScenarioEnum exampleEnum = ServiceScenarioEnum.SCAN_AND_PAY;
    }
}
```



