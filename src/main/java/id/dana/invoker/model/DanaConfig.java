package id.dana.invoker.model;

import id.dana.invoker.model.constant.EnvKey;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.ConfigUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
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
      String keyContent;
      
      if (StringUtils.isNotEmpty(keyPath)) {
        if (keyPath.startsWith("~" + File.separator) || keyPath.equals("~")) {
          keyPath = System.getProperty("user.home") + keyPath.substring(1);
        }
        try {
          keyContent = new String(Files.readAllBytes(Paths.get(keyPath))).trim();
        } catch (IOException e) {
          throw new DanaException("Failed to read key from file: " + keyPath, e);
        }
      } else {
        keyContent = ConfigUtil.getConfig(keyEnvKey, "");
      }
      
      return convertToPkcs8IfNeeded(keyContent);
    }
    
    private static String convertToPkcs8IfNeeded(String keyContent) {
      if (StringUtils.isEmpty(keyContent)) {
        return keyContent;
      }
      
      if (keyContent.contains("-----BEGIN PRIVATE KEY-----")) {
        return keyContent;
      }
      
      if (keyContent.contains("-----BEGIN RSA PRIVATE KEY-----")) {
        try {
          String base64Content = keyContent
              .replace("-----BEGIN RSA PRIVATE KEY-----", "")
              .replace("-----END RSA PRIVATE KEY-----", "")
              .replaceAll("\\s+", "");
          
          byte[] pkcs1Bytes = Base64.getDecoder().decode(base64Content);
          
          byte[] pkcs8Bytes = convertPkcs1ToPkcs8(pkcs1Bytes);
          
          String pkcs8Base64 = Base64.getEncoder().encodeToString(pkcs8Bytes);
          StringBuilder pkcs8Pem = new StringBuilder();
          pkcs8Pem.append("-----BEGIN PRIVATE KEY-----\n");
          
          for (int i = 0; i < pkcs8Base64.length(); i += 64) {
            int end = Math.min(i + 64, pkcs8Base64.length());
            pkcs8Pem.append(pkcs8Base64.substring(i, end)).append("\n");
          }
          
          pkcs8Pem.append("-----END PRIVATE KEY-----");
          return pkcs8Pem.toString();
          
        } catch (Exception e) {
          throw new DanaException("Failed to convert PKCS#1 private key to PKCS#8 format", e);
        }
      }
      
      return keyContent;
    }
    
    private static byte[] convertPkcs1ToPkcs8(byte[] pkcs1Bytes) {
      byte[] pkcs8Header = {
          0x30, (byte) 0x82, 0x00, 0x00,
          0x02, 0x01, 0x00,
          0x30, 0x0d,
          0x06, 0x09, 0x2a, (byte) 0x86, 0x48, (byte) 0x86, (byte) 0xf7, 0x0d, 0x01, 0x01, 0x01,
          0x05, 0x00,
          0x04, (byte) 0x82, 0x00, 0x00
      };
      
      int totalLength = pkcs8Header.length + pkcs1Bytes.length;
      
      pkcs8Header[2] = (byte) ((totalLength - 4) >> 8);
      pkcs8Header[3] = (byte) ((totalLength - 4) & 0xff);
      pkcs8Header[pkcs8Header.length - 2] = (byte) (pkcs1Bytes.length >> 8);
      pkcs8Header[pkcs8Header.length - 1] = (byte) (pkcs1Bytes.length & 0xff);
      
      byte[] pkcs8Bytes = new byte[totalLength];
      System.arraycopy(pkcs8Header, 0, pkcs8Bytes, 0, pkcs8Header.length);
      System.arraycopy(pkcs1Bytes, 0, pkcs8Bytes, pkcs8Header.length, pkcs1Bytes.length);
      
      return pkcs8Bytes;
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
