package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.rest.admin.api.products.ProductApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Product;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.admin.sdk.RestStore;
import codemeans.shopify4j.rest.exception.ShopifyServerException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.Invoker;

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

  public static ProductApi of(RestStore store) {
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
  public HttpResponse<ProductList> list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<Product> get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), Product.class);
  }

  @Override
  public HttpResponse<Product> create(Product req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Product.class);
  }

  @Override
  public HttpResponse<Product> update(long id, Product req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, Product.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }
}
