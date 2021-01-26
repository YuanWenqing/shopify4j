package codemeans.shopify4j.rest.http;

import lombok.Getter;

/**
 * shopify response with error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class HttpResponseException extends Exception {

  @Getter
  private HttpResponse response;

  public HttpResponseException(HttpResponse response) {
    super(response.toString());
    this.response = response;
  }

  public HttpResponseException() {
  }

  public HttpResponseException(String message) {
    super(message);
  }

  public HttpResponseException(String message, Throwable cause) {
    super(message, cause);
  }

  public HttpResponseException(Throwable cause) {
    super(cause);
  }

}
