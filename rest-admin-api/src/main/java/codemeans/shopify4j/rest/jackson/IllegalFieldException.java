package codemeans.shopify4j.rest.jackson;

/**
 * @author: yuanwq
 * @date: 2021-01-14
 */
public class IllegalFieldException extends RuntimeException {

  public IllegalFieldException() {
  }

  public IllegalFieldException(String message) {
    super(message);
  }

  public IllegalFieldException(String field, Object value, String message) {
    super(String.format("field=%s, value=%s, error: %s", field, value, message));
  }

  public IllegalFieldException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalFieldException(Throwable cause) {
    super(cause);
  }

  public IllegalFieldException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
