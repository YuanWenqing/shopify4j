package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.products.CollectApi;
import codemeans.shopify4j.admin.rest.api.products.CollectionApi;
import codemeans.shopify4j.admin.rest.api.products.ProductApi;
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

  CollectionApi collections();
}
