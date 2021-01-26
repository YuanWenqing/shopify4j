package codemeans.shopify4j.graphql.admin.exception;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlApiException extends Exception {

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
