package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.RestAdmin;
import codemeans.shopify4j.rest.admin.api.products.SmartCollectionApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.SmartCollection;
import codemeans.shopify4j.rest.admin.model.products.SmartCollectionList;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class SmartCollectionApiImpl implements SmartCollectionApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public SmartCollectionApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static SmartCollectionApi of(RestAdmin store) {
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
  public HttpResponse<SmartCollectionList> list(ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, SmartCollectionList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<SmartCollection> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), SmartCollection.class);
  }

  @Override
  public HttpResponse<SmartCollection> create(SmartCollection req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, SmartCollection.class);
  }

  @Override
  public HttpResponse<SmartCollection> update(long id, SmartCollection req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, SmartCollection.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }
}
