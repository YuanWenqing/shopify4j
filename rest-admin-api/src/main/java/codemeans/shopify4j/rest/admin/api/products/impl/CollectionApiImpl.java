package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.rest.admin.RestStore;
import codemeans.shopify4j.rest.admin.api.products.CollectionApi;
import codemeans.shopify4j.rest.admin.model.products.Collection;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class CollectionApiImpl implements CollectionApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public CollectionApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static CollectionApi of(RestStore store) {
    return new CollectionApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String singleEndpoint(long id) {
    return String.format("%s/collections/%s.json", baseEndpoint, id);
  }

  private String productsEndpoint(long id) {
    return String.format("%s/collections/%s/products.json", baseEndpoint, id);
  }

  @Override
  public HttpResponse<Collection> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), Collection.class);
  }

  @Override
  public HttpResponse<ProductList> products(long id, Integer limit) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(productsEndpoint(id));
    if (limit != null) {
      httpRequest.addQuery("limit", limit.toString());
    }
    return invoker.get(httpRequest, ProductList.class);
  }
}
