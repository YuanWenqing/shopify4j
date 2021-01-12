package codemeans.shopify4j.admin.rest.http;

import codemeans.shopify4j.admin.rest.exception.ShopifyServerException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface Invoker {

  OkHttpClient getOkHttpClient();

  /**
   * 发起请求，处理shopify server error
   */
  <T> T invoke(Request request, Class<T> respType) throws ShopifyServerException;
}
