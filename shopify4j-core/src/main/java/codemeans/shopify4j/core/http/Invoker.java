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
  <T> T get(HttpRequest request, Class<T> respType) throws ShopifyServerException;

}
