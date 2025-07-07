# WidgetApi

All URIs are relative to *https://api.saas.dana.id*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**accountUnbinding**](WidgetApi.md#accountUnbinding) | **POST** v1.0/registration-account-unbinding.htm | Account unbinding - Binding |
| [**applyOTT**](WidgetApi.md#applyOTT) | **POST** rest/v1.1/qr/apply-ott | Apply OTT - Widget |
| [**applyToken**](WidgetApi.md#applyToken) | **POST** v1.0/access-token/b2b2c.htm | Apply Token, required by Apply OTT - Binding |
| [**cancelOrder**](WidgetApi.md#cancelOrder) | **POST** v1.0/debit/cancel.htm | Cancel Order - Widget |
| [**queryPayment**](WidgetApi.md#queryPayment) | **POST** rest/v1.1/debit/status | Query Payment - Widget |
| [**refundOrder**](WidgetApi.md#refundOrder) | **POST** v1.0/debit/refund.htm | Refund Order - Widget |
| [**widgetPayment**](WidgetApi.md#widgetPayment) | **POST** rest/redirection/v1.0/debit/payment-host-to-host | Widget Payment - Widget |



## accountUnbinding

> AccountUnbindingResponse accountUnbinding(accountUnbindingRequest)

Account unbinding - Binding

This API is used to reverses the account binding process by revoking the accessToken and refreshToken

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        AccountUnbindingRequest accountUnbindingRequest = new AccountUnbindingRequest(); // AccountUnbindingRequest | 
        try {
            AccountUnbindingResponse result = apiInstance.accountUnbinding(accountUnbindingRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#accountUnbinding");
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
| **accountUnbindingRequest** | [**AccountUnbindingRequest**](AccountUnbindingRequest.md)|  | |

### Return type

[**AccountUnbindingResponse**](AccountUnbindingResponse.md)

### Authorization

[X_PARTNER_ID](../README.md#X_PARTNER_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH), [ENV](../README.md#ENV)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Account unbinding response |  -  |


## applyOTT

> ApplyOTTResponse applyOTT(applyOTTRequest)

Apply OTT - Widget

This API is used to get one time token that will be used as authorization parameter upon redirecting to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        ApplyOTTRequest applyOTTRequest = new ApplyOTTRequest(); // ApplyOTTRequest | 
        try {
            ApplyOTTResponse result = apiInstance.applyOTT(applyOTTRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#applyOTT");
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
| **applyOTTRequest** | [**ApplyOTTRequest**](ApplyOTTRequest.md)|  | |

### Return type

[**ApplyOTTResponse**](ApplyOTTResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH), [ENV](../README.md#ENV)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Apply OTT response |  -  |


## applyToken

> ApplyTokenResponse applyToken(applyTokenRequest)

Apply Token, required by Apply OTT - Binding

This API is used to finalized account binding process by exchanging the authCode into accessToken that can be used as user authorization

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: X_PARTNER_ID
        ApiKeyAuth X_PARTNER_ID = (ApiKeyAuth) defaultClient.getAuthentication("X_PARTNER_ID");
        X_PARTNER_ID.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //X_PARTNER_ID.setApiKeyPrefix("Token");

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest(); // ApplyTokenRequest | 
        try {
            ApplyTokenResponse result = apiInstance.applyToken(applyTokenRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#applyToken");
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
| **applyTokenRequest** | [**ApplyTokenRequest**](ApplyTokenRequest.md)|  | |

### Return type

[**ApplyTokenResponse**](ApplyTokenResponse.md)

### Authorization

[X_PARTNER_ID](../README.md#X_PARTNER_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH), [ENV](../README.md#ENV)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Apply token response |  -  |


## cancelOrder

> CancelOrderResponse cancelOrder(cancelOrderRequest)

Cancel Order - Widget

This API is used to cancel the order from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest(); // CancelOrderRequest | 
        try {
            CancelOrderResponse result = apiInstance.cancelOrder(cancelOrderRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#cancelOrder");
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


## queryPayment

> QueryPaymentResponse queryPayment(queryPaymentRequest)

Query Payment - Widget

This API is used to inquiry payment status and information from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        QueryPaymentRequest queryPaymentRequest = new QueryPaymentRequest(); // QueryPaymentRequest | 
        try {
            QueryPaymentResponse result = apiInstance.queryPayment(queryPaymentRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#queryPayment");
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

Refund Order - Widget

This API is used to refund the order from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        RefundOrderRequest refundOrderRequest = new RefundOrderRequest(); // RefundOrderRequest | 
        try {
            RefundOrderResponse result = apiInstance.refundOrder(refundOrderRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#refundOrder");
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


## widgetPayment

> WidgetPaymentResponse widgetPayment(widgetPaymentRequest)

Widget Payment - Widget

This API is used to initiate payment from merchant&#39;s platform to DANA

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.widget.v1.api.WidgetApi;

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

        WidgetApi apiInstance = new WidgetApi(defaultClient);
        WidgetPaymentRequest widgetPaymentRequest = new WidgetPaymentRequest(); // WidgetPaymentRequest | 
        try {
            WidgetPaymentResponse result = apiInstance.widgetPayment(widgetPaymentRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WidgetApi#widgetPayment");
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
| **widgetPaymentRequest** | [**WidgetPaymentRequest**](WidgetPaymentRequest.md)|  | |

### Return type

[**WidgetPaymentResponse**](WidgetPaymentResponse.md)

### Authorization

[ORIGIN](../README.md#ORIGIN), [X_PARTNER_ID](../README.md#X_PARTNER_ID), [CHANNEL_ID](../README.md#CHANNEL_ID), [PRIVATE_KEY](../README.md#PRIVATE_KEY), [PRIVATE_KEY_PATH](../README.md#PRIVATE_KEY_PATH), [ENV](../README.md#ENV)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Widget payment response |  -  |

