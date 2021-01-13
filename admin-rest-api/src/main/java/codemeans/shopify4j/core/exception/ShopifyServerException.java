package codemeans.shopify4j.core.exception;

/**
 * shopify response with error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyServerException extends Exception {

  private final int statusCode;
  private final String response;

  public ShopifyServerException(int statusCode, String response) {
    this.statusCode = statusCode;
    this.response = response;
  }
}
