

# BusinessDocs


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**docType** | [**DocTypeEnum**](#DocTypeEnum) | Document type. \"individu\" entity can only use KTP and SIM. Other entities can use SIUP and NIB |  [optional] |
|**docId** | **String** | Document ID |  [optional] |
|**docFile** | **String** | Document file encoded in base64 |  [optional] |


<a name="DocTypeEnum"></a>
## Enum: DocTypeEnum

| Name | Value | Description |
| ---- | ----- | ----------- |
| KTP | "KTP" |  |
| SIM | "SIM" |  |
| SIUP | "SIUP" |  |
| NIB | "NIB" |  |

### Usage Example
```java
import id.dana.merchantmanagement.v1.model.BusinessDocs.DocTypeEnum;

public class Example {
    public static void main(String[] args) {
        DocTypeEnum exampleEnum = DocTypeEnum.KTP;
    }
}
```



