# MerchantManagementApi

You can use the APIs below to interface with DANA's `MerchantManagementApi`. To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (For sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
| - | - | - |
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
| - | - |
| **Function Name** | `createDivision` |
| **Payload** | [**CreateDivisionRequest**](../model/CreateDivisionRequest.md) |
| **Return Type** | [**CreateDivisionResponse**](../model/CreateDivisionResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.CreateDivisionRequest;
import id.dana.merchantmanagement.v1.model.CreateDivisionResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        CreateDivisionRequest createDivisionRequest = new CreateDivisionRequest();

        try {
            CreateDivisionResponse response = api.createDivision(createDivisionRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="createShop"></a>
## `createShop()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `createShop` |
| **Payload** | [**CreateShopRequest**](../model/CreateShopRequest.md) |
| **Return Type** | [**CreateShopResponse**](../model/CreateShopResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.CreateShopRequest;
import id.dana.merchantmanagement.v1.model.CreateShopResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        CreateShopRequest createShopRequest = new CreateShopRequest();

        try {
            CreateShopResponse response = api.createShop(createShopRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="queryDivision"></a>
## `queryDivision()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `queryDivision` |
| **Payload** | [**QueryDivisionRequest**](../model/QueryDivisionRequest.md) |
| **Return Type** | [**QueryDivisionResponse**](../model/QueryDivisionResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.QueryDivisionRequest;
import id.dana.merchantmanagement.v1.model.QueryDivisionResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        QueryDivisionRequest queryDivisionRequest = new QueryDivisionRequest();

        try {
            QueryDivisionResponse response = api.queryDivision(queryDivisionRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="queryMerchantResource"></a>
## `queryMerchantResource()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `queryMerchantResource` |
| **Payload** | [**QueryMerchantResourceRequest**](../model/QueryMerchantResourceRequest.md) |
| **Return Type** | [**QueryMerchantResourceResponse**](../model/QueryMerchantResourceResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.QueryMerchantResourceRequest;
import id.dana.merchantmanagement.v1.model.QueryMerchantResourceResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        QueryMerchantResourceRequest queryMerchantResourceRequest = new QueryMerchantResourceRequest();

        try {
            QueryMerchantResourceResponse response = api.queryMerchantResource(queryMerchantResourceRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="queryShop"></a>
## `queryShop()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `queryShop` |
| **Payload** | [**QueryShopRequest**](../model/QueryShopRequest.md) |
| **Return Type** | [**QueryShopResponse**](../model/QueryShopResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.QueryShopRequest;
import id.dana.merchantmanagement.v1.model.QueryShopResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        QueryShopRequest queryShopRequest = new QueryShopRequest();

        try {
            QueryShopResponse response = api.queryShop(queryShopRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="updateDivision"></a>
## `updateDivision()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `updateDivision` |
| **Payload** | [**UpdateDivisionRequest**](../model/UpdateDivisionRequest.md) |
| **Return Type** | [**UpdateDivisionResponse**](../model/UpdateDivisionResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.UpdateDivisionRequest;
import id.dana.merchantmanagement.v1.model.UpdateDivisionResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        UpdateDivisionRequest updateDivisionRequest = new UpdateDivisionRequest();

        try {
            UpdateDivisionResponse response = api.updateDivision(updateDivisionRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="updateShop"></a>
## `updateShop()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `updateShop` |
| **Payload** | [**UpdateShopRequest**](../model/UpdateShopRequest.md) |
| **Return Type** | [**UpdateShopResponse**](../model/UpdateShopResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.merchantmanagement.v1.api.MerchantManagementApi;

import id.dana.merchantmanagement.v1.model.UpdateShopRequest;
import id.dana.merchantmanagement.v1.model.UpdateShopResponse;

public class Example {
    public static void main(String[] args) {
        MerchantManagementApi api = Dana.getInstance().getMerchantManagementApi();

        UpdateShopRequest updateShopRequest = new UpdateShopRequest();

        try {
            UpdateShopResponse response = api.updateShop(updateShopRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

