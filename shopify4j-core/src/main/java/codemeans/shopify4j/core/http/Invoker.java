package codemeans.shopify4j.core.http;

import codemeans.shopify4j.core.exception.ShopifyServerException;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface Invoker {

  ICodec getCodec();

  /**
   * http GET
   */
  default <T> T get(String url, Class<T> respType) throws ShopifyServerException {
    return get(HttpRequest.of(url), respType);
  }

  /**
   * http GET
   */
  <T> T get(HttpRequest httpRequest, Class<T> respType) throws ShopifyServerException;

  /**
   * http POST and {@code content-type=application/json}
   */
  <T> T postJson(HttpRequest httpRequest, Class<T> respType) throws ShopifyServerException;

  /**
   * http PUT and {@code content-type=application/json}
   */
  <T> T putJson(HttpRequest httpRequest, Class<T> respType) throws ShopifyServerException;

  /**
   * http DELETE
   */
  void delete(HttpRequest httpRequest) throws ShopifyServerException;
}
