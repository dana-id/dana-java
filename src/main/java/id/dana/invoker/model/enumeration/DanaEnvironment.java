package id.dana.invoker.model.enumeration;

import org.apache.commons.lang3.StringUtils;

public enum DanaEnvironment {

  PRODUCTION("https://api.saas.dana.id"), SANDBOX("https://api.sandbox.dana.id");

  private final String url;

  DanaEnvironment(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public static DanaEnvironment getByName(String name) {
    for (DanaEnvironment danaEnvironment : DanaEnvironment.values()) {
      if (StringUtils.equalsIgnoreCase(danaEnvironment.name(), name)) {
        return danaEnvironment;
      }
    }

    return null;
  }

}
