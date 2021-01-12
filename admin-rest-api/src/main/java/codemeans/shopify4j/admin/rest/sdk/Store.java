package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.ProductApi;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface Store {

  String getStoreDomain();

  String getBaseEndpoint();

  String getApiVersion();

  ProductApi product();
}
