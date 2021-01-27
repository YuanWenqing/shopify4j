package codemeans.shopify4j.core.exception;

/**
 * fail to invoke request in side of client
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

}
