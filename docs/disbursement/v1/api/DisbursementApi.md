# DisbursementApi

You can use the APIs below to interface with DANA's `DisbursementApi`. To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (For sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**bankAccountInquiry**](DisbursementApi.md#bankAccountInquiry) | **POST** v1.0/emoney/bank-account-inquiry.htm | This API is used for merchant to do inquiry Bank account info via DANA |
| [**danaAccountInquiry**](DisbursementApi.md#danaAccountInquiry) | **POST** v1.0/emoney/account-inquiry.htm | This API is used for merchant to do account inquiry to DANA |
| [**transferToBank**](DisbursementApi.md#transferToBank) | **POST** v1.0/emoney/transfer-bank.htm | This API is used for merchant to do transfer to Bank request via DANA |
| [**transferToBankInquiryStatus**](DisbursementApi.md#transferToBankInquiryStatus) | **POST** v1.0/emoney/transfer-bank-status.htm | This API is used for merchant to do inquiry status transfer to Bank transaction to DANA |
| [**transferToDana**](DisbursementApi.md#transferToDana) | **POST** v1.0/emoney/topup.htm | This API is used for merchant to do top up request to DANA |
| [**transferToDanaInquiryStatus**](DisbursementApi.md#transferToDanaInquiryStatus) | **POST** v1.0/emoney/topup-status.htm | This API is used for merchant to do inquiry status top up transaction to DANA |


<a name="bankAccountInquiry"></a>
## `bankAccountInquiry()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `bankAccountInquiry` |
| Payload | [**BankAccountInquiryRequest**](../model/BankAccountInquiryRequest.md) |
| Return Type | [**BankAccountInquiryResponse**](../model/BankAccountInquiryResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.disbursement.v1.model.BankAccountInquiryRequest;
import id.dana.disbursement.v1.model.BankAccountInquiryResponse;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        BankAccountInquiryRequest bankAccountInquiryRequest = new BankAccountInquiryRequest();

        try {
            BankAccountInquiryResponse response = api.bankAccountInquiry(bankAccountInquiryRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="danaAccountInquiry"></a>
## `danaAccountInquiry()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `danaAccountInquiry` |
| Payload | [**DanaAccountInquiryRequest**](../model/DanaAccountInquiryRequest.md) |
| Return Type | [**DanaAccountInquiryResponse**](../model/DanaAccountInquiryResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.disbursement.v1.model.DanaAccountInquiryRequest;
import id.dana.disbursement.v1.model.DanaAccountInquiryResponse;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        DanaAccountInquiryRequest danaAccountInquiryRequest = new DanaAccountInquiryRequest();

        try {
            DanaAccountInquiryResponse response = api.danaAccountInquiry(danaAccountInquiryRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="transferToBank"></a>
## `transferToBank()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToBank` |
| Payload | [**TransferToBankRequest**](../model/TransferToBankRequest.md) |
| Return Type | [**TransferToBankResponse**](../model/TransferToBankResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.disbursement.v1.model.TransferToBankRequest;
import id.dana.disbursement.v1.model.TransferToBankResponse;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToBankRequest transferToBankRequest = new TransferToBankRequest();

        try {
            TransferToBankResponse response = api.transferToBank(transferToBankRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="transferToBankInquiryStatus"></a>
## `transferToBankInquiryStatus()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToBankInquiryStatus` |
| Payload | [**TransferToBankInquiryStatusRequest**](../model/TransferToBankInquiryStatusRequest.md) |
| Return Type | [**TransferToBankInquiryStatusResponse**](../model/TransferToBankInquiryStatusResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.disbursement.v1.model.TransferToBankInquiryStatusRequest;
import id.dana.disbursement.v1.model.TransferToBankInquiryStatusResponse;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToBankInquiryStatusRequest transferToBankInquiryStatusRequest = new TransferToBankInquiryStatusRequest();

        try {
            TransferToBankInquiryStatusResponse response = api.transferToBankInquiryStatus(transferToBankInquiryStatusRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="transferToDana"></a>
## `transferToDana()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToDana` |
| Payload | [**TransferToDanaRequest**](../model/TransferToDanaRequest.md) |
| Return Type | [**TransferToDanaResponse**](../model/TransferToDanaResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.disbursement.v1.model.TransferToDanaRequest;
import id.dana.disbursement.v1.model.TransferToDanaResponse;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToDanaRequest transferToDanaRequest = new TransferToDanaRequest();

        try {
            TransferToDanaResponse response = api.transferToDana(transferToDanaRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="transferToDanaInquiryStatus"></a>
## `transferToDanaInquiryStatus()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToDanaInquiryStatus` |
| Payload | [**TransferToDanaInquiryStatusRequest**](../model/TransferToDanaInquiryStatusRequest.md) |
| Return Type | [**TransferToDanaInquiryStatusResponse**](../model/TransferToDanaInquiryStatusResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.disbursement.v1.model.TransferToDanaInquiryStatusRequest;
import id.dana.disbursement.v1.model.TransferToDanaInquiryStatusResponse;

public class Example {
    public static void main(String[] args) {
        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToDanaInquiryStatusRequest transferToDanaInquiryStatusRequest = new TransferToDanaInquiryStatusRequest();

        try {
            TransferToDanaInquiryStatusResponse response = api.transferToDanaInquiryStatus(transferToDanaInquiryStatusRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

