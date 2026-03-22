package id.dana.invoker.model.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DanaException extends RuntimeException {

  /**
   * When set, client-side validation produced structured field/message pairs (possibly aggregated).
   */
  private final List<Map<String, String>> validationContexts;

  public DanaException(String message) {
    super(message);
    this.validationContexts = null;
  }

  public DanaException(String message, Throwable cause) {
    super(message, cause);
    this.validationContexts = null;
  }

  public DanaException(Throwable cause) {
    super(cause);
    this.validationContexts = null;
  }

  public DanaException() {
    super();
    this.validationContexts = null;
  }

  /**
   * Aggregated client validation failures ({@code field} / {@code message} maps), same as joined {@link #getMessage()}.
   */
  public DanaException(List<Map<String, String>> contexts) {
    super(joinContexts(contexts));
    this.validationContexts = new ArrayList<>(contexts);
  }

  public List<Map<String, String>> getValidationContexts() {
    return validationContexts;
  }

  private static String joinContexts(List<Map<String, String>> contexts) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < contexts.size(); i++) {
      if (i > 0) {
        sb.append("; ");
      }
      Map<String, String> c = contexts.get(i);
      sb.append(c.get("field")).append(": ").append(c.get("message"));
    }
    return sb.toString();
  }
}
