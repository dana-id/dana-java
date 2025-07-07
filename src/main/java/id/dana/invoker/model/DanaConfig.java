package id.dana.invoker.model;

import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.ConfigUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang3.Validate;

public class DanaConfig {

  private static volatile DanaConfig instance;
  private final String partnerId;
  private final String privateKey;
  private final String origin;
  private final DanaEnvironment env;

  private DanaConfig(Builder builder) {
    this.partnerId = builder.partnerId;
    this.privateKey = builder.privateKey;
    this.origin = builder.origin;
    this.env = builder.env;
  }

  public static class Builder {

    private String partnerId = ConfigUtil.getConfig(EnvKey.PARTNER_ID, "");
    private String privateKey = loadPrivateKey();
    private String origin = ConfigUtil.getConfig(EnvKey.ORIGIN, "");
    private DanaEnvironment env = DanaEnvironment.getByName(
        ConfigUtil.getConfig(EnvKey.ENV, "SANDBOX"));

    public Builder partnerId(String partnerId) {
      this.partnerId = partnerId;
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

    public Builder env(DanaEnvironment env) {
      this.env = env;
      return this;
    }

    private static String loadPrivateKey() {
      String privateKeyPath = ConfigUtil.getConfig(EnvKey.PRIVATE_KEY_PATH, "");
      if (!privateKeyPath.isEmpty()) {
        if (privateKeyPath.startsWith("~" + File.separator) || privateKeyPath.equals("~")) {
          privateKeyPath = System.getProperty("user.home") + privateKeyPath.substring(1);
        }
        try {
          return cleanKey(new String(Files.readAllBytes(Paths.get(privateKeyPath))).trim());
        } catch (IOException e) {
          throw new DanaException("Failed to read private key from file: " + privateKeyPath, e);
        }
      }
      return cleanKey(ConfigUtil.getConfig(EnvKey.PRIVATE_KEY, ""));
    }

    private static String cleanKey(String key) {
      return key.replaceAll("-----BEGIN [^-]+-----", "").replaceAll("-----END [^-]+-----", "")
          .replace("\\n", "").replaceAll("\\s+", "");
    }

    public DanaConfig build() {
      String errMsgFormat = "Missing required environment variable: %s. Please set %s in your environment or .env file.";
      Validate.notEmpty(partnerId,
          String.format(errMsgFormat, EnvKey.PARTNER_ID, EnvKey.PARTNER_ID));
      Validate.notEmpty(privateKey,
          String.format(errMsgFormat, EnvKey.PRIVATE_KEY, EnvKey.PRIVATE_KEY));
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

  public String getPartnerId() {
    return partnerId;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public String getOrigin() {
    return origin;
  }

  public DanaEnvironment getEnv() {
    return env;
  }

}
