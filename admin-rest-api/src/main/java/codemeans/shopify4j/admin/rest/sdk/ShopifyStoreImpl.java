package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.api.impl.ProductApiImpl;
import codemeans.shopify4j.core.StoreSetting;
import codemeans.shopify4j.admin.rest.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyStoreImpl implements ShopifyStore {

  private final StoreSetting storeSetting;
  private final Invoker invoker;
  private final String baseEndpoint;

  private ProductApi productApi;

  public ShopifyStoreImpl(StoreSetting storeSetting, Invoker invoker) {
    this.storeSetting = storeSetting;
    this.baseEndpoint = String.format("https://%s/admin/api/%s/", storeSetting.getStoreDomain(),
        storeSetting.getApiVersion());
    this.invoker = invoker;
    initApis();
  }

  private void initApis() {
    productApi = new ProductApiImpl(baseEndpoint, invoker);
  }

  @Override
  public String getStoreDomain() {
    return storeSetting.getStoreDomain();
  }

  @Override
  public String getApiVersion() {
    return storeSetting.getApiVersion();
  }

  @Override
  public String getBaseEndpoint() {
    return baseEndpoint;
  }

  @Override
  public ProductApi product() {
    return productApi;
  }
}