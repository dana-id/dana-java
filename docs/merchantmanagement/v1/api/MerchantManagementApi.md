# MerchantManagementApi

You can use the APIs below to interface with DANA's `MerchantManagementApi` API.
To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (for sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDivision**](MerchantManagementApi.md#createDivision) | **POST** dana/merchant/division/createDivision.htm | This API is used to create a new division |
| [**createShop**](MerchantManagementApi.md#createShop) | **POST** dana/merchant/shop/createShop.htm | Create shop under merchant or division |
| [**queryDivision**](MerchantManagementApi.md#queryDivision) | **POST** dana/merchant/division/queryDivision.htm | This API is used to obtain information of division |
| [**queryMerchantResource**](MerchantManagementApi.md#queryMerchantResource) | **POST** dana/merchant/queryMerchantResource.htm | The interface is check merchant resource info (account balance merchant) |
| [**queryShop**](MerchantManagementApi.md#queryShop) | **POST** dana/merchant/shop/queryShop.htm | This API is used to obtain information of shop information |
| [**updateDivision**](MerchantManagementApi.md#updateDivision) | **POST** dana/merchant/division/updateDivision.htm | This API is used to update the division information |
| [**updateShop**](MerchantManagementApi.md#updateShop) | **POST** dana/merchant/shop/updateShop.htm | This API is used to update the shop information |


<a name="createDivision"></a>
## `createDivision()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `createDivision` |
| Request Parameters | [**CreateDivisionRequest**](../model/CreateDivisionRequest.md) |
| Return Type | [**CreateDivisionResponse**](../model/CreateDivisionResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        CreateDivisionRequest createDivisionRequest = new CreateDivisionRequest();
        CreateDivisionResponse response = api.createDivision(createDivisionRequest);
    }
}
```

<a name="createShop"></a>
## `createShop()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `createShop` |
| Request Parameters | [**CreateShopRequest**](../model/CreateShopRequest.md) |
| Return Type | [**CreateShopResponse**](../model/CreateShopResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        CreateShopRequest createShopRequest = new CreateShopRequest();
        CreateShopResponse response = api.createShop(createShopRequest);
    }
}
```

<a name="queryDivision"></a>
## `queryDivision()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `queryDivision` |
| Request Parameters | [**QueryDivisionRequest**](../model/QueryDivisionRequest.md) |
| Return Type | [**QueryDivisionResponse**](../model/QueryDivisionResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        QueryDivisionRequest queryDivisionRequest = new QueryDivisionRequest();
        QueryDivisionResponse response = api.queryDivision(queryDivisionRequest);
    }
}
```

<a name="queryMerchantResource"></a>
## `queryMerchantResource()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `queryMerchantResource` |
| Request Parameters | [**QueryMerchantResourceRequest**](../model/QueryMerchantResourceRequest.md) |
| Return Type | [**QueryMerchantResourceResponse**](../model/QueryMerchantResourceResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        QueryMerchantResourceRequest queryMerchantResourceRequest = new QueryMerchantResourceRequest();
        QueryMerchantResourceResponse response = api.queryMerchantResource(queryMerchantResourceRequest);
    }
}
```

<a name="queryShop"></a>
## `queryShop()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `queryShop` |
| Request Parameters | [**QueryShopRequest**](../model/QueryShopRequest.md) |
| Return Type | [**QueryShopResponse**](../model/QueryShopResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        QueryShopRequest queryShopRequest = new QueryShopRequest();
        QueryShopResponse response = api.queryShop(queryShopRequest);
    }
}
```

<a name="updateDivision"></a>
## `updateDivision()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `updateDivision` |
| Request Parameters | [**UpdateDivisionRequest**](../model/UpdateDivisionRequest.md) |
| Return Type | [**UpdateDivisionResponse**](../model/UpdateDivisionResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        UpdateDivisionRequest updateDivisionRequest = new UpdateDivisionRequest();
        UpdateDivisionResponse response = api.updateDivision(updateDivisionRequest);
    }
}
```

<a name="updateShop"></a>
## `updateShop()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `updateShop` |
| Request Parameters | [**UpdateShopRequest**](../model/UpdateShopRequest.md) |
| Return Type | [**UpdateShopResponse**](../model/UpdateShopResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

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

        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        UpdateShopRequest updateShopRequest = new UpdateShopRequest();
        UpdateShopResponse response = api.updateShop(updateShopRequest);
    }
}
```

