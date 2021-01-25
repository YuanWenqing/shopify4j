package codemeans.shopify4j.rest.exception;

/**
 * exception in (de)serialization processing
 *
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class SerializingException extends Exception {

  public SerializingException() {
  }

  public SerializingException(String message) {
    super(message);
  }

  public SerializingException(String message, Throwable cause) {
    super(message, cause);
  }

  public SerializingException(Throwable cause) {
    super(cause);
  }

  public SerializingException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
