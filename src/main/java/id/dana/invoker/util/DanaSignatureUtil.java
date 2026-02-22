package id.dana.invoker.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.enumeration.DanaEnvironment;
import id.dana.invoker.model.exception.DanaException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Request;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DanaSignatureUtil {

  private static final Logger log = LoggerFactory.getLogger(DanaSignatureUtil.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

  /** Sandbox gateway public key (X.509 base64) for webhook verification when env is sandbox. */
  private static final String SANDBOX_WEBHOOK_PUBLIC_KEY_BASE64 =
      "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnaKVGRbin4Wh4KN35OPh"
          + "ytJBjYTz7QZKSZjmHfiHxFmulfT87rta+IvGJ0rCBgg+1EtKk1hX8G5gPGJs1htJ"
          + "5jHa3/jCk9l+luzjnuT9UVlwJahvzmFw+IoDoM7hIPjsLtnIe04SgYo0tZBpEmkQ"
          + "vUGhmHPqYnUGSSMIpDLJDvbyr8gtwluja1SbRphgDCoYVXq+uUJ5HzPS049aaxTS"
          + "nfXh/qXuDoB9EzCrgppLDS2ubmk21+dr7WaO/3RFjnwx5ouv6w+iC1XOJKar3CTk"
          + "X6JV1OSST1C9sbPGzMHZ8AGB51BM0mok7davD/5irUk+f0C25OgzkwtxAt80dkDo"
          + "/QIDAQAB";

  private DanaSignatureUtil() {

  }

  public static String generateSnapB2BScenarioSignature(Request request, String timestamp) {
    String payload = RequestUtil.peekRequestBody(request);
    String stringToSign = String.format("%s:%s:%s:%s", request.method(),
        request.url().encodedPath(), DigestUtils.sha256Hex(payload), timestamp);
    try {
      return signSHA256withRSA(stringToSign);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException |
             SignatureException e) {
      log.error("Failed to generate SNAP B2B scenario signature: {}", e.getMessage());
      return null;
    } catch (Exception e) {
      log.error("Unknown error when generating SNAP B2B scenario signature: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static String generateSnapApplyTokenScenarioSignature(String timestamp) {
    String stringToSign = String.format("%s|%s", DanaConfig.getInstance().getPartnerId(),
        timestamp);
    try {
      return signSHA256withRSA(stringToSign);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException |
             SignatureException e) {
      log.error("Failed to generate apply token signature for SNAP: {}", e.getMessage());
      return null;
    } catch (Exception e) {
      log.error("Unknown error when generating apply token signature for SNAP: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static String generateSnapB2B2CScenarioSignature(Request request, String payload,
      String timestamp) {
    String stringToSign = String.format("%s:%s:%s:%s", request.method(),
        request.url().encodedPath(), DigestUtils.sha256Hex(payload), timestamp);
    try {
      return signSHA256withRSA(stringToSign);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException |
             SignatureException e) {
      log.error("Failed to generate SNAP B2B2C scenario signature: {}", e.getMessage());
      return null;
    } catch (Exception e) {
      log.error("Unknown error when generating SNAP B2B2C scenario signature: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static String generateOpenApiScenarioSignature(String requestBody) {
    try {
      return signSHA256withRSA(requestBody);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException |
             SignatureException e) {
      log.error("Failed to generate OpenAPI scenario signature: {}", e.getMessage());
      return null;
    } catch (Exception e) {
      log.error("Unknown error when generating OpenAPI scenario signature: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static String signSHA256withRSA(String stringToSign)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    return signSHA256withRSA(stringToSign, null);
  }

  public static String signSHA256withRSA(String stringToSign, String privateKey)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    return Base64.getEncoder().encodeToString(sign(stringToSign, "RSA", "SHA256withRSA", privateKey));
  }

  public static byte[] sign(String stringToSign, String keyAlgorithm, String signatureAlgorithm)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    return sign(stringToSign, keyAlgorithm, signatureAlgorithm, null);
  }

  public static byte[] sign(String stringToSign, String keyAlgorithm, String signatureAlgorithm, String privateKey)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    String keyToUse = privateKey != null ? privateKey : DanaConfig.getInstance().getPrivateKey();
    byte[] keyBytes = Base64.getDecoder().decode(keyToUse);

    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
    PrivateKey pk = keyFactory.generatePrivate(keySpec);

    Signature signature = Signature.getInstance(signatureAlgorithm);
    signature.initSign(pk);
    signature.update(stringToSign.getBytes(StandardCharsets.UTF_8));

    return signature.sign();
  }

  /**
   * Handles nested JSON fields with proper quote escaping
   */
  private static String ensureMinifiedJSON(String json) {
    try {
      json = json.replace("\\\\\"", "\"");
      
      boolean isMinified = !json.contains(": ") && !json.contains(",\n") && !json.contains("{\n");
      
      if (!isMinified) {
        Object mappedJson = objectMapper.readValue(json, Object.class);
        json = objectMapper.writeValueAsString(mappedJson);
      }
      
      Pattern pattern = Pattern.compile("\"(\\w+)\":\"(\\{.*?\\})\"");
      Matcher matcher = pattern.matcher(json);
      
      StringBuffer result = new StringBuffer();
      while (matcher.find()) {
        String fieldName = matcher.group(1);
        String jsonValue = matcher.group(2);
        
        String escapedValue = jsonValue.replace("\"", "\\\"");
        matcher.appendReplacement(result, "\"" + fieldName + "\":\"" + escapedValue + "\"");
      }
      matcher.appendTail(result);
      
      return result.toString();
    } catch (JsonProcessingException e) {
      log.warn("Failed to process JSON minification, using original: {}", e.getMessage());
      return json;
    }
  }

  public static boolean verifySnapB2BScenarioSignature(String httpMethod, String relativePathUrl,
      String requestBody, String timestamp, String signatureToVerify) {
    try {
      String processedBody = ensureMinifiedJSON(requestBody);
      String bodyHash = DigestUtils.sha256Hex(processedBody);
      String stringToVerify = String.format("%s:%s:%s:%s", httpMethod, relativePathUrl, bodyHash, timestamp);

      String publicKeyBase64 = DanaConfig.getInstance().getEnv() == DanaEnvironment.SANDBOX
          ? SANDBOX_WEBHOOK_PUBLIC_KEY_BASE64
          : DanaConfig.getInstance().getDanaPublicKey();
      return verify(stringToVerify, signatureToVerify, "RSA", "SHA256withRSA", publicKeyBase64);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException |
             InvalidKeyException | SignatureException e) {
      log.error("Failed to verify SNAP B2B scenario signature: {}", e.getMessage());
      return false;
    } catch (Exception e) {
      log.error("Unknown error when verifying SNAP B2B scenario signature: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static boolean verifySHA256withRSA(String stringToVerify, String signatureToVerify)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    return verify(stringToVerify, signatureToVerify, "RSA", "SHA256withRSA");
  }

  public static boolean verify(String stringToVerify, String signatureToVerify, String keyAlgorithm,
      String signatureAlgorithm)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    return verify(stringToVerify, signatureToVerify, keyAlgorithm, signatureAlgorithm,
        DanaConfig.getInstance().getDanaPublicKey());
  }

  private static boolean verify(String stringToVerify, String signatureToVerify, String keyAlgorithm,
      String signatureAlgorithm, String publicKeyBase64)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    byte[] keyBytes = Base64.getDecoder().decode(publicKeyBase64);

    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
    PublicKey publicKey = keyFactory.generatePublic(keySpec);

    Signature signature = Signature.getInstance(signatureAlgorithm);
    signature.initVerify(publicKey);
    signature.update(stringToVerify.getBytes(StandardCharsets.UTF_8));

    return signature.verify(Base64.getDecoder().decode(signatureToVerify));
  }

}
