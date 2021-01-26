package codemeans.shopify4j.rest.http;

import lombok.Getter;

/**
 * shopify response with error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class RestApiException extends Exception {

  @Getter
  private HttpResponse response;

  public RestApiException(HttpResponse response) {
    super(response.toString());
    this.response = response;
  }

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
