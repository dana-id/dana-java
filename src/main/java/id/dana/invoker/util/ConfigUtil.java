package id.dana.invoker.util;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.lang3.StringUtils;

public final class ConfigUtil {

  private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

  private ConfigUtil() {

  }

  public static String getConfig(String key, String defaultValue) {
    String value = DOTENV.get(key);
    if (StringUtils.isNotEmpty(value)) {
      return removeQuotes(value);
    }
    value = System.getenv(key);
    if (StringUtils.isNotEmpty(value)) {
      return removeQuotes(value);
    }
    value = System.getProperty(key);
    value = StringUtils.defaultIfEmpty(value, defaultValue);
    return removeQuotes(value);
  }

  private static String removeQuotes(String value) {
    return value
        .replace("\"", "")
        .replace("'", "");
  }

}
