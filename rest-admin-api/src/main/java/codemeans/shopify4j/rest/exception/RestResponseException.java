package codemeans.shopify4j.rest.exception;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpResponse;
import lombok.Getter;

/**
 * shopify response with errors
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class RestResponseException extends RestApiException {

  @Getter
  private HttpResponse response;

  public RestResponseException(HttpResponse response) {
    super(response.toString());
    this.response = response;
  }

}
