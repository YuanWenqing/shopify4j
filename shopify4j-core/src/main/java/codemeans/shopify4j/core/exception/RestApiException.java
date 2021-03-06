package codemeans.shopify4j.core.exception;

/**
 * shopify rest api error
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class RestApiException extends ShopifyApiException {

  public RestApiException() {
  }

  public RestApiException(String message) {
    super(message);
  }

  public RestApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public RestApiException(Throwable cause) {
    super(cause);
  }
}
