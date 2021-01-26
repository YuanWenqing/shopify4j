package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.rest.admin.api.products.CollectionApi;
import codemeans.shopify4j.rest.admin.model.products.Collection;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.admin.sdk.ShopifyStore;
import codemeans.shopify4j.rest.exception.ShopifyServerException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class CollectionApiImpl implements CollectionApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public CollectionApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static CollectionApi of(ShopifyStore store) {
    return new CollectionApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String singleEndpoint(long id) {
    return String.format("%s/collections/%s.json", baseEndpoint, id);
  }

  private String productsEndpoint(long id) {
    return String.format("%s/collections/%s/products.json", baseEndpoint, id);
  }

  @Override
  public HttpResponse<Collection> get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), Collection.class);
  }

  @Override
  public HttpResponse<ProductList> products(long id, Integer limit) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(productsEndpoint(id));
    if (limit != null) {
      httpRequest.addQuery("limit", limit.toString());
    }
    return invoker.get(httpRequest, ProductList.class);
  }
}
