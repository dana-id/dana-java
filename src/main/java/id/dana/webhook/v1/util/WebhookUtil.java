package id.dana.webhook.v1.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.dana.invoker.model.constant.DanaHeader;
import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DanaSignatureUtil;
import id.dana.webhook.v1.model.FinishNotifyRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public final class WebhookUtil {

  private static final ObjectMapper objectMapper;
  
  static {
    objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, false);
  }

  public WebhookUtil() {

  }

  /**
   * Parse Webhook - Webhook
   * Verifies the webhook signature and deserialize the JSON payload
   * @param httpMethod      HTTP method (e.g., "POST")
   * @param relativePathUrl Relative path URL (e.g., "/v1.0/debit/notify")
   * @param headers         Map of HTTP headers
   * @param body            Raw JSON body of the webhook request
   * @return CancelOrderResponse
   *
   * @see <a href="https://dashboard.dana.id/api-docs/read/123">Finish Notify - Webhook Documentation</a>
   */
  public static FinishNotifyRequest parseWebhook(String httpMethod, String relativePathUrl,
      Map<String, String> headers, String body) {
    Map<String, String> normalizedHeaders = new HashMap<>();
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      normalizedHeaders.put(entry.getKey().toUpperCase(), entry.getValue());
    }
    
    String timestamp = normalizedHeaders.get("X-TIMESTAMP");
    String signatureToVerify = normalizedHeaders.get("X-SIGNATURE");
    
    if (StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(signatureToVerify)) {
      throw new DanaException(String.format("Missing %s or %s headers", DanaHeader.X_SIGNATURE,
          DanaHeader.X_TIMESTAMP));
    }

    if (!DanaSignatureUtil.verifySnapB2BScenarioSignature(httpMethod, relativePathUrl, body,
        timestamp, signatureToVerify)) {
      throw new DanaException("Signature verification failed");
    }

    try {
      return objectMapper.readValue(body, FinishNotifyRequest.class);
    } catch (IOException e) {
      throw new DanaException("Invalid JSON in request body");
    }
  }

}