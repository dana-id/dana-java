# MerchantManagementApi

All URIs are relative to *https://api.saas.dana.id*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDivision**](MerchantManagementApi.md#createDivision) | **POST** dana/merchant/division/createDivision.htm | Create Division |
| [**createShop**](MerchantManagementApi.md#createShop) | **POST** dana/merchant/shop/createShop.htm | Member – Create Shop |
| [**queryDivision**](MerchantManagementApi.md#queryDivision) | **POST** dana/merchant/division/queryDivision.htm | Query Division |
| [**queryMerchantResource**](MerchantManagementApi.md#queryMerchantResource) | **POST** dana/merchant/queryMerchantResource.htm | Member – Merchant Open API Check Disbursement Account |
| [**queryShop**](MerchantManagementApi.md#queryShop) | **POST** dana/merchant/shop/queryShop.htm | Member – Query Shop |
| [**updateDivision**](MerchantManagementApi.md#updateDivision) | **POST** dana/merchant/division/updateDivision.htm | Update Division |
| [**updateShop**](MerchantManagementApi.md#updateShop) | **POST** dana/merchant/shop/updateShop.htm | Update Shop |



## createDivision

> CreateDivisionResponse createDivision(createDivisionRequest)

Create Division

This API is used to create a new division

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        CreateDivisionRequest createDivisionRequest = new CreateDivisionRequest(); // CreateDivisionRequest | 
        try {
            CreateDivisionResponse result = apiInstance.createDivision(createDivisionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#createDivision");
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
| **createDivisionRequest** | [**CreateDivisionRequest**](CreateDivisionRequest.md)|  | |

### Return type

[**CreateDivisionResponse**](CreateDivisionResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Create division response |  -  |


## createShop

> CreateShopResponse createShop(createShopRequest)

Member – Create Shop

Create shop under merchant or division

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        CreateShopRequest createShopRequest = new CreateShopRequest(); // CreateShopRequest | 
        try {
            CreateShopResponse result = apiInstance.createShop(createShopRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#createShop");
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
| **createShopRequest** | [**CreateShopRequest**](CreateShopRequest.md)|  | |

### Return type

[**CreateShopResponse**](CreateShopResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Create shop response |  -  |


## queryDivision

> QueryDivisionResponse queryDivision(queryDivisionRequest)

Query Division

This API is used to obtain information of division

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        QueryDivisionRequest queryDivisionRequest = new QueryDivisionRequest(); // QueryDivisionRequest | 
        try {
            QueryDivisionResponse result = apiInstance.queryDivision(queryDivisionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#queryDivision");
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
| **queryDivisionRequest** | [**QueryDivisionRequest**](QueryDivisionRequest.md)|  | |

### Return type

[**QueryDivisionResponse**](QueryDivisionResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Query division response |  -  |


## queryMerchantResource

> QueryMerchantResourceResponse queryMerchantResource(queryMerchantResourceRequest)

Member – Merchant Open API Check Disbursement Account

The interface is check merchant resource info (account balance merchant)

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        QueryMerchantResourceRequest queryMerchantResourceRequest = new QueryMerchantResourceRequest(); // QueryMerchantResourceRequest | 
        try {
            QueryMerchantResourceResponse result = apiInstance.queryMerchantResource(queryMerchantResourceRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#queryMerchantResource");
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
| **queryMerchantResourceRequest** | [**QueryMerchantResourceRequest**](QueryMerchantResourceRequest.md)|  | |

### Return type

[**QueryMerchantResourceResponse**](QueryMerchantResourceResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Query merchant resource response |  -  |


## queryShop

> QueryShopResponse queryShop(queryShopRequest)

Member – Query Shop

This API is used to obtain information of shop information

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        QueryShopRequest queryShopRequest = new QueryShopRequest(); // QueryShopRequest | 
        try {
            QueryShopResponse result = apiInstance.queryShop(queryShopRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#queryShop");
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
| **queryShopRequest** | [**QueryShopRequest**](QueryShopRequest.md)|  | |

### Return type

[**QueryShopResponse**](QueryShopResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Query shop response |  -  |


## updateDivision

> UpdateDivisionResponse updateDivision(updateDivisionRequest)

Update Division

This API is used to update the division information

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        UpdateDivisionRequest updateDivisionRequest = new UpdateDivisionRequest(); // UpdateDivisionRequest | 
        try {
            UpdateDivisionResponse result = apiInstance.updateDivision(updateDivisionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#updateDivision");
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
| **updateDivisionRequest** | [**UpdateDivisionRequest**](UpdateDivisionRequest.md)|  | |

### Return type

[**UpdateDivisionResponse**](UpdateDivisionResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Update division response |  -  |


## updateShop

> UpdateShopResponse updateShop(updateShopRequest)

Update Shop

This API is used to update the shop information

### Example

```java
// Import classes:
import id.dana.invoker.ApiClient;
import id.dana.invoker.ApiException;
import id.dana.invoker.Configuration;
import id.dana.invoker.auth.*;
import id.dana.invoker.models.*;
import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.saas.dana.id");
        
        // Configure API key authorization: CLIENT_SECRET
        ApiKeyAuth CLIENT_SECRET = (ApiKeyAuth) defaultClient.getAuthentication("CLIENT_SECRET");
        CLIENT_SECRET.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //CLIENT_SECRET.setApiKeyPrefix("Token");

        MerchantManagementApi apiInstance = new MerchantManagementApi(defaultClient);
        UpdateShopRequest updateShopRequest = new UpdateShopRequest(); // UpdateShopRequest | 
        try {
            UpdateShopResponse result = apiInstance.updateShop(updateShopRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantManagementApi#updateShop");
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
| **updateShopRequest** | [**UpdateShopRequest**](UpdateShopRequest.md)|  | |

### Return type

[**UpdateShopResponse**](UpdateShopResponse.md)

### Authorization

[CLIENT_SECRET](../README.md#CLIENT_SECRET)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Update shop response |  -  |

