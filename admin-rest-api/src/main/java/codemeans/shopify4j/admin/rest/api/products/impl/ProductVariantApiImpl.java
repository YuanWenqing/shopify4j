package codemeans.shopify4j.admin.rest.api.products.impl;

import static codemeans.shopify4j.admin.rest.model.Utils.checkNotNull;

import codemeans.shopify4j.admin.rest.api.products.ProductVariantApi;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.ProductVariant;
import codemeans.shopify4j.admin.rest.model.products.ProductVariantList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductVariantApiImpl implements ProductVariantApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public ProductVariantApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static ProductVariantApi of(ShopifyStore store) {
    return new ProductVariantApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint(long productId) {
    return String.format("%s/products/%s/variants.json", baseEndpoint, productId);
  }

  private String countEndpoint(long productId) {
    return String.format("%s/products/%s/variants/count.json", baseEndpoint, productId);
  }

  private String boundedSingleEndpoint(long productId, long variantId) {
    return String.format("%s/products/%s/variants/%s.json", baseEndpoint, productId, variantId);
  }

  private String singleEndpoint(long variantId) {
    return String.format("%s/variants/%s.json", baseEndpoint, variantId);
  }

  @Override
  public ProductVariantList list(long productId, ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId));
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductVariantList.class);
  }

  @Override
  public Count count(long productId) throws ShopifyServerException {
    return invoker.get(countEndpoint(productId), Count.class);
  }

  @Override
  public ProductVariant get(long variantId) throws ShopifyServerException {
    return invoker.get(singleEndpoint(variantId), ProductVariant.class);
  }

  @Override
  public ProductVariant create(long productId, ProductVariant req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId))
        .setBody(req);
    return invoker.postJson(httpRequest, ProductVariant.class);
  }

  @Override
  public ProductVariant update(ProductVariant req) throws ShopifyServerException {
    checkNotNull(req.getId(), "Null ProductVariant Id");
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(req.getId()))
        .setBody(req);
    return invoker.putJson(httpRequest, ProductVariant.class);
  }

  @Override
  public void delete(long productId, long variantId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(boundedSingleEndpoint(productId, variantId));
    invoker.delete(httpRequest);
  }
}
