package codemeans.shopify4j.core.exception;

/**
 * GraphQL api error
 *
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlApiException extends ShopifyApiException {

  public GraphqlApiException() {
  }

  public GraphqlApiException(String message) {
    super(message);
  }

  public GraphqlApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public GraphqlApiException(Throwable cause) {
    super(cause);
  }
}
