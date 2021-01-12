package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.api.impl.ProductApiImpl;
import codemeans.shopify4j.admin.rest.core.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyRestSdkImpl implements ShopifyRestSdk {

  private final Invoker invoker;

  private ProductApi productApi;

  public ShopifyRestSdkImpl(Invoker invoker) {
    this.invoker = invoker;
    initApis(invoker);
  }

  private void initApis(Invoker invoker) {
    productApi = new ProductApiImpl(invoker);
  }

  @Override
  public ProductApi product() {
    return productApi;
  }
}
