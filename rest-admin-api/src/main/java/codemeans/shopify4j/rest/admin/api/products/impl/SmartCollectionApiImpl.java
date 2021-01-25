package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.rest.admin.api.products.SmartCollectionApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.SmartCollection;
import codemeans.shopify4j.rest.admin.model.products.SmartCollectionList;
import codemeans.shopify4j.rest.admin.sdk.ShopifyStore;
import codemeans.shopify4j.rest.core.exception.ShopifyServerException;
import codemeans.shopify4j.rest.core.http.HttpRequest;
import codemeans.shopify4j.rest.core.http.HttpResponse;
import codemeans.shopify4j.rest.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class SmartCollectionApiImpl implements SmartCollectionApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public SmartCollectionApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static SmartCollectionApi of(ShopifyStore store) {
    return new SmartCollectionApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/smart_collections.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/smart_collections/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/smart_collections/%s.json", baseEndpoint, id);
  }

  @Override
  public HttpResponse<SmartCollectionList> list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, SmartCollectionList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<SmartCollection> get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), SmartCollection.class);
  }

  @Override
  public HttpResponse<SmartCollection> create(SmartCollection req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, SmartCollection.class);
  }

  @Override
  public HttpResponse<SmartCollection> update(long id, SmartCollection req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, SmartCollection.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }
}