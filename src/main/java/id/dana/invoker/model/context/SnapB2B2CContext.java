package id.dana.invoker.model.context;

public class SnapB2B2CContext {

  private SnapB2B2CContextAdditionalInfo additionalInfo;

  public static class SnapB2B2CContextAdditionalInfo {

    private String accessToken;

    private String endUserIpAddress;

    private String deviceId;

    private String latitude;

    private String longitude;

    public String getAccessToken() {
      return accessToken;
    }

    public void setAccessToken(String accessToken) {
      this.accessToken = accessToken;
    }

    public String getEndUserIpAddress() {
      return endUserIpAddress;
    }

    public void setEndUserIpAddress(String endUserIpAddress) {
      this.endUserIpAddress = endUserIpAddress;
    }

    public String getDeviceId() {
      return deviceId;
    }

    public void setDeviceId(String deviceId) {
      this.deviceId = deviceId;
    }

    public String getLatitude() {
      return latitude;
    }

    public void setLatitude(String latitude) {
      this.latitude = latitude;
    }

    public String getLongitude() {
      return longitude;
    }

    public void setLongitude(String longitude) {
      this.longitude = longitude;
    }

  }

  public SnapB2B2CContextAdditionalInfo getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(
      SnapB2B2CContextAdditionalInfo additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

}
