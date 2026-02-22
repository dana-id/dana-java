package id.dana.invoker.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * DateValidation
 * 
 * Utility class for validating date fields, specifically validUpTo dates.
 */
public final class DateValidation {

  private DateValidation() {
    // Utility class - prevent instantiation
  }

  /**
   * Validate that a date string is not more than 30 minutes in the future (sandbox only)
   *
   * This method checks the DANA_ENV or ENV environment variable and only validates in sandbox environment
   *
   * @param dateStr The date string to validate in RFC3339 format (e.g., "2024-01-01T12:00:00+07:00")
   * @throws IllegalArgumentException if the date is invalid or exceeds 30 minutes in the future
   */
  public static void validateValidUpToDate(String dateStr) {
    // Only validate in sandbox environment
    String env = System.getenv("DANA_ENV");
    if (env == null || env.isEmpty()) {
      env = System.getenv("ENV");
    }
    if (env == null || env.isEmpty() || "sandbox".equalsIgnoreCase(env)) {
      if (dateStr == null) {
        return;
      }
      
      try {
        // Parse the input date
        ZonedDateTime inputDate = ZonedDateTime.parse(dateStr, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        
        // Get current time (in UTC internally, but we compare with timezone-aware dates)
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        
        // Convert input date to UTC for comparison
        ZonedDateTime inputDateUtc = inputDate.withZoneSameInstant(ZoneId.of("UTC"));
        
        // Maximum allowed date (current time + 30 minutes)
        ZonedDateTime maxDate = now.plusMinutes(30);
        
        // Check if the input date exceeds the maximum allowed date
        if (inputDateUtc.isAfter(maxDate)) {
          throw new IllegalArgumentException("validUpTo date cannot be more than 30 minutes in the future");
        }
      } catch (DateTimeParseException e) {
        throw new IllegalArgumentException("invalid date format for validUpTo. Expected format: YYYY-MM-DDTHH:mm:ss+07:00", e);
      }
    }
  }
}
