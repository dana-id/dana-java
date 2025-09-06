package id.dana.webhook.v1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.dana.invoker.model.constant.DanaHeader;
import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DanaSignatureUtil;
import id.dana.webhook.v1.model.FinishNotifyRequest;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public final class WebhookUtil {

  private static final ObjectMapper objectMapper = new ObjectMapper();

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
    String timestamp = headers.getOrDefault(DanaHeader.X_TIMESTAMP,
        headers.get(DanaHeader.X_TIMESTAMP.toLowerCase()));
    String signatureToVerify = headers.getOrDefault(DanaHeader.X_SIGNATURE,
        headers.get(DanaHeader.X_SIGNATURE.toLowerCase()));
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