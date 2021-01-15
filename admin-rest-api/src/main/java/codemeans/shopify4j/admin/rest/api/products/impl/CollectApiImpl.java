package codemeans.shopify4j.admin.rest.api.products.impl;

import codemeans.shopify4j.admin.rest.api.products.CollectApi;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Collect;
import codemeans.shopify4j.admin.rest.model.products.CollectList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CollectApiImpl implements CollectApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public CollectApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static CollectApi of(ShopifyStore store) {
    return new CollectApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/collects.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/collects/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/collects/%s.json", baseEndpoint, id);
  }

  @Override
  public Collect create(Collect req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Collect.class);
  }

  @Override
  public void delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    invoker.delete(httpRequest);
  }

  @Override
  public CollectList list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, CollectList.class);
  }

  @Override
  public Count count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public Collect get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), Collect.class);
  }

}
