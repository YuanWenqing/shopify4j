package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.RestAdmin;
import codemeans.shopify4j.rest.admin.api.products.ProductApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Product;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductApiImpl implements ProductApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public ProductApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static ProductApi of(RestAdmin store) {
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
  public HttpResponse<ProductList> list(ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, ProductList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<Product> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), Product.class);
  }

  @Override
  public HttpResponse<Product> create(Product req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Product.class);
  }

  @Override
  public HttpResponse<Product> update(long id, Product req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, Product.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }
}
