package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.CollectApi;
import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface ShopifyStore {

  String getStoreDomain();

  String getApiVersion();

  /**
   * base endpoint:
   * <ul>
   * <li>specify domain and apiVersion</li>
   * <li>not ending with slash {@code /}</li>
   * </ul>
   */
  String getBaseEndpoint();

  Invoker getInvoker();

  ProductApi products();

  CollectApi collects();
}
