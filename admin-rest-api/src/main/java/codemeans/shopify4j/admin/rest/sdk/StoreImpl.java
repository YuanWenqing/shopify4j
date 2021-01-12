package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.api.impl.ProductApiImpl;
import codemeans.shopify4j.admin.rest.auth.StoreCredential;
import codemeans.shopify4j.admin.rest.http.ICodec;
import codemeans.shopify4j.admin.rest.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class StoreImpl implements Store {

  private final Invoker invoker;

  private ProductApi productApi;

  public StoreImpl(StoreCredential credential, Invoker invoker) {
    this.invoker = invoker;
    initApis(invoker);
  }

  private void initApis(Invoker invoker) {
    productApi = new ProductApiImpl(invoker);
  }

  @Override
  public String getStoreDomain() {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public String getBaseEndpoint() {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public String getApiVersion() {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public ProductApi product() {
    return productApi;
  }
}
