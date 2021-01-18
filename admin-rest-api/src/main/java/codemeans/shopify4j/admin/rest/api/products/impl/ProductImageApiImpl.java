package codemeans.shopify4j.admin.rest.api.products.impl;

import static codemeans.shopify4j.admin.rest.model.Utils.checkNotNull;

import codemeans.shopify4j.admin.rest.api.products.ProductImageApi;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.ProductImage;
import codemeans.shopify4j.admin.rest.model.products.ProductImageList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

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

  public static ProductImageApi of(ShopifyStore store) {
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
  public ProductImageList list(long productId, ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId));
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductImageList.class);
  }

  @Override
  public Count count(long productId, Long imageSinceId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint(productId));
    if (imageSinceId != null) {
      httpRequest.addQuery("since_id", imageSinceId.toString());
    }
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public ProductImage get(long productId, long imageId) throws ShopifyServerException {
    return invoker.get(singleEndpoint(productId, imageId), ProductImage.class);
  }

  @Override
  public ProductImage create(long productId, ProductImage req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(productId))
        .setBody(req);
    return invoker.postJson(httpRequest, ProductImage.class);
  }

  @Override
  public ProductImage update(long productId, ProductImage req) throws ShopifyServerException {
    checkNotNull(req.getId(), "Null ProductImage Id");
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(productId, req.getId()))
        .setBody(req);
    return invoker.putJson(httpRequest, ProductImage.class);
  }

  @Override
  public void delete(long productId, long imageId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(productId, imageId));
    invoker.delete(httpRequest);
  }
}
