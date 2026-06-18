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
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
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
   * Returns the request body string used when computing the SNAP webhook body hash.
   * Minified payloads with standard escaping are returned unchanged; over-escaped nested
   * JSON-in-string fields are normalized before hashing.
   */
  private static String ensureMinifiedJSON(String json) {
    try {
      if (isJSONMinified(json) && !hasTripleEscapedJsonStringField(json)) {
        return json;
      }

      if (isJSONMinified(json)) {
        return processOverEscapedMinifiedJson(json);
      }

      String normalized = json.replace("\\\\\"", "\\\"");
      String processed = processNestedJSONFields(normalized);
      Object mappedJson = objectMapper.readValue(processed, Object.class);
      return objectMapper.writeValueAsString(mappedJson);
    } catch (JsonProcessingException e) {
      log.warn("Failed to process JSON minification, using original: {}", e.getMessage());
      return json;
    }
  }

  private static boolean hasTripleEscapedJsonStringField(String json) {
    return json.contains("\":\"{\\\\\\\"");
  }

  private static String processOverEscapedMinifiedJson(String json) {
    String normalized = json.replace("\\\\\"", "\"");
    return processNestedJSONFields(normalized);
  }

  private static String processNestedJSONFields(String json) {
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
  }

  private static boolean isJSONMinified(String jsonStr) {
    String[] indicators = {": ", ", ", "{ ", "[ ", "\n", "\t", "\r"};
    for (String indicator : indicators) {
      if (jsonStr.contains(indicator)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isValidJson(String jsonStr) {
    try {
      objectMapper.readTree(jsonStr);
      return true;
    } catch (JsonProcessingException e) {
      return false;
    }
  }

  private static String collapseTripleBackslashQuotes(String s) {
    if (!s.contains("\\\\\\\"")) {
      return s;
    }
    String result = s;
    while (result.contains("\\\\\\\"")) {
      result = result.replace("\\\\\\\"", "\\\"");
    }
    return result;
  }

  private static String collapseDoubleBackslashQuotes(String s) {
    if (!s.contains("\\\\\"")) {
      return s;
    }
    return s.replace("\\\\\"", "\"");
  }

  private static String removeColonSpaceBeforeQuotedValue(String s) {
    if (!s.contains(": \\")) {
      return s;
    }
    return s.replaceAll(": (\\\\+\")", ":$1");
  }

  private static String normalizeOverEscapedQuotes(String s) {
    if (s.contains("\\\\\"")) {
      return s.replace("\\\\\"", "\\\"");
    }
    return s;
  }

  private static final Pattern SPACED_JSON_KEY_PATTERN = Pattern.compile(
      "(\\\\*)\"(\\w+(?:\\s+\\w+)+)(\\\\*)\"\\s*:"
  );

  private static String removeSpacesInJsonKeyNames(String s) {
    Matcher matcher = SPACED_JSON_KEY_PATTERN.matcher(s);
    if (!matcher.find()) {
      return s;
    }
    StringBuffer sb = new StringBuffer();
    matcher.reset();
    while (matcher.find()) {
      String leading = matcher.group(1);
      String key = matcher.group(2).replaceAll("\\s+", "");
      String trailing = matcher.group(3);
      matcher.appendReplacement(sb, Matcher.quoteReplacement(leading + "\"" + key + trailing + "\":"));
    }
    matcher.appendTail(sb);
    return sb.toString();
  }

  /**
   * Ordered body strings to hash for SNAP webhook signature verification.
   * DANA may sign exact wire bytes, escape-normalized forms, or minified canonical JSON.
   */
  private static List<String> bodyFormsForSignature(String requestBody) {
    Set<String> seen = new LinkedHashSet<>();
    List<String> forms = new ArrayList<>();
    Consumer<String> add = form -> {
      if (form != null && !form.isEmpty() && seen.add(form)) {
        forms.add(form);
      }
    };

    String spacedKeyRemoved = removeSpacesInJsonKeyNames(requestBody);
    if (!spacedKeyRemoved.equals(requestBody)) {
      add.accept(spacedKeyRemoved);
    }

    String spacedKeyRemovedTripleCollapsed = removeSpacesInJsonKeyNames(collapseTripleBackslashQuotes(requestBody));
    if (!spacedKeyRemovedTripleCollapsed.equals(requestBody)) {
      add.accept(spacedKeyRemovedTripleCollapsed);
    }

    String tripleCollapsed = collapseTripleBackslashQuotes(requestBody);
    if (!tripleCollapsed.equals(requestBody) && isValidJson(tripleCollapsed)) {
      add.accept(tripleCollapsed);
    }

    // Space before triple-backslash-quote (`: \"\"\"`) is not handled by removeColonSpace alone
    // because it only matches `: \"`. Collapse first, then strip spaces.
    String tripleCollapsedSpaced = removeColonSpaceBeforeQuotedValue(tripleCollapsed);
    if (!tripleCollapsedSpaced.equals(tripleCollapsed) && isValidJson(tripleCollapsedSpaced)) {
      add.accept(tripleCollapsedSpaced);
    }

    String collapsed = collapseDoubleBackslashQuotes(requestBody);
    if (!collapsed.equals(requestBody) && isValidJson(collapsed)) {
      add.accept(collapsed);
    }

    String spaced = removeColonSpaceBeforeQuotedValue(requestBody);
    if (!spaced.equals(requestBody) && isValidJson(spaced)) {
      add.accept(spaced);
    }

    collapsed = collapseTripleBackslashQuotes(spaced);
    if (!collapsed.equals(requestBody) && isValidJson(collapsed)) {
      add.accept(collapsed);
    }

    if (isValidJson(requestBody)) {
      add.accept(requestBody);
    }

    String normalized = normalizeOverEscapedQuotes(requestBody);
    if (!normalized.equals(requestBody) && isJSONMinified(normalized) && isValidJson(normalized)) {
      add.accept(normalized);
    }

    add.accept(ensureMinifiedJSON(requestBody));

    if (forms.isEmpty()) {
      throw new DanaException("failed to prepare any signature body form");
    }
    return forms;
  }

  public static boolean verifySnapB2BScenarioSignature(String httpMethod, String relativePathUrl,
      String requestBody, String timestamp, String signatureToVerify) {
    try {
      String method = httpMethod.toUpperCase();
      List<String> bodyForms = bodyFormsForSignature(requestBody);

      String publicKeyBase64 = DanaConfig.getInstance().getEnv() == DanaEnvironment.SANDBOX
          ? SANDBOX_WEBHOOK_PUBLIC_KEY_BASE64
          : DanaConfig.getInstance().getDanaPublicKey();

      for (String body : bodyForms) {
        String bodyHash = DigestUtils.sha256Hex(body);
        String stringToVerify = String.format("%s:%s:%s:%s", method, relativePathUrl, bodyHash, timestamp);
        if (verify(stringToVerify, signatureToVerify, "RSA", "SHA256withRSA", publicKeyBase64)) {
          return true;
        }
      }
      return false;
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
