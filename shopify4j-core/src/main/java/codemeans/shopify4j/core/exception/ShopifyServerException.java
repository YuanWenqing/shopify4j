package codemeans.shopify4j.core.exception;

import lombok.Getter;

/**
 * shopify response with error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyServerException extends Exception {

  @Getter
  private final int statusCode;
  @Getter
  private final String response;

  public ShopifyServerException(int statusCode, String response) {
    this.statusCode = statusCode;
    this.response = response;
  }

  @Override
  public String getMessage() {
    return String.format("Status=%s, response: %s", statusCode, response);
  }

}
