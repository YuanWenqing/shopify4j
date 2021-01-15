package codemeans.shopify4j.admin.rest.api.products.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import codemeans.shopify4j.admin.rest.api.products.ProductApi;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductApiImpl implements ProductApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public ProductApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static ProductApi of(ShopifyStore store) {
    return new ProductApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/products.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/products/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/products/%s.json", baseEndpoint, id);
  }

  @Override
  public ProductList list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductList.class);
  }

  @Override
  public Count count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public Product get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), Product.class);
  }

  @Override
  public Product create(Product req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Product.class);
  }

  @Override
  public Product update(Product req) throws ShopifyServerException {
    checkNotNull(req.getId(), "Null Product Id");
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(req.getId()))
        .setBody(req);
    return invoker.putJson(httpRequest, Product.class);
  }

  @Override
  public void delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    invoker.delete(httpRequest);
  }
}
