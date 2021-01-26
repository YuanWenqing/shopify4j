package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.rest.admin.RestStore;
import codemeans.shopify4j.rest.admin.api.products.ProductVariantApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductVariant;
import codemeans.shopify4j.rest.admin.model.products.ProductVariantList;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestApiException;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductVariantApiImpl implements ProductVariantApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public ProductVariantApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static ProductVariantApi of(RestStore store) {
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
  public HttpResponse<ProductVariantList> list(long productId, ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId));
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductVariantList.class);
  }

  @Override
  public HttpResponse<Count> count(long productId) throws RestApiException {
    return invoker.get(countEndpoint(productId), Count.class);
  }

  @Override
  public HttpResponse<ProductVariant> get(long variantId) throws RestApiException {
    return invoker.get(singleEndpoint(variantId), ProductVariant.class);
  }

  @Override
  public HttpResponse<ProductVariant> create(long productId, ProductVariant req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId))
        .setBody(req);
    return invoker.postJson(httpRequest, ProductVariant.class);
  }

  @Override
  public HttpResponse<ProductVariant> update(long id, ProductVariant req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, ProductVariant.class);
  }

  @Override
  public HttpResponse<String> delete(long productId, long variantId) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(boundedSingleEndpoint(productId, variantId));
    return invoker.delete(httpRequest, String.class);
  }
}
