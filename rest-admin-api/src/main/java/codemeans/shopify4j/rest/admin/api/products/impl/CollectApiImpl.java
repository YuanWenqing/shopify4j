package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.RestAdmin;
import codemeans.shopify4j.rest.admin.api.products.CollectApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Collect;
import codemeans.shopify4j.rest.admin.model.products.CollectList;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CollectApiImpl implements CollectApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public CollectApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static CollectApi of(RestAdmin store) {
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
  public HttpResponse<Collect> create(Collect req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Collect.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }

  @Override
  public HttpResponse<CollectList> list(ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, CollectList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<Collect> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), Collect.class);
  }

}
