package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.api.impl.ProductApiImpl;
import codemeans.shopify4j.admin.rest.auth.StoreCredential;
import codemeans.shopify4j.admin.rest.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyStoreImpl implements ShopifyStore {

  private final StoreCredential credential;
  private final Invoker invoker;
  private final String baseEndpoint;

  private ProductApi productApi;

  public ShopifyStoreImpl(StoreCredential credential, Invoker invoker) {
    this.credential = credential;
    this.baseEndpoint = String.format("https://%s/admin/api/%s/", credential.getStoreDomain(),
        credential.getApiVersion());
    this.invoker = invoker;
    initApis();
  }

  private void initApis() {
    productApi = new ProductApiImpl(baseEndpoint, invoker);
  }

  @Override
  public String getStoreDomain() {
    return credential.getStoreDomain();
  }

  @Override
  public String getApiVersion() {
    return credential.getApiVersion();
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
