package id.dana.widget.v1.util;

import id.dana.widget.v1.model.Oauth2UrlData;
import id.dana.widget.v1.model.WidgetPaymentResponse;
import id.dana.widget.v1.model.ApplyOTTResponse;
import id.dana.widget.v1.model.Oauth2UrlDataSeamlessData;
import id.dana.invoker.model.DanaConfig;
import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DanaSignatureUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for Widget API operations
 */
public class WidgetUtil {
    /**
     * Enum for OAuth URL modes
     */
    public static class Mode {
        public static final String API = "API";
        public static final String DEEPLINK = "DEEPLINK";
    }

    /**
     * Enum for terminal types
     */
    public static class TerminalType {
        public static final String WEB = "WEB";
        public static final String SYSTEM = "SYSTEM";
    }

    /**
     * Enum for environment values
     */
    public static class Env {
        public static final String PRODUCTION = "production";
        public static final String SANDBOX = "sandbox";
    }

    /**
     * Generate OAuth URL for testing
     *
     * @param data OAuth URL data
     * @return The generated OAuth URL
     * @throws DanaException if there's an error
     */
    public static String generateOauthUrl(Oauth2UrlData data) throws DanaException {
        DanaConfig danaConfig = DanaConfig.getInstance();
        String env = danaConfig.getEnv().toString();
        if (env == null || env.isEmpty()) {
            env = Env.SANDBOX;
        }
        env = env.toLowerCase();
        
        String mode = data.getMode() != null ? data.getMode().toString() : null;
        if (mode == null || mode.isEmpty()) {
            mode = Mode.API;
        }
        mode = mode.toUpperCase();

        String baseUrl;
        if (mode.equals(Mode.DEEPLINK)) {
            if (env.equals(Env.PRODUCTION)) {
                baseUrl = "https://link.dana.id/bindSnap";
            } else {
                baseUrl = "https://m.sandbox.dana.id/n/link/binding";
            }
        } else { // Mode.API
            if (env.equals(Env.PRODUCTION)) {
                baseUrl = "https://m.dana.id/n/ipg/oauth";
            } else {
                baseUrl = "https://m.sandbox.dana.id/n/ipg/oauth";
            }
        }
        
        String partnerId = System.getenv("X_PARTNER_ID");
        if (partnerId == null || partnerId.isEmpty()) {
            throw new DanaException("X_PARTNER_ID is not defined");
        }

        String state = data.getState();
        if (state == null || state.isEmpty()) {
            state = UUID.randomUUID().toString();
        }
        String channelId = generateChannelId();
        
        String scopes;
        if (data.getScopes() != null && !data.getScopes().isEmpty()) {
            scopes = String.join(",", data.getScopes());
        } else {
            if (!env.equals(Env.PRODUCTION)) {
                scopes = "CASHIER,AGREEMENT_PAY,QUERY_BALANCE,DEFAULT_BASIC_PROFILE,MINI_DANA";
            } else {
                scopes = "CASHIER";
            }
        }

        String externalId = data.getExternalId();
        if (externalId == null || externalId.isEmpty()) {
            externalId = UUID.randomUUID().toString();
        }

        String timestamp = generateTimestamp();
        
        Map<String, String> urlParams = new HashMap<>();
        
        String requestId = null;
        
        if (mode.equals(Mode.DEEPLINK)) {
            requestId = UUID.randomUUID().toString();
            
            urlParams.put("partnerId", partnerId);
            urlParams.put("scopes", scopes);
            urlParams.put("terminalType", TerminalType.WEB);
            urlParams.put("externalId", externalId);
            urlParams.put("requestId", requestId);
            urlParams.put("redirectUrl", data.getRedirectUrl());
            urlParams.put("state", state);
        } else { // API mode
            urlParams.put("partnerId", partnerId);
            urlParams.put("scopes", scopes);
            urlParams.put("externalId", externalId);
            urlParams.put("channelId", channelId);
            urlParams.put("redirectUrl", data.getRedirectUrl());
            urlParams.put("timestamp", timestamp);
            urlParams.put("state", state);
            urlParams.put("isSnapBI", "true");
            
            if (data.getMerchantId() != null && !data.getMerchantId().isEmpty()) {
                urlParams.put("merchantId", data.getMerchantId());
            }
            
            if (data.getSubMerchantId() != null && !data.getSubMerchantId().isEmpty()) {
                urlParams.put("subMerchantId", data.getSubMerchantId());
            }
            
            if (data.getLang() != null && !data.getLang().isEmpty()) {
                urlParams.put("lang", data.getLang());
            }
            
            if (data.getAllowRegistration() != null) {
                urlParams.put("allowRegistration", data.getAllowRegistration());
            }
        }

        // Handle seamless data if provided
        Oauth2UrlDataSeamlessData seamlessDataObj = data.getSeamlessData();
        if (seamlessDataObj != null) {
            Map<String, Object> seamlessData = new HashMap<>();
            
            if (seamlessDataObj.getBizScenario() != null) {
                seamlessData.put("bizScenario", seamlessDataObj.getBizScenario());
            }
            if (seamlessDataObj.getMobileNumber() != null) {
                seamlessData.put("mobileNumber", seamlessDataObj.getMobileNumber());
            }
            if (seamlessDataObj.getVerifiedTime() != null) {
                seamlessData.put("verifiedTime", seamlessDataObj.getVerifiedTime());
            }
            if (seamlessDataObj.getExternalUid() != null) {
                seamlessData.put("externalUid", seamlessDataObj.getExternalUid());
            }
            if (seamlessDataObj.getDeviceId() != null) {
                seamlessData.put("deviceId", seamlessDataObj.getDeviceId());
            }
            if (seamlessDataObj.getSkipRegisterConsult() != null) {
                seamlessData.put("skipRegisterConsult", seamlessDataObj.getSkipRegisterConsult());
            }
            
            if (!seamlessData.isEmpty()) {
                if (mode.equals(Mode.DEEPLINK) && requestId != null) {
                    // Convert mobileNumber to mobile if needed
                    if (seamlessData.containsKey("mobileNumber")) {
                        seamlessData.put("mobile", seamlessData.get("mobileNumber"));
                        seamlessData.remove("mobileNumber");
                    }
                    
                    seamlessData.put("externalUid", externalId);
                    seamlessData.put("reqTime", timestamp);
                    seamlessData.put("verifiedTime", "0");
                    seamlessData.put("reqMsgId", requestId);
                }

                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String seamlessDataJson = objectMapper.writeValueAsString(seamlessData);
                    urlParams.put("seamlessData", seamlessDataJson);
                    
                    String seamlessSign = generateSeamlessSign(seamlessData);
                    if (seamlessSign != null && !seamlessSign.isEmpty()) {
                        urlParams.put("seamlessSign", seamlessSign);
                    }
                } catch (Exception e) {
                    throw new DanaException("Error processing seamless data: " + e.getMessage());
                }
            }
        }

