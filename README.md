# dana-java

The official DANA Java SDK provides a simple and convenient way to call DANA's REST API in applications written in Java (based on https://dashboard.dana.id/api-docs-v2/).

## ⚠️ Run This First - Save Days of Debugging

Before writing any integration code, **run our automated test suite**. It takes **under 2 minutes** and shows you how the full flow works — **with your own credentials**.

Here is the link: https://github.com/dana-id/uat-script.

### Why This Matters

- 🧪 Validates your setup instantly
- 👀 **See exactly how each scenario flows**
- 🧾 Gives us logs to help you faster
- 🚫 Skipping this = guaranteed delays 


### What It Does

✅ Runs full scenario checks for DANA Sandbox

✅ Installs and executes automatically

✅ Shows real-time results in your terminal

✅ Runs in a safe, simulation-only environment

> Don't fly blind. Run the test first. See the flow. Build with confidence.

  
  .  

  .


# Getting Started

## Installation

### Requirements

- JDK 1.8 or later.

### Install with Maven

To install the SDK to your Maven project, simply add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>id.dana</groupId>
    <artifactId>dana-java</artifactId>
    <version>1.1.2</version>
</dependency>
```

## Environment Variables

Before using the SDK, please make sure to set the following environment variables (In .env):

| Name                   | Description                                                                                   | Example Value                                                                   |
| ---------------------- | ---------------------------------------------------------------------------------------       | ------------------------------------------------------------------------------- |
| `ENV` or `DANA_ENV`    | Defines which environment the SDK will use. Possible values: `SANDBOX` or `PRODUCTION`.       | `SANDBOX`                                                                       |
| `X_PARTNER_ID`         | Unique identifier for partner, provided by DANA, also known as `clientId`.                    | 1970010100000000000000                                                          |
| `PRIVATE_KEY`          | Your private key string.                                                                      | `-----BEGIN PRIVATE KEY-----MIIBVgIBADANBg...LsvTqw==-----END PRIVATE KEY-----` |
| `PRIVATE_KEY_PATH`     | Path to your private key file. If both are set, `PRIVATE_KEY_PATH` is used.                   | /path/to/your_private_key.pem                                                   |
| `DANA_PUBLIC_KEY`      | DANA public key string for parsing webhook.                                                   | `-----BEGIN PUBLIC KEY-----MIIBIjANBgkq...Do/QIDAQAB-----END PUBLIC KEY-----`   |
| `DANA_PUBLIC_KEY_PATH` | Path to DANA public key file for parsing webhook. If both set, `DANA_PUBLIC_KEY_PATH is used. | /path/to/dana_public_key.pem                                                    |
| `ORIGIN`               | Origin domain.                                                                                | https://yourdomain.com                                                          |
| `CLIENT_SECRET`        | Assigned client secret during registration. Must be set for DisbursementApi                   | your_client_secret                                                              |

You can see these variables in .env.example, fill it, and change the file name to .env (remove the .example extension)

## Usage

By default, the SDK will read the configuration from environment variables.

```java
import id.dana.invoker.Dana;

public class Example {
    public static void main(String[] args) {
        Dana danaClient = Dana.getInstance();
    }
}
```

Alternatively, you can also set the configuration programmatically by using `DanaConfig.Builder` to build the configuration and then passing it to `DanaConfig.getInstance()` before calling `Dana.getInstance()`.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId("YOUR_PARTNER_ID")
            .privateKey("YOUR_PRIVATE_KEY")
            .origin("YOUR_ORIGIN");
            .env("SANDBOX"); // or "PRODUCTION"

        DanaConfig.getInstance(danaConfigBuilder);

        Dana danaClient = Dana.getInstance();
    }
}
```

## Documentation

### API

Find detailed API information and usage examples for each of our products by clicking the links below:

* [PaymentGatewayApi](docs/paymentgateway/v1/api/PaymentGatewayApi.md)
* [WidgetApi](docs/widget/v1/api/WidgetApi.md)
* [DisbursementApi](docs/disbursement/v1/api/DisbursementApi.md)
* [MerchantManagementApi](docs/merchantmanagement/v1/api/MerchantManagementApi.md)

### Util

Find detailed util information and usage examples by clicking the links below:

* [WebhookUtil](docs/webhook/v1/util/WebhookUtil.md)

## Further Reading

* [DANA API Reference](https://dashboard.dana.id/api-docs-v2/)