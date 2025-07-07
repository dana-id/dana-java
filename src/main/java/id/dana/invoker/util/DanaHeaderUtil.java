package id.dana.invoker.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.constant.DanaHeader;
import id.dana.invoker.model.context.SnapB2B2CContext;
import id.dana.invoker.model.context.SnapB2B2CContext.SnapB2B2CContextAdditionalInfo;
import id.dana.invoker.model.exception.DanaException;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Request;
import okhttp3.Request.Builder;
import org.apache.commons.lang3.StringUtils;

public final class DanaHeaderUtil {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  private DanaHeaderUtil() {

  }

  public static void populateHeaders(Request request, Builder requestBuilder) {
    String apiType = request.header(DanaHeader.X_API_TYPE);

    if (StringUtils.isNotEmpty(apiType)) {
      switch (apiType) {
        case "SNAP_APPLY_TOKEN":
          populateSnapApplyTokenScenarioHeaders(requestBuilder);
          break;
        case "SNAP_B2B2C":
          populateSnapB2B2CScenarioHeaders(request, requestBuilder);
          break;
        case "SNAP_B2B":
        default:
          populateSnapB2BScenarioHeaders(request, requestBuilder);
          break;
      }
    }

    requestBuilder.removeHeader(DanaHeader.X_API_TYPE);
  }

  public static void populateSnapB2BScenarioHeaders(Request request, Builder requestBuilder) {
    String timestamp = DateTimeUtil.getFormattedCurrentDateTime();
    String signature = DanaSignatureUtil.generateSnapB2BScenarioSignature(request, timestamp);
    String partnerId = DanaConfig.getInstance().getPartnerId();

    requestBuilder.header(DanaHeader.X_TIMESTAMP, timestamp);
    requestBuilder.header(DanaHeader.X_SIGNATURE, signature);
    requestBuilder.header(DanaHeader.ORIGIN, DanaConfig.getInstance().getOrigin());
    requestBuilder.header(DanaHeader.X_PARTNER_ID, partnerId);
    requestBuilder.header(DanaHeader.X_EXTERNAL_ID, UUID.randomUUID().toString());
    requestBuilder.header(DanaHeader.CHANNEL_ID, partnerId + "-SERVER");
  }

  public static void populateSnapApplyTokenScenarioHeaders(Builder requestBuilder) {
    String timestamp = DateTimeUtil.getFormattedCurrentDateTime();
    String partnerId = DanaConfig.getInstance().getPartnerId();
    String signature = DanaSignatureUtil.generateSnapApplyTokenScenarioSignature(timestamp);

    requestBuilder.header(DanaHeader.X_TIMESTAMP, timestamp);
    requestBuilder.header(DanaHeader.X_CLIENT_KEY, partnerId);
    requestBuilder.header(DanaHeader.X_SIGNATURE, signature);
  }

  public static void populateSnapB2B2CScenarioHeaders(Request request, Builder requestBuilder) {
    try {
      String requestBody = RequestUtil.peekRequestBody(request);
      SnapB2B2CContextAdditionalInfo additionalInfo = objectMapper.readValue(requestBody,
          SnapB2B2CContext.class).getAdditionalInfo();

      String accessToken = additionalInfo.getAccessToken();
      String timestamp = DateTimeUtil.getFormattedCurrentDateTime();
      String signature = DanaSignatureUtil.generateSnapB2B2CScenarioSignature(request, requestBody,
          timestamp);
      String partnerId = DanaConfig.getInstance().getPartnerId();

      requestBuilder.header(DanaHeader.AUTHORIZATION_CUSTOMER,
          StringUtils.startsWith(accessToken, "Bearer ") ? accessToken : "Bearer " + accessToken);
      requestBuilder.header(DanaHeader.X_TIMESTAMP, timestamp);
      requestBuilder.header(DanaHeader.X_SIGNATURE, signature);
      requestBuilder.header(DanaHeader.ORIGIN, DanaConfig.getInstance().getOrigin());
      requestBuilder.header(DanaHeader.X_PARTNER_ID, partnerId);
      requestBuilder.header(DanaHeader.X_EXTERNAL_ID, UUID.randomUUID().toString());
      requestBuilder.header(DanaHeader.X_IP_ADDRESS, additionalInfo.getEndUserIpAddress());
      requestBuilder.header(DanaHeader.X_DEVICE_ID, additionalInfo.getDeviceId());
      requestBuilder.header(DanaHeader.X_LATITUDE, additionalInfo.getLatitude());
      requestBuilder.header(DanaHeader.X_LONGITUDE, additionalInfo.getLongitude());
      requestBuilder.header(DanaHeader.CHANNEL_ID, partnerId + "-SERVER");
    } catch (IOException e) {
      throw new DanaException(e);
    }
  }

}