        StringBuilder finalUrl = new StringBuilder(baseUrl + "?");
        boolean first = true;
        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
            if (!first) {
                finalUrl.append("&");
            }
            try {
                finalUrl.append(entry.getKey()).append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new DanaException("Error encoding URL parameters: " + e.getMessage());
            }
            first = false;
        }

        return finalUrl.toString();
    }

    /**
     * Generate a channel ID in Jakarta time format (GMT+7): YYYYMMDDHHmmssSSSnnnnnnn
     *
     * @return The formatted channel ID string
     */
    private static String generateChannelId() {
        ZonedDateTime jakartaTime = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
        
        String year = jakartaTime.format(DateTimeFormatter.ofPattern("yyyy"));
        String month = jakartaTime.format(DateTimeFormatter.ofPattern("MM"));
        String day = jakartaTime.format(DateTimeFormatter.ofPattern("dd"));
        String hours = jakartaTime.format(DateTimeFormatter.ofPattern("HH"));
        String minutes = jakartaTime.format(DateTimeFormatter.ofPattern("mm"));
        String seconds = jakartaTime.format(DateTimeFormatter.ofPattern("ss"));
        String milliseconds = jakartaTime.format(DateTimeFormatter.ofPattern("SSS"));
        
        // Generate a random 7-digit number for the nanopart
        SecureRandom random = new SecureRandom();
        String nanopart = String.format("%07d", random.nextInt(10000000));
        
        return year + month + day + hours + minutes + seconds + milliseconds + nanopart;
    }

    /**
     * Generate a timestamp in Jakarta time (GMT+7) with format YYYY-MM-DDTHH:mm:ss+07:00
     *
     * @return formatted timestamp string
     */
    private static String generateTimestamp() {
        ZonedDateTime jakartaTime;
        try {
            jakartaTime = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
        } catch (Exception e) {
            jakartaTime = ZonedDateTime.now(ZoneId.of("UTC")).plusHours(7);
        }
        
        return jakartaTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }

    /**
     * Generate a signature for the seamless data
     * 
     * @param seamlessData The seamless data to sign
     * @return The generated signature or null if signing fails
     */
    private static String generateSeamlessSign(Map<String, Object> seamlessData) {
        if (seamlessData == null || seamlessData.isEmpty()) {
            return "";
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String dataToSign = objectMapper.writeValueAsString(seamlessData);
                        
            return DanaSignatureUtil.signSHA256withRSA(dataToSign);
        } catch (Exception e) {
            System.err.println("Failed to generate seamless sign: " + e.getMessage());
            return null;
        }
    }
    

    /**
     * Combines the webRedirectUrl from WidgetPaymentResponse with the OTT token from ApplyOTTResponse
     * 
     * @param widgetPaymentResponse The widget payment response
     * @param applyOTTResponse The apply OTT response
     * @return The generated payment URL or empty string if inputs are invalid
     */
    public static String generateCompletePaymentUrl(WidgetPaymentResponse widgetPaymentResponse, ApplyOTTResponse applyOTTResponse) {
        if (widgetPaymentResponse == null || applyOTTResponse == null) {
            return "";
        }
        
        String webRedirectUrl = widgetPaymentResponse.getWebRedirectUrl();
        if (webRedirectUrl == null || webRedirectUrl.isEmpty()) {
            return "";
        }
        
        List<?> userResources = applyOTTResponse.getUserResources();
        if (userResources == null || userResources.isEmpty()) {
            return webRedirectUrl;
        }
        
        Object userResource = userResources.get(0);
        String ottValue = "";
        try {
            java.lang.reflect.Method getValue = userResource.getClass().getMethod("getValue");
            Object value = getValue.invoke(userResource);
            if (value != null) {
                ottValue = value.toString();
            }
        } catch (Exception e) {
            return webRedirectUrl;
        }
        
        if (ottValue.isEmpty()) {
            return webRedirectUrl;
        }
        
        return webRedirectUrl + "&ott=" + ottValue;
    }
}
