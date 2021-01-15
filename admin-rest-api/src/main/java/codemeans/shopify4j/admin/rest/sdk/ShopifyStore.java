package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.api.products.CollectApi;
import codemeans.shopify4j.admin.rest.api.products.CollectionApi;
import codemeans.shopify4j.admin.rest.api.products.CustomCollectionApi;
import codemeans.shopify4j.admin.rest.api.products.Pipeline;
import codemeans.shopify4j.admin.rest.api.products.ProductApi;
import codemeans.shopify4j.admin.rest.api.products.ProductImageApi;
import codemeans.shopify4j.admin.rest.api.products.ProductVariantApi;
import codemeans.shopify4j.admin.rest.api.products.SmartCollectionApi;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.core.store.StoreSetting;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface ShopifyStore {

  StoreSetting getStoreSetting();

  /**
   * base endpoint:
   * <ul>
   * <li>specify domain and apiVersion</li>
   * <li>not ending with slash {@code /}</li>
   * </ul>
   */
  String getBaseEndpoint();

  Invoker getInvoker();

  default <R> R pipeline(Pipeline<ShopifyStore, R> pipeline) throws ShopifyServerException {
    return pipeline.runWith(this);
  }

  ProductApi products();

  CollectApi collects();

  CollectionApi collections();

  CustomCollectionApi customCollections();

  SmartCollectionApi smartCollections();

  ProductImageApi productImages();

  ProductVariantApi productVariants();
}
