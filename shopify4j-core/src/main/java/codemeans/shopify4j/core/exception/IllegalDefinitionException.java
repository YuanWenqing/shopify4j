package codemeans.shopify4j.core.exception;

/**
 * @author: yuanwq
 * @date: 2021-01-14
 */
public class IllegalDefinitionException extends RuntimeException {

  public IllegalDefinitionException() {
  }

  public IllegalDefinitionException(String message) {
    super(message);
  }

  public IllegalDefinitionException(String field, Object value, String message) {
    super(String.format("field=%s, value=%s, error: %s", field, value, message));
  }

  public IllegalDefinitionException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalDefinitionException(Throwable cause) {
    super(cause);
  }

  public IllegalDefinitionException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
