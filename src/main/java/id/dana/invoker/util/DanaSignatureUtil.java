package id.dana.invoker.util;

import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.exception.DanaException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import okhttp3.Request;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DanaSignatureUtil {

  private static final Logger log = LoggerFactory.getLogger(DanaSignatureUtil.class);

  private DanaSignatureUtil() {

  }

  public static String generateSnapB2BScenarioSignature(Request request, String timestamp) {
    String payload = RequestUtil.peekRequestBody(request);
    String stringToSign = String.format("%s:%s:%s:%s", request.method(),
        request.url().encodedPath(), DigestUtils.sha256Hex(payload), timestamp);
    try {
      return signSHA256withRSA(stringToSign);
    } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException |
             InvalidKeySpecException e) {
      log.error("Failed to generate SNAP B2B scenario signature: {}", e.getMessage());
      return null;
    } catch (Exception e) {
      log.error("Unknown error when generating SNAP B2B scenario signature: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static String generateSnapApplyTokenScenarioSignature(String timestamp) {
    try {
      String stringToSign = String.format("%s|%s", DanaConfig.getInstance().getPartnerId(),
          timestamp);
      return signSHA256withRSA(stringToSign);
    } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException |
             InvalidKeySpecException e) {
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
    } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException |
             InvalidKeySpecException e) {
      log.error("Failed to generate SNAP B2B2C scenario signature: {}", e.getMessage());
      return null;
    } catch (Exception e) {
      log.error("Unknown error when generating SNAP B2B2C scenario signature: {}", e.getMessage());
      throw new DanaException(e);
    }
  }

  public static byte[] sign(String stringToSign, String keyAlgo, String signAlgo)
      throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
    byte[] keyBytes = Base64.getDecoder().decode(DanaConfig.getInstance().getPrivateKey());

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance(keyAlgo);
    PrivateKey privateKey = kf.generatePrivate(spec);

    Signature signature = Signature.getInstance(signAlgo);
    signature.initSign(privateKey);
    signature.update(stringToSign.getBytes(StandardCharsets.UTF_8));

    return signature.sign();
  }

  public static String signSHA256withRSA(String stringToSign)
      throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
    return Base64.getEncoder().encodeToString(sign(stringToSign, "RSA", "SHA256withRSA"));
  }

  public static String generateOpenApiScenarioSignature(String requestBody, String privateKey)
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
    return signSHA256withRSA(requestBody);
  }
}
