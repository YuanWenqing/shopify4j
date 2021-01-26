package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.rest.admin.RestStore;
import codemeans.shopify4j.rest.admin.api.products.ProductImageApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductImage;
import codemeans.shopify4j.rest.admin.model.products.ProductImageList;
import codemeans.shopify4j.rest.exception.ShopifyServerException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductImageApiImpl implements ProductImageApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public ProductImageApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static ProductImageApi of(RestStore store) {
    return new ProductImageApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint(long productId) {
    return String.format("%s/products/%s/images.json", baseEndpoint, productId);
  }

  private String countEndpoint(long productId) {
    return String.format("%s/products/%s/images/count.json", baseEndpoint, productId);
  }

  private String singleEndpoint(long productId, long imageId) {
    return String.format("%s/products/%s/images/%s.json", baseEndpoint, productId, imageId);
  }

  @Override
  public HttpResponse<ProductImageList> list(long productId, ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId));
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductImageList.class);
  }

  @Override
  public HttpResponse<Count> count(long productId, Long imageSinceId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint(productId));
    if (imageSinceId != null) {
      httpRequest.addQuery("since_id", imageSinceId.toString());
    }
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<ProductImage> get(long productId, long imageId) throws ShopifyServerException {
    return invoker.get(singleEndpoint(productId, imageId), ProductImage.class);
  }

  @Override
  public HttpResponse<ProductImage> create(long productId, ProductImage req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId))
        .setBody(req);
    return invoker.postJson(httpRequest, ProductImage.class);
  }

  @Override
  public HttpResponse<ProductImage> update(long productId, long imageId, ProductImage req)
      throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(productId, imageId))
        .setBody(req);
    return invoker.putJson(httpRequest, ProductImage.class);
  }

  @Override
  public HttpResponse<String> delete(long productId, long imageId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(productId, imageId));
    return invoker.delete(httpRequest, String.class);
  }
}
