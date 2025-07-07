package id.dana.invoker.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtil {

  private DateTimeUtil() {

  }

  private static final String TIMEZONE = "Asia/Jakarta"; // GMT+7

  private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

  private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(
      TIMESTAMP_FORMAT);

  public static ZonedDateTime getCurrentDateTime() {
    return ZonedDateTime.now(ZoneId.of(TIMEZONE));
  }

  public static String getFormattedCurrentDateTime() {
    return getCurrentDateTime().format(TIMESTAMP_FORMATTER);
  }

}
