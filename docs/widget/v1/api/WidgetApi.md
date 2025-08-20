# WidgetApi

You can use the APIs below to interface with DANA's `WidgetApi` API.
To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (for sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**accountUnbinding**](WidgetApi.md#accountUnbinding) | **POST** v1.0/registration-account-unbinding.htm | This API is used to reverses the account binding process by revoking the accessToken and refreshToken |
| [**applyOTT**](WidgetApi.md#applyOTT) | **POST** rest/v1.1/qr/apply-ott | This API is used to get one time token that will be used as authorization parameter upon redirecting to DANA |
| [**applyToken**](WidgetApi.md#applyToken) | **POST** v1.0/access-token/b2b2c.htm | This API is used to finalized account binding process by exchanging the authCode into accessToken that can be used as user authorization |
| [**balanceInquiry**](WidgetApi.md#balanceInquiry) | **POST** v1.0/balance-inquiry.htm | This API is used to query user&#39;s DANA account balance via merchant |
| [**cancelOrder**](WidgetApi.md#cancelOrder) | **POST** v1.0/debit/cancel.htm | This API is used to cancel the order from merchant&#39;s platform to DANA |
| [**queryPayment**](WidgetApi.md#queryPayment) | **POST** rest/v1.1/debit/status | This API is used to inquiry payment status and information from merchant&#39;s platform to DANA |
| [**queryUserProfile**](WidgetApi.md#queryUserProfile) | **POST** dana/member/query/queryUserProfile.htm | The API is used to query user profile such as DANA balance (unit in IDR), masked DANA phone number, KYC or OTT (one time token) between merchant server and DANA&#39;s server |
| [**refundOrder**](WidgetApi.md#refundOrder) | **POST** v1.0/debit/refund.htm | This API is used to refund the order from merchant&#39;s platform to DANA |
| [**widgetPayment**](WidgetApi.md#widgetPayment) | **POST** rest/redirection/v1.0/debit/payment-host-to-host | This API is used to initiate payment from merchant&#39;s platform to DANA |


<a name="accountUnbinding"></a>
## `accountUnbinding()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `accountUnbinding` |
| Request Parameters | [**AccountUnbindingRequest**](../model/AccountUnbindingRequest.md) |
| Return Type | [**AccountUnbindingResponse**](../model/AccountUnbindingResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        AccountUnbindingRequest accountUnbindingRequest = new AccountUnbindingRequest();
        AccountUnbindingResponse response = api.accountUnbinding(accountUnbindingRequest);
    }
}
```

<a name="applyOTT"></a>
## `applyOTT()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `applyOTT` |
| Request Parameters | [**ApplyOTTRequest**](../model/ApplyOTTRequest.md) |
| Return Type | [**ApplyOTTResponse**](../model/ApplyOTTResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        ApplyOTTRequest applyOTTRequest = new ApplyOTTRequest();
        ApplyOTTResponse response = api.applyOTT(applyOTTRequest);
    }
}
```

<a name="applyToken"></a>
## `applyToken()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `applyToken` |
| Request Parameters | [**ApplyTokenRequest**](../model/ApplyTokenRequest.md) |
| Return Type | [**ApplyTokenResponse**](../model/ApplyTokenResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        ApplyTokenResponse response = api.applyToken(applyTokenRequest);
    }
}
```

<a name="balanceInquiry"></a>
## `balanceInquiry()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `balanceInquiry` |
| Request Parameters | [**BalanceInquiryRequest**](../model/BalanceInquiryRequest.md) |
| Return Type | [**BalanceInquiryResponse**](../model/BalanceInquiryResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        BalanceInquiryRequest balanceInquiryRequest = new BalanceInquiryRequest();
        BalanceInquiryResponse response = api.balanceInquiry(balanceInquiryRequest);
    }
}
```

<a name="cancelOrder"></a>
## `cancelOrder()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `cancelOrder` |
| Request Parameters | [**CancelOrderRequest**](../model/CancelOrderRequest.md) |
| Return Type | [**CancelOrderResponse**](../model/CancelOrderResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
        CancelOrderResponse response = api.cancelOrder(cancelOrderRequest);
    }
}
```

<a name="queryPayment"></a>
## `queryPayment()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `queryPayment` |
| Request Parameters | [**QueryPaymentRequest**](../model/QueryPaymentRequest.md) |
| Return Type | [**QueryPaymentResponse**](../model/QueryPaymentResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        QueryPaymentRequest queryPaymentRequest = new QueryPaymentRequest();
        QueryPaymentResponse response = api.queryPayment(queryPaymentRequest);
    }
}
```

<a name="queryUserProfile"></a>
## `queryUserProfile()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `queryUserProfile` |
| Request Parameters | [**QueryUserProfileRequest**](../model/QueryUserProfileRequest.md) |
| Return Type | [**QueryUserProfileResponse**](../model/QueryUserProfileResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        QueryUserProfileRequest queryUserProfileRequest = new QueryUserProfileRequest();
        QueryUserProfileResponse response = api.queryUserProfile(queryUserProfileRequest);
    }
}
```

<a name="refundOrder"></a>
## `refundOrder()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `refundOrder` |
| Request Parameters | [**RefundOrderRequest**](../model/RefundOrderRequest.md) |
| Return Type | [**RefundOrderResponse**](../model/RefundOrderResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        RefundOrderRequest refundOrderRequest = new RefundOrderRequest();
        RefundOrderResponse response = api.refundOrder(refundOrderRequest);
    }
}
```

<a name="widgetPayment"></a>
## `widgetPayment()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `widgetPayment` |
| Request Parameters | [**WidgetPaymentRequest**](../model/WidgetPaymentRequest.md) |
| Return Type | [**WidgetPaymentResponse**](../model/WidgetPaymentResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi api = Dana.getInstance().getWidgetApi();

        WidgetPaymentRequest widgetPaymentRequest = new WidgetPaymentRequest();
        WidgetPaymentResponse response = api.widgetPayment(widgetPaymentRequest);
    }
}
```

