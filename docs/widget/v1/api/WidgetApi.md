# WidgetApi

You can use the APIs below to interface with DANA's `WidgetApi`. To start using the API, you need to destruct instantiated DANA client. This client would be a singleton object that you can use across various api and operation.

```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();
    }
}
```

All URIs are relative to *https://api.saas.dana.id*, except if the operation defines another base path (For sandbox it is http://api.sandbox.dana.id).

| Method | HTTP request | Description |
| - | - | - |
| [**accountUnbinding**](WidgetApi.md#accountUnbinding) | **POST** v1.0/registration-account-unbinding.htm | This API is used to reverses the account binding process by revoking the accessToken and refreshToken |
| [**applyOTT**](WidgetApi.md#applyOTT) | **POST** rest/v1.1/qr/apply-ott | This API is used to get one time token that will be used as authorization parameter upon redirecting to DANA |
| [**applyToken**](WidgetApi.md#applyToken) | **POST** v1.0/access-token/b2b2c.htm | This API is used to finalized account binding process by exchanging the authCode into accessToken that can be used as user authorization |
| [**balanceInquiry**](WidgetApi.md#balanceInquiry) | **POST** v1.0/balance-inquiry.htm | This API is used to query user's DANA account balance via merchant |
| [**cancelOrder**](WidgetApi.md#cancelOrder) | **POST** v1.0/debit/cancel.htm | This API is used to cancel the order from merchant's platform to DANA |
| [**queryPayment**](WidgetApi.md#queryPayment) | **POST** rest/v1.1/debit/status | This API is used to inquiry payment status and information from merchant's platform to DANA |
| [**queryUserProfile**](WidgetApi.md#queryUserProfile) | **POST** dana/member/query/queryUserProfile.htm | The API is used to query user profile such as DANA balance (unit in IDR), masked DANA phone number, KYC or OTT (one time token) between merchant server and DANA's server |
| [**refundOrder**](WidgetApi.md#refundOrder) | **POST** v1.0/debit/refund.htm | This API is used to refund the order from merchant's platform to DANA |
| [**widgetPayment**](WidgetApi.md#widgetPayment) | **POST** rest/redirection/v1.0/debit/payment-host-to-host | This API is used to initiate payment from merchant's platform to DANA |


<a name="accountUnbinding"></a>
## `accountUnbinding()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `accountUnbinding` |
| **Payload** | [**AccountUnbindingRequest**](../model/AccountUnbindingRequest.md) |
| **Return Type** | [**AccountUnbindingResponse**](../model/AccountUnbindingResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.AccountUnbindingRequest;
import id.dana.widget.v1.model.AccountUnbindingResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        AccountUnbindingRequest accountUnbindingRequest = new AccountUnbindingRequest();

        try {
            AccountUnbindingResponse response = api.accountUnbinding(accountUnbindingRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="applyOTT"></a>
## `applyOTT()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `applyOTT` |
| **Payload** | [**ApplyOTTRequest**](../model/ApplyOTTRequest.md) |
| **Return Type** | [**ApplyOTTResponse**](../model/ApplyOTTResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.ApplyOTTRequest;
import id.dana.widget.v1.model.ApplyOTTResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        ApplyOTTRequest applyOTTRequest = new ApplyOTTRequest();

        try {
            ApplyOTTResponse response = api.applyOTT(applyOTTRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="applyToken"></a>
## `applyToken()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `applyToken` |
| **Payload** | [**ApplyTokenRequest**](../model/ApplyTokenRequest.md) |
| **Return Type** | [**ApplyTokenResponse**](../model/ApplyTokenResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.ApplyTokenRequest;
import id.dana.widget.v1.model.ApplyTokenResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();

        try {
            ApplyTokenResponse response = api.applyToken(applyTokenRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="balanceInquiry"></a>
## `balanceInquiry()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `balanceInquiry` |
| **Payload** | [**BalanceInquiryRequest**](../model/BalanceInquiryRequest.md) |
| **Return Type** | [**BalanceInquiryResponse**](../model/BalanceInquiryResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.BalanceInquiryRequest;
import id.dana.widget.v1.model.BalanceInquiryResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        BalanceInquiryRequest balanceInquiryRequest = new BalanceInquiryRequest();

        try {
            BalanceInquiryResponse response = api.balanceInquiry(balanceInquiryRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="cancelOrder"></a>
## `cancelOrder()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `cancelOrder` |
| **Payload** | [**CancelOrderRequest**](../model/CancelOrderRequest.md) |
| **Return Type** | [**CancelOrderResponse**](../model/CancelOrderResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.CancelOrderRequest;
import id.dana.widget.v1.model.CancelOrderResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();

        try {
            CancelOrderResponse response = api.cancelOrder(cancelOrderRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="queryPayment"></a>
## `queryPayment()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `queryPayment` |
| **Payload** | [**QueryPaymentRequest**](../model/QueryPaymentRequest.md) |
| **Return Type** | [**QueryPaymentResponse**](../model/QueryPaymentResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.QueryPaymentRequest;
import id.dana.widget.v1.model.QueryPaymentResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        QueryPaymentRequest queryPaymentRequest = new QueryPaymentRequest();

        try {
            QueryPaymentResponse response = api.queryPayment(queryPaymentRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="queryUserProfile"></a>
## `queryUserProfile()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `queryUserProfile` |
| **Payload** | [**QueryUserProfileRequest**](../model/QueryUserProfileRequest.md) |
| **Return Type** | [**QueryUserProfileResponse**](../model/QueryUserProfileResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.QueryUserProfileRequest;
import id.dana.widget.v1.model.QueryUserProfileResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        QueryUserProfileRequest queryUserProfileRequest = new QueryUserProfileRequest();

        try {
            QueryUserProfileResponse response = api.queryUserProfile(queryUserProfileRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="refundOrder"></a>
## `refundOrder()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `refundOrder` |
| **Payload** | [**RefundOrderRequest**](../model/RefundOrderRequest.md) |
| **Return Type** | [**RefundOrderResponse**](../model/RefundOrderResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.RefundOrderRequest;
import id.dana.widget.v1.model.RefundOrderResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        RefundOrderRequest refundOrderRequest = new RefundOrderRequest();

        try {
            RefundOrderResponse response = api.refundOrder(refundOrderRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

<a name="widgetPayment"></a>
## `widgetPayment()` Function

### Function Signature
| Name | Value |
| - | - |
| **Function Name** | `widgetPayment` |
| **Payload** | [**WidgetPaymentRequest**](../model/WidgetPaymentRequest.md) |
| **Return Type** | [**WidgetPaymentResponse**](../model/WidgetPaymentResponse.md) |

### Usage Example
```java
import id.dana.invoker.Dana;

import id.dana.widget.v1.api.WidgetApi;

import id.dana.widget.v1.model.WidgetPaymentRequest;
import id.dana.widget.v1.model.WidgetPaymentResponse;

public class Example {
    public static void main(String[] args) {
        WidgetApi api = Dana.getInstance().getWidgetApi();

        WidgetPaymentRequest widgetPaymentRequest = new WidgetPaymentRequest();

        try {
            WidgetPaymentResponse response = api.widgetPayment(widgetPaymentRequest);
            System.out.println(response);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

