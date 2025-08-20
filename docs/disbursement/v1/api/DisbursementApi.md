# DisbursementApi

You can use the APIs below to interface with DANA's `DisbursementApi` API.
To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (for sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
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
| Request Parameters | [**BankAccountInquiryRequest**](../model/BankAccountInquiryRequest.md) |
| Return Type | [**BankAccountInquiryResponse**](../model/BankAccountInquiryResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        BankAccountInquiryRequest bankAccountInquiryRequest = new BankAccountInquiryRequest();
        BankAccountInquiryResponse response = api.bankAccountInquiry(bankAccountInquiryRequest);
    }
}
```

<a name="danaAccountInquiry"></a>
## `danaAccountInquiry()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `danaAccountInquiry` |
| Request Parameters | [**DanaAccountInquiryRequest**](../model/DanaAccountInquiryRequest.md) |
| Return Type | [**DanaAccountInquiryResponse**](../model/DanaAccountInquiryResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        DanaAccountInquiryRequest danaAccountInquiryRequest = new DanaAccountInquiryRequest();
        DanaAccountInquiryResponse response = api.danaAccountInquiry(danaAccountInquiryRequest);
    }
}
```

<a name="transferToBank"></a>
## `transferToBank()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToBank` |
| Request Parameters | [**TransferToBankRequest**](../model/TransferToBankRequest.md) |
| Return Type | [**TransferToBankResponse**](../model/TransferToBankResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToBankRequest transferToBankRequest = new TransferToBankRequest();
        TransferToBankResponse response = api.transferToBank(transferToBankRequest);
    }
}
```

<a name="transferToBankInquiryStatus"></a>
## `transferToBankInquiryStatus()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToBankInquiryStatus` |
| Request Parameters | [**TransferToBankInquiryStatusRequest**](../model/TransferToBankInquiryStatusRequest.md) |
| Return Type | [**TransferToBankInquiryStatusResponse**](../model/TransferToBankInquiryStatusResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToBankInquiryStatusRequest transferToBankInquiryStatusRequest = new TransferToBankInquiryStatusRequest();
        TransferToBankInquiryStatusResponse response = api.transferToBankInquiryStatus(transferToBankInquiryStatusRequest);
    }
}
```

<a name="transferToDana"></a>
## `transferToDana()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToDana` |
| Request Parameters | [**TransferToDanaRequest**](../model/TransferToDanaRequest.md) |
| Return Type | [**TransferToDanaResponse**](../model/TransferToDanaResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToDanaRequest transferToDanaRequest = new TransferToDanaRequest();
        TransferToDanaResponse response = api.transferToDana(transferToDanaRequest);
    }
}
```

<a name="transferToDanaInquiryStatus"></a>
## `transferToDanaInquiryStatus()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `transferToDanaInquiryStatus` |
| Request Parameters | [**TransferToDanaInquiryStatusRequest**](../model/TransferToDanaInquiryStatusRequest.md) |
| Return Type | [**TransferToDanaInquiryStatusResponse**](../model/TransferToDanaInquiryStatusResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.disbursement.v1.api.DisbursementApi;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""))
            .env(DanaEnvironment.getByName(ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));

        DanaConfig.getInstance(danaConfigBuilder);

        DisbursementApi api = Dana.getInstance().getDisbursementApi();

        TransferToDanaInquiryStatusRequest transferToDanaInquiryStatusRequest = new TransferToDanaInquiryStatusRequest();
        TransferToDanaInquiryStatusResponse response = api.transferToDanaInquiryStatus(transferToDanaInquiryStatusRequest);
    }
}
```

