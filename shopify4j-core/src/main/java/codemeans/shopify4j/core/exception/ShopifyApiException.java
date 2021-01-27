package codemeans.shopify4j.core.exception;

/**
 * @author: yuanwq
 * @date: 2021-01-27
 */
public class ShopifyApiException extends Exception {

  public ShopifyApiException() {
  }

  public ShopifyApiException(String message) {
    super(message);
  }

  public ShopifyApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public ShopifyApiException(Throwable cause) {
    super(cause);
  }
}
