package codemeans.shopify4j.rest.http;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface RestInvoker {

  ICodec getCodec();

  /**
   * http GET
   */
  default <T> HttpResponse<T> get(String url, Class<T> respType) throws HttpResponseException {
    return get(HttpRequest.of(url), respType);
  }

  /**
   * http GET
   */
  <T> HttpResponse<T> get(HttpRequest httpRequest, Class<T> respType) throws HttpResponseException;

  /**
   * http POST and {@code content-type=application/json}
   */
  <T> HttpResponse<T> postJson(HttpRequest httpRequest, Class<T> respType)
      throws HttpResponseException;

  /**
   * http PUT and {@code content-type=application/json}
   */
  <T> HttpResponse<T> putJson(HttpRequest httpRequest, Class<T> respType)
      throws HttpResponseException;

  /**
   * http DELETE
   */
  <T> HttpResponse<T> delete(HttpRequest httpRequest, Class<T> respType)
      throws HttpResponseException;
}
