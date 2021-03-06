package codemeans.shopify4j.rest.http;

import codemeans.shopify4j.core.exception.RestApiException;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface RestInvoker {

  ICodec getCodec();

  /**
   * http GET
   */
  default <T> HttpResponse<T> get(String url, Class<T> respType) throws RestApiException {
    return get(HttpRequest.of(url), respType);
  }

  /**
   * http GET
   */
  <T> HttpResponse<T> get(HttpRequest httpRequest, Class<T> respType) throws RestApiException;

  /**
   * http POST and {@code content-type=application/json}
   */
  <T> HttpResponse<T> postJson(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException;

  /**
   * http PUT and {@code content-type=application/json}
   */
  <T> HttpResponse<T> putJson(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException;

  /**
   * http DELETE
   */
  <T> HttpResponse<T> delete(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException;
}
