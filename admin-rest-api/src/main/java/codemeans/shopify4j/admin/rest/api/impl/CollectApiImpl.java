package codemeans.shopify4j.admin.rest.api.impl;

import codemeans.shopify4j.admin.rest.api.CollectApi;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.collects.CollectList;
import codemeans.shopify4j.admin.rest.model.products.Collect;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CollectApiImpl implements CollectApi {

  private final ShopifyStore store;
  private final Invoker invoker;

  public CollectApiImpl(ShopifyStore store) {
    this.store = store;
    this.invoker = store.getInvoker();
  }

  private String resourcesEndpoint() {
    return store.getBaseEndpoint() + "/collects.json";
  }

  private String countEndpoint() {
    return store.getBaseEndpoint() + "/collects/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/collects/%s.json", store.getBaseEndpoint(), id);
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
