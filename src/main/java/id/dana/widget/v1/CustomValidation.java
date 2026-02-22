package id.dana.widget.v1;

import id.dana.invoker.model.exception.DanaException;
import id.dana.invoker.util.DateValidation;
import id.dana.widget.v1.model.WidgetPaymentRequest;

/**
 * CustomValidation
 * 
 * This class provides custom validation functions for Widget API requests.
 * Validations are registered and executed via customValidation().
 */
public final class CustomValidation {

  private CustomValidation() {
    // Utility class - prevent instantiation
  }

  /**
   * Perform custom validations on the request based on its type
   *
   * This method checks the request structure to determine the request type and runs
   * the appropriate validations.
   *
   * @param request The request object to validate (can be any type)
   * @throws DanaException if validation fails
   */
  public static void customValidation(Object request) {
    if (request == null) {
      return;
    }

    // Check for WidgetPaymentRequest by checking if it has validUpTo and partnerReferenceNo
    if (request instanceof WidgetPaymentRequest) {
      WidgetPaymentRequest widgetPaymentRequest = (WidgetPaymentRequest) request;
      validateValidUpToWidgetPaymentRequest(widgetPaymentRequest);
      return;
    }

    // Add more type checks here as needed
  }

  /**
   * Validate validUpTo field in WidgetPaymentRequest
   *
   * @param request The request to validate
   * @throws DanaException if validation fails
   */
  private static void validateValidUpToWidgetPaymentRequest(WidgetPaymentRequest request) {
    if (request == null) {
      return;
    }

    if (request.getValidUpTo() != null) {
      try {
        DateValidation.validateValidUpToDate(request.getValidUpTo());
      } catch (IllegalArgumentException e) {
        throw new DanaException("validUpTo validation failed: " + e.getMessage());
      }
    }
  }
}
