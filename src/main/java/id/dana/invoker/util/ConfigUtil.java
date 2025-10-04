package id.dana.invoker.util;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class ConfigUtil {

  private static final Dotenv DOTENV;
  private static final Map<String, String> CUSTOM_ENV_VARS = new HashMap<>();

  static {
    Dotenv tempDotenv = null;
    try {
      tempDotenv = Dotenv.configure().ignoreIfMissing().load();
    } catch (Exception e) {
      parseEnvFileManually();
    }
    DOTENV = tempDotenv;
  }

  private ConfigUtil() {

  }

  private static void parseEnvFileManually() {
    try {
      StringBuilder contentBuilder = new StringBuilder();
      File envFile = new File(".env");
      
      try (BufferedReader reader = new BufferedReader(new FileReader(envFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
          contentBuilder.append(line).append("\n");
        }
      }
      
      String envContent = contentBuilder.toString();
      String[] lines = envContent.split("\n");
      
      String currentKey = null;
      StringBuilder currentValue = new StringBuilder();
      boolean inMultilineValue = false;
      
      for (String line : lines) {
        line = line.trim();
        if (line.isEmpty() || line.startsWith("#")) {
          continue;
        }
        
        if (!inMultilineValue && line.contains("=")) {
          if (currentKey != null) {
            CUSTOM_ENV_VARS.put(currentKey, currentValue.toString());
          }
          
          int equalIndex = line.indexOf("=");
          currentKey = line.substring(0, equalIndex);
          String value = line.substring(equalIndex + 1);
          
          if (value.startsWith("'") && !value.endsWith("'")) {
            inMultilineValue = true;
            currentValue = new StringBuilder(value.substring(1));
          } else {
            currentValue = new StringBuilder(value);
            inMultilineValue = false;
          }
        } else if (inMultilineValue) {
          if (line.endsWith("'")) {
            currentValue.append("\n").append(line.substring(0, line.length() - 1));
            inMultilineValue = false;
          } else {
            currentValue.append("\n").append(line);
          }
        }
      }
      
      if (currentKey != null) {
        CUSTOM_ENV_VARS.put(currentKey, currentValue.toString());
      }
    } catch (IOException e) {
    }
  }

  public static String getConfig(String key, String defaultValue) {
    String value = null;
    
    // First try custom parsed values (for multiline support)
    if (CUSTOM_ENV_VARS.containsKey(key)) {
      value = CUSTOM_ENV_VARS.get(key);
    }
    // Then try dotenv if available
    else if (DOTENV != null) {
      value = DOTENV.get(key);
    }
    
    if (StringUtils.isNotEmpty(value)) {
      return removeQuotes(value);
    }
    
    value = System.getenv(key);
    if (StringUtils.isNotEmpty(value)) {
      return removeQuotes(value);
    }
    value = StringUtils.defaultIfEmpty(System.getProperty(key), defaultValue);
    return removeQuotes(value);
  }

  private static String removeQuotes(String value) {
    return value
        .replace("\"", "")
        .replace("'", "");
  }

}
