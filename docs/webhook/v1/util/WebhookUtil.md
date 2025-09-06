# WebhookUtil

Some APIs provided by DANA include a **Finish Notify** feature, which delivers webhook notifications to your registered endpoint regarding payment status and related information. To ensure the authenticity of these webhook requests, it is essential to verify their signatures.

The `WebhookUtil` assists you in verifying the webhook signature to confirm the request originates from DANA and in parsing the webhook payload into a `FinishNotifyRequest` object, thereby facilitating the secure and reliable handling of notifications within your application.

## `parseWebhook()` Function

### Function Signature
| Name              | Value                                                      |
| ----------------- | ---------------------------------------------------------- |
| **Function Name** | `parseWebhook`                                             |
| **Payload**       | See the [Payload Details](#payload-details) section below. |
| **Return Type**   | [**FinishNotifyRequest**](../model/FinishNotifyRequest.md) |

### Payload Details

| Name              | Type                  | Description                                     |
| ----------------- | --------------------- | ----------------------------------------------- |
| `httpMethod`      | `String`              | HTTP method (e.g., `POST`).                     |
| `relativePathUrl` | `String`              | Relative path URL (e.g., `/v1.0/debit/notify`). |
| `headers`         | `Map<String, String>` | Map of HTTP headers.                            |
| `body`            | `String`              | Raw JSON body of the webhook request.           |

### Usage Example
```java
import id.dana.invoker.model.DanaConfig;

import id.dana.webhook.v1.util.WebhookUtil;

import id.dana.webhook.v1.model.FinishNotifyRequest;

public class Example {
    public static void main(String[] args) {
        DanaConfig.getInstance(); // Ensure DanaConfig is initialized

        String relativePathUrl = "/v1.0/debit/notify"; // Replace with actual relative path URL
        String signature = "Signature from DANA"; // Replace with actual signature from the webhook request
        String timestamp = "Timestamp from DANA"; // Replace with actual timestamp from the webhook request
        String body = "{}"; // Replace with actual raw JSON body of the webhook request

        Map<String, String> headers = new HashMap<>();
        headers.put(DanaHeader.X_SIGNATURE, signature);
        headers.put(DanaHeader.X_TIMESTAMP, timestamp);

        try {
            FinishNotifyRequest finishNotifyRequest = WebhookUtil.parseWebhook("POST", relativePathUrl, headers, body);
            System.out.println(finishNotifyRequest);
        } catch (DanaException e) {
            e.printStackTrace();
        }
    }
}
```

## Webhook Response

Upon receiving a webhook request from DANA, your registered endpoint is required to return a confirmation indicating whether the payment status has been accepted or not.

This confirmation serves as the response to the webhook request. You may utilize the provided [**FinishNotifyResponse**](../model/FinishNotifyResponse.md) class to construct and return the appropriate response to DANA.