package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.products.CollectApi;
import codemeans.shopify4j.admin.rest.api.products.CollectionApi;
import codemeans.shopify4j.admin.rest.api.products.CustomCollectionApi;
import codemeans.shopify4j.admin.rest.api.products.ProductApi;
import codemeans.shopify4j.admin.rest.api.products.ProductImageApi;
import codemeans.shopify4j.admin.rest.api.products.SmartCollectionApi;
import codemeans.shopify4j.admin.rest.api.products.impl.CollectApiImpl;
import codemeans.shopify4j.admin.rest.api.products.impl.CollectionApiImpl;
import codemeans.shopify4j.admin.rest.api.products.impl.CustomCollectionApiImpl;
import codemeans.shopify4j.admin.rest.api.products.impl.ProductApiImpl;
import codemeans.shopify4j.admin.rest.api.products.impl.ProductImageApiImpl;
import codemeans.shopify4j.admin.rest.api.products.impl.SmartCollectionApiImpl;
import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.core.store.StoreSetting;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyStoreImpl implements ShopifyStore {

  private final StoreSetting storeSetting;
  private final Invoker invoker;
  private final String baseEndpoint;

  private ProductApi productApi;
  private CollectApi collectApi;
  private CollectionApi collectionApi;
  private CustomCollectionApi customCollectionApi;
  private SmartCollectionApi smartCollectionApi;
  private ProductImageApi productImageApi;

  public ShopifyStoreImpl(StoreSetting storeSetting, Invoker invoker) {
    this.storeSetting = storeSetting;
    this.baseEndpoint = String.format("https://%s/admin/api/%s", storeSetting.getStoreDomain(),
        storeSetting.getApiVersion());
    this.invoker = invoker;
    initApis();
  }

  private void initApis() {
    productApi = ProductApiImpl.of(this);
    collectApi = CollectApiImpl.of(this);
    collectionApi = CollectionApiImpl.of(this);
    customCollectionApi = CustomCollectionApiImpl.of(this);
    smartCollectionApi = SmartCollectionApiImpl.of(this);
    productImageApi = ProductImageApiImpl.of(this);
  }

  @Override
  public StoreSetting getStoreSetting() {
    return storeSetting;
  }

  @Override
  public String getBaseEndpoint() {
    return baseEndpoint;
  }

  @Override
  public Invoker getInvoker() {
    return invoker;
  }

  @Override
  public ProductApi products() {
    return productApi;
  }

  @Override
  public CollectApi collects() {
    return collectApi;
  }

  @Override
  public CollectionApi collections() {
    return collectionApi;
  }

  @Override
  public CustomCollectionApi customCollections() {
    return customCollectionApi;
  }

  @Override
  public SmartCollectionApi smartCollections() {
    return smartCollectionApi;
  }

  @Override
  public ProductImageApi productImages() {
    return productImageApi;
  }

}
