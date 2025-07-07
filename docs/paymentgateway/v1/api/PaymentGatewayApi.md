# PaymentGatewayApi

All URIs are relative to *https://api.saas.dana.id*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cancelOrder**](PaymentGatewayApi.md#cancelOrder) | **POST** payment-gateway/v1.0/debit/cancel.htm | Cancel Order - Payment Gateway |
| [**consultPay**](PaymentGatewayApi.md#consultPay) | **POST** v1.0/payment-gateway/consult-pay.htm | Consult Pay - Payment Gateway |
| [**createOrder**](PaymentGatewayApi.md#createOrder) | **POST** payment-gateway/v1.0/debit/payment-host-to-host.htm | Create Order - Payment Gateway |
| [**queryPayment**](PaymentGatewayApi.md#queryPayment) | **POST** payment-gateway/v1.0/debit/status.htm | Query Payment - Payment Gateway |
| [**refundOrder**](PaymentGatewayApi.md#refundOrder) | **POST** payment-gateway/v1.0/debit/refund.htm | Refund Order - Payment Gateway |



## cancelOrder

> CancelOrderResponse cancelOrder(cancelOrderRequest)

Cancel Order - Payment Gateway

This API is used to cancel the order from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: ORIGIN
        ApiKeyAuth ORIGIN = (ApiKeyAuth) defaultClient.getAuthentication("ORIGIN");
        ORIGIN.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ORIGIN.setApiKeyPrefix("Token");

        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: CHANNEL_ID
        ApiKeyAuth CHANNEL_ID = (ApiKeyAuth) defaultClient.getAuthentication("CHANNEL_ID");
        CHANNEL_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CHANNEL_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY
        ApiKeyAuth PRIVATE_KEY = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY");
        PRIVATE_KEY.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY_PATH
        ApiKeyAuth PRIVATE_KEY_PATH = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY_PATH");
        PRIVATE_KEY_PATH.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY_PATH.setApiKeyPrefix("Token");

        PaymentGatewayApi apiInstance = new PaymentGatewayApi(defaultClient);
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest(); // CancelOrderRequest | 
        try {
            CancelOrderResponse result = apiInstance.cancelOrder(cancelOrderRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentGatewayApi#cancelOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cancelOrderRequest** | [**CancelOrderRequest**](CancelOrderRequest.md)|  | |

### Return type

[**CancelOrderResponse**](CancelOrderResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Cancel order response |  -  |
| **202** | Cancel order in progress response |  -  |


## consultPay

> ConsultPayResponse consultPay(consultPayRequest)

Consult Pay - Payment Gateway

This API is used to consult the list of payment methods or payment channels that user has and used in certain transactions or orders

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: ORIGIN
        ApiKeyAuth ORIGIN = (ApiKeyAuth) defaultClient.getAuthentication("ORIGIN");
        ORIGIN.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ORIGIN.setApiKeyPrefix("Token");

        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: CHANNEL_ID
        ApiKeyAuth CHANNEL_ID = (ApiKeyAuth) defaultClient.getAuthentication("CHANNEL_ID");
        CHANNEL_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CHANNEL_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY
        ApiKeyAuth PRIVATE_KEY = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY");
        PRIVATE_KEY.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY_PATH
        ApiKeyAuth PRIVATE_KEY_PATH = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY_PATH");
        PRIVATE_KEY_PATH.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY_PATH.setApiKeyPrefix("Token");

        // Configure API key authorization: ENV
        ApiKeyAuth ENV = (ApiKeyAuth) defaultClient.getAuthentication("ENV");
        ENV.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ENV.setApiKeyPrefix("Token");

        PaymentGatewayApi apiInstance = new PaymentGatewayApi(defaultClient);
        ConsultPayRequest consultPayRequest = new ConsultPayRequest(); // ConsultPayRequest | 
        try {
            ConsultPayResponse result = apiInstance.consultPay(consultPayRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentGatewayApi#consultPay");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **consultPayRequest** | [**ConsultPayRequest**](ConsultPayRequest.md)|  | |

### Return type

[**ConsultPayResponse**](ConsultPayResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH), [ENV](../README.md#ENV)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Consult pay response |  -  |


## createOrder

> CreateOrderResponse createOrder(createOrderRequest)

Create Order - Payment Gateway

This API is used for merchant to create order in DANA side

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: ORIGIN
        ApiKeyAuth ORIGIN = (ApiKeyAuth) defaultClient.getAuthentication("ORIGIN");
        ORIGIN.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ORIGIN.setApiKeyPrefix("Token");

        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: CHANNEL_ID
        ApiKeyAuth CHANNEL_ID = (ApiKeyAuth) defaultClient.getAuthentication("CHANNEL_ID");
        CHANNEL_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CHANNEL_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY
        ApiKeyAuth PRIVATE_KEY = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY");
        PRIVATE_KEY.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY_PATH
        ApiKeyAuth PRIVATE_KEY_PATH = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY_PATH");
        PRIVATE_KEY_PATH.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY_PATH.setApiKeyPrefix("Token");

        // Configure API key authorization: ENV
        ApiKeyAuth ENV = (ApiKeyAuth) defaultClient.getAuthentication("ENV");
        ENV.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ENV.setApiKeyPrefix("Token");

        PaymentGatewayApi apiInstance = new PaymentGatewayApi(defaultClient);
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(); // CreateOrderRequest | 
        try {
            CreateOrderResponse result = apiInstance.createOrder(createOrderRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentGatewayApi#createOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createOrderRequest** | [**CreateOrderRequest**](CreateOrderRequest.md)|  | |

### Return type

[**CreateOrderResponse**](CreateOrderResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH), [ENV](../README.md#ENV)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Create order response |  -  |


## queryPayment

> QueryPaymentResponse queryPayment(queryPaymentRequest)

Query Payment - Payment Gateway

This API is used to inquiry payment status and information from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: ORIGIN
        ApiKeyAuth ORIGIN = (ApiKeyAuth) defaultClient.getAuthentication("ORIGIN");
        ORIGIN.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ORIGIN.setApiKeyPrefix("Token");

        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: CHANNEL_ID
        ApiKeyAuth CHANNEL_ID = (ApiKeyAuth) defaultClient.getAuthentication("CHANNEL_ID");
        CHANNEL_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CHANNEL_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY
        ApiKeyAuth PRIVATE_KEY = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY");
        PRIVATE_KEY.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY_PATH
        ApiKeyAuth PRIVATE_KEY_PATH = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY_PATH");
        PRIVATE_KEY_PATH.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY_PATH.setApiKeyPrefix("Token");

        PaymentGatewayApi apiInstance = new PaymentGatewayApi(defaultClient);
        QueryPaymentRequest queryPaymentRequest = new QueryPaymentRequest(); // QueryPaymentRequest | 
        try {
            QueryPaymentResponse result = apiInstance.queryPayment(queryPaymentRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentGatewayApi#queryPayment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **queryPaymentRequest** | [**QueryPaymentRequest**](QueryPaymentRequest.md)|  | |

### Return type

[**QueryPaymentResponse**](QueryPaymentResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Query payment response |  -  |


## refundOrder

> RefundOrderResponse refundOrder(refundOrderRequest)

Refund Order - Payment Gateway

This API is used to refund the order from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: ORIGIN
        ApiKeyAuth ORIGIN = (ApiKeyAuth) defaultClient.getAuthentication("ORIGIN");
        ORIGIN.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ORIGIN.setApiKeyPrefix("Token");

        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: CHANNEL_ID
        ApiKeyAuth CHANNEL_ID = (ApiKeyAuth) defaultClient.getAuthentication("CHANNEL_ID");
        CHANNEL_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CHANNEL_ID.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY
        ApiKeyAuth PRIVATE_KEY = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY");
        PRIVATE_KEY.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY.setApiKeyPrefix("Token");

        // Configure API key authorization: PRIVATE_KEY_PATH
        ApiKeyAuth PRIVATE_KEY_PATH = (ApiKeyAuth) defaultClient.getAuthentication("PRIVATE_KEY_PATH");
        PRIVATE_KEY_PATH.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PRIVATE_KEY_PATH.setApiKeyPrefix("Token");

        PaymentGatewayApi apiInstance = new PaymentGatewayApi(defaultClient);
        RefundOrderRequest refundOrderRequest = new RefundOrderRequest(); // RefundOrderRequest | 
        try {
            RefundOrderResponse result = apiInstance.refundOrder(refundOrderRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentGatewayApi#refundOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **refundOrderRequest** | [**RefundOrderRequest**](RefundOrderRequest.md)|  | |

### Return type

[**RefundOrderResponse**](RefundOrderResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Refund order response |  -  |
| **202** | Refund order in progress response |  -  |

