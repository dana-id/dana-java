package id.dana.invoker.model.exception;

public class DanaException extends RuntimeException {

  public DanaException(String message) {
    super(message);
  }

  public DanaException(String message, Throwable cause) {
    super(message, cause);
  }

  public DanaException(Throwable cause) {
    super(cause);
  }

  public DanaException() {
    super();
  }

}
