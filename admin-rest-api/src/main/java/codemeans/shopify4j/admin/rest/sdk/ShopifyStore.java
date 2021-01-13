package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.ProductApi;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface ShopifyStore {

  String getStoreDomain();

  String getApiVersion();

  String getBaseEndpoint();

  ProductApi product();
}
