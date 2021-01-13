package codemeans.shopify4j.core.http;

import codemeans.shopify4j.core.exception.ShopifyServerException;
import okhttp3.Request;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface Invoker {

  ICodec getCodec();

  /**
   * 发起请求，处理shopify server error
   */
  <T> T invoke(Request request, Class<T> respType) throws ShopifyServerException;
}
