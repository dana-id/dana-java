# dana-java

The official DANA Java SDK provides a simple and convenient way to call DANA's REST API in applications written in Java.

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
    <version>1.1.0</version>
</dependency>
```

## Environment Variables
Before using the SDK, please make sure to set the following environment variables (In .env):

- `DANA_ENV`
- `MERCHANT_ID`
- `X_PARTNER_ID`
- `PRIVATE_KEY`
- `PRIVATE_KEY_PATH`
- `ORIGIN`
- `DANA_PUBLIC_KEY`
- `DANA_PUBLIC_KEY_PATH`
- `CLIENT_SECRET`

Notes:
- By default, the SDK will use the [DANA Production URL](https://api.saas.dana.id) to make API requests. You can set `DANA_ENV` to either `PRODUCTION` or `SANDBOX` to override the environment.
- `PRIVATE_KEY_PATH` and `DANA_PUBLIC_KEY_PATH` are paths to the private key and public key files, respectively. You can set either `PRIVATE_KEY` or `PRIVATE_KEY_PATH`. If you set both, `PRIVATE_KEY` will be ignored. The same goes for `DANA_PUBLIC_KEY` and `DANA_PUBLIC_KEY_PATH`.
- Please check the [DANA API Docs](https://dashboard.dana.id/api-docs/read/45) for a guide on generating the keys

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

Find detailed API information and examples for each of our products by clicking the links below:
* [PaymentGatewayApi](docs/paymentgateway/v1/api/PaymentGatewayApi.md)
* [WidgetApi](docs/widget/v1/api/WidgetApi.md)
* [DisbursementApi](docs/disbursement/v1/api/DisbursementApi.md)
* [MerchantManagementApi](docs/merchantmanagement/v1/api/MerchantManagementApi.md)

## Further Reading

* [DANA API Reference](https://dashboard.dana.id/api-docs)