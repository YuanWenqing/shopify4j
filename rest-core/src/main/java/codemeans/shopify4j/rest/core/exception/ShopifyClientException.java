package codemeans.shopify4j.rest.core.exception;

/**
 * fail to invoke request
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyClientException extends RuntimeException {

  public ShopifyClientException() {
  }

  public ShopifyClientException(String message) {
    super(message);
  }

  public ShopifyClientException(String message, Throwable cause) {
    super(message, cause);
  }

  public ShopifyClientException(Throwable cause) {
    super(cause);
  }

  public ShopifyClientException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
