# dana-java

The official DANA Java SDK provides a simple and convenient way to call DANA's REST API in applications written in Java.

## ⚠️ **Run This First – Save Days of Debugging**

Before writing any integration code, **run our automated test suite.** It takes **under 2 minutes** and shows you how the full flow works — **with your own credentials.**

Here is the link: https://github.com/dana-id/uat-script.

### Why This Matters

- 🧪 Validates your setup instantly
- 👀 **See exactly how each scenario flows**
- 🧾 Gives us logs to help you faster
- 🚫 Skipping this = guaranteed delays 


### What It Does

✅ Runs full scenario checks for DANA Sandbox

✅ Installs and executes automatically

✅ Shows real-time results in your terminal

✅ Runs in a safe, simulation-only environment

> Don’t fly blind. Run the test first. See the flow. Build with confidence.

  
  .  

  .


# Getting Started

## Installation

### Requirements

- Java 1.8 or later.

### Install with Maven

To install the SDK to your local Maven repository, simply execute:

```shell
mvn install
```

After the SDK is installed, you can use it in your Maven project by adding the following to your *pom.xml*:

```xml
<dependency>
    <groupId>id.dana</groupId>
    <artifactId>dana-java</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>

```

## Authorization

The SDK must be instantiated using your private key. Please check the [DANA API Docs](https://dashboard.dana.id/api-docs/read/45) for a guide on generating one.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;

import id.dana.util.ConfigUtil;

public class Example {
    public static void main(String[] args) {
        DanaConfig.Builder danaConfigBuilder = new DanaConfig.Builder();
        danaConfigBuilder
            .partnerId(ConfigUtil.getConfig("X_PARTNER_ID", ""))
            .privateKey(ConfigUtil.getConfig("PRIVATE_KEY", ""))
            .origin(ConfigUtil.getConfig("ORIGIN", ""));

        DanaConfig.getInstance(danaConfigBuilder);

        Dana danaClient = Dana.getInstance();
    }
}
```

### Sandbox Environment

By default, the SDK will use the DANA production URL (`https://api.saas.dana.id`) to make API requests.<br/>
If you need to override the environment, you can pass in `env` to `DanaConfigBuilder`.

```java
import id.dana.invoker.Dana;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;

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

        Dana danaClient = Dana.getInstance();
    }
}
```

## Documentation

Find detailed API information and examples for each of our products by clicking the links below:
* [PaymentGatewayApi](docs/paymentgateway/v1/api/PaymentGatewayApi.md)
* [WidgetApi](docs/widget/v1/api/WidgetApi.md)
* [MerchantManagementApi](docs/merchantmanagement/v1/api/MerchantManagementApi.md)

## Further Reading

* [DANA API Reference](https://dashboard.dana.id/api-docs)