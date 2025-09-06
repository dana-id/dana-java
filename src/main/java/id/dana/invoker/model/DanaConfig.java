package id.dana.invoker.model;

import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.ConfigUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class DanaConfig {

  private static volatile DanaConfig instance;
  private final DanaEnvironment env;
  private final String partnerId;
  private final String clientSecret;
  private final String danaPublicKey;
  private final String privateKey;
  private final String origin;

  private DanaConfig(Builder builder) {
    this.env = builder.env;
    this.partnerId = builder.partnerId;
    this.clientSecret = builder.clientSecret;
    this.danaPublicKey = cleanKey(builder.danaPublicKey);
    this.privateKey = cleanKey(builder.privateKey);
    this.origin = builder.origin;
  }

  public static class Builder {

    private DanaEnvironment env = DanaEnvironment.getByName(
        ConfigUtil.getConfig(EnvKey.DANA_ENV, ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX")));
    private String partnerId = ConfigUtil.getConfig(EnvKey.PARTNER_ID, "");
    private String clientSecret = ConfigUtil.getConfig(EnvKey.CLIENT_SECRET, "");
    private String danaPublicKey = loadKey(EnvKey.DANA_PUBLIC_KEY_PATH, EnvKey.DANA_PUBLIC_KEY);
    private String privateKey = loadKey(EnvKey.PRIVATE_KEY_PATH, EnvKey.PRIVATE_KEY);
    private String origin = ConfigUtil.getConfig(EnvKey.ORIGIN, "");

    public Builder env(DanaEnvironment env) {
      this.env = env;
      return this;
    }

    public Builder partnerId(String partnerId) {
      this.partnerId = partnerId;
      return this;
    }

    public Builder clientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    public Builder danaPublicKey(String danaPublicKey) {
      this.danaPublicKey = danaPublicKey;
      return this;
    }

    public Builder privateKey(String privateKey) {
      this.privateKey = privateKey;
      return this;
    }

    public Builder origin(String origin) {
      this.origin = origin;
      return this;
    }

    private static String loadKey(String keyPathEnvKey, String keyEnvKey) {
      String keyPath = ConfigUtil.getConfig(keyPathEnvKey, "");
      if (StringUtils.isNotEmpty(keyPath)) {
        if (keyPath.startsWith("~" + File.separator) || keyPath.equals("~")) {
          keyPath = System.getProperty("user.home") + keyPath.substring(1);
        }
        try {
          return new String(Files.readAllBytes(Paths.get(keyPath))).trim();
        } catch (IOException e) {
          throw new DanaException("Failed to read key from file: " + keyPath, e);
        }
      }
      return ConfigUtil.getConfig(keyEnvKey, "");
    }

    public DanaConfig build() {
      String errMsgFormat = "Missing required environment variable: %s. Please set %s in your environment or .env file.";
      Validate.notEmpty(this.partnerId,
          String.format(errMsgFormat, EnvKey.PARTNER_ID, EnvKey.PARTNER_ID));
      Validate.notEmpty(this.clientSecret,
          String.format(errMsgFormat, EnvKey.CLIENT_SECRET, EnvKey.CLIENT_SECRET));
      Validate.notEmpty(this.danaPublicKey,
          String.format(errMsgFormat, EnvKey.DANA_PUBLIC_KEY, EnvKey.DANA_PUBLIC_KEY));
      Validate.notEmpty(this.privateKey,
          String.format(errMsgFormat, EnvKey.PRIVATE_KEY, EnvKey.PRIVATE_KEY));
      Validate.notEmpty(this.origin, String.format(errMsgFormat, EnvKey.ORIGIN, EnvKey.ORIGIN));
      return new DanaConfig(this);
    }

  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static DanaConfig getInstance() {
    return getInstance(null);
  }

  public static DanaConfig getInstance(Builder builder) {
    if (instance != null) {
      return instance;
    }
    synchronized (DanaConfig.class) {
      if (instance == null) {
        if (builder == null) {
          builder = newBuilder();
        }
        instance = builder.build();
      }
    }
    return instance;
  }

  public DanaEnvironment getEnv() {
    return env;
  }

  public String getPartnerId() {
    return partnerId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public String getDanaPublicKey() {
    return danaPublicKey;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public String getOrigin() {
    return origin;
  }

  private static String cleanKey(String key) {
    return key
        .replaceAll("-----BEGIN [^-]+-----", "")
        .replaceAll("-----END [^-]+-----", "")
        .replace("\\n", "")
        .replaceAll("\\s+", "");
  }

}
