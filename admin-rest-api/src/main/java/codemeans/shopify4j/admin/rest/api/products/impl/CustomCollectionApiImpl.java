package codemeans.shopify4j.admin.rest.api.products.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import codemeans.shopify4j.admin.rest.api.products.CustomCollectionApi;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.CustomCollection;
import codemeans.shopify4j.admin.rest.model.products.CustomCollectionList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CustomCollectionApiImpl implements CustomCollectionApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public CustomCollectionApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static CustomCollectionApi of(ShopifyStore store) {
    return new CustomCollectionApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/custom_collections.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/custom_collections/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/custom_collections/%s.json", baseEndpoint, id);
  }

  @Override
  public CustomCollectionList list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, CustomCollectionList.class);
  }

  @Override
  public Count count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public CustomCollection get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), CustomCollection.class);
  }

  @Override
  public CustomCollection create(CustomCollection req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, CustomCollection.class);
  }

  @Override
  public CustomCollection update(CustomCollection req) throws ShopifyServerException {
    checkNotNull(req.getId(), "Null CustomCollection Id");
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(req.getId()))
        .setBody(req);
    return invoker.putJson(httpRequest, CustomCollection.class);
  }

  @Override
  public void delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    invoker.delete(httpRequest);
  }
}
