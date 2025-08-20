# PaymentGatewayApi

You can use the APIs below to interface with DANA's `PaymentGatewayApi` API.
To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

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

        PaymentGatewayApi api = Dana.getInstance().getPaymentGatewayApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (for sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cancelOrder**](PaymentGatewayApi.md#cancelOrder) | **POST** payment-gateway/v1.0/debit/cancel.htm | This API is used to cancel the order from merchant&#39;s platform to DANA |
| [**consultPay**](PaymentGatewayApi.md#consultPay) | **POST** v1.0/payment-gateway/consult-pay.htm | This API is used to consult the list of payment methods or payment channels that user has and used in certain transactions or orders |
| [**createOrder**](PaymentGatewayApi.md#createOrder) | **POST** payment-gateway/v1.0/debit/payment-host-to-host.htm | This API is used for merchant to create order in DANA side |
| [**queryPayment**](PaymentGatewayApi.md#queryPayment) | **POST** payment-gateway/v1.0/debit/status.htm | This API is used to inquiry payment status and information from merchant&#39;s platform to DANA |
| [**refundOrder**](PaymentGatewayApi.md#refundOrder) | **POST** payment-gateway/v1.0/debit/refund.htm | This API is used to refund the order from merchant&#39;s platform to DANA |


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
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

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

        PaymentGatewayApi api = Dana.getInstance().getPaymentGatewayApi();

        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
        CancelOrderResponse response = api.cancelOrder(cancelOrderRequest);
    }
}
```

<a name="consultPay"></a>
## `consultPay()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `consultPay` |
| Request Parameters | [**ConsultPayRequest**](../model/ConsultPayRequest.md) |
| Return Type | [**ConsultPayResponse**](../model/ConsultPayResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

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

        PaymentGatewayApi api = Dana.getInstance().getPaymentGatewayApi();

        ConsultPayRequest consultPayRequest = new ConsultPayRequest();
        ConsultPayResponse response = api.consultPay(consultPayRequest);
    }
}
```

<a name="createOrder"></a>
## `createOrder()` Function

### Function Signature
| Name | Value |
| ------------- | ------------- |
| Function Name | `createOrder` |
| Request Parameters | [**CreateOrderRequest**](../model/CreateOrderRequest.md) |
| Return Type | [**CreateOrderResponse**](../model/CreateOrderResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

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

        PaymentGatewayApi api = Dana.getInstance().getPaymentGatewayApi();

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        CreateOrderResponse response = api.createOrder(createOrderRequest);
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
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

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

        PaymentGatewayApi api = Dana.getInstance().getPaymentGatewayApi();

        QueryPaymentRequest queryPaymentRequest = new QueryPaymentRequest();
        QueryPaymentResponse response = api.queryPayment(queryPaymentRequest);
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
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

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

        PaymentGatewayApi api = Dana.getInstance().getPaymentGatewayApi();

        RefundOrderRequest refundOrderRequest = new RefundOrderRequest();
        RefundOrderResponse response = api.refundOrder(refundOrderRequest);
    }
}
```

