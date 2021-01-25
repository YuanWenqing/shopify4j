package codemeans.shopify4j.rest.core.exception;

import codemeans.shopify4j.rest.core.http.HttpResponse;
import lombok.Getter;

/**
 * shopify response with error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyServerException extends Exception {

  @Getter
  private HttpResponse response;

  public ShopifyServerException(HttpResponse response) {
    super(response.toString());
    this.response = response;
  }

  public ShopifyServerException() {
  }

  public ShopifyServerException(String message) {
    super(message);
  }

  public ShopifyServerException(String message, Throwable cause) {
    super(message, cause);
  }

  public ShopifyServerException(Throwable cause) {
    super(cause);
  }

}
