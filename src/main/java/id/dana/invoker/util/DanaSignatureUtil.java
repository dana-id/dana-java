package id.dana.invoker.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.dana.invoker.model.DanaConfig;
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
import okhttp3.Request;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DanaSignatureUtil {

  private static final Logger log = LoggerFactory.getLogger(DanaSignatureUtil.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

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

  public static boolean verifySnapB2BScenarioSignature(String httpMethod, String relativePathUrl,
      String requestBody, String timestamp, String signatureToVerify) {
    try {
      Object mappedRequestBody = objectMapper.readValue(requestBody, Object.class);
      requestBody = objectMapper.writeValueAsString(mappedRequestBody);
      String stringToVerify = String.format("%s:%s:%s:%s", httpMethod, relativePathUrl,
          DigestUtils.sha256Hex(requestBody), timestamp);

      System.out.println("String to verify: " + stringToVerify);
      System.out.println("Signature to verify: " + signatureToVerify);
      return verifySHA256withRSA(stringToVerify, signatureToVerify);
    } catch (JsonProcessingException | NoSuchAlgorithmException | InvalidKeySpecException |
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
    byte[] keyBytes = Base64.getDecoder().decode(DanaConfig.getInstance().getDanaPublicKey());

    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
    PublicKey publicKey = keyFactory.generatePublic(keySpec);

    Signature signature = Signature.getInstance(signatureAlgorithm);
    signature.initVerify(publicKey);
    signature.update(stringToVerify.getBytes(StandardCharsets.UTF_8));

    return signature.verify(Base64.getDecoder().decode(signatureToVerify));
  }

}
