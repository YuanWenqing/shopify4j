package codemeans.shopify4j.rest.admin.api.products.impl;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.RestAdmin;
import codemeans.shopify4j.rest.admin.api.products.CustomCollectionApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.CustomCollection;
import codemeans.shopify4j.rest.admin.model.products.CustomCollectionList;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CustomCollectionApiImpl implements CustomCollectionApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public CustomCollectionApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static CustomCollectionApi of(RestAdmin store) {
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
  public HttpResponse<CustomCollectionList> list(ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, CustomCollectionList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<CustomCollection> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), CustomCollection.class);
  }

  @Override
  public HttpResponse<CustomCollection> create(CustomCollection req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, CustomCollection.class);
  }

  @Override
  public HttpResponse<CustomCollection> update(long id, CustomCollection req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, CustomCollection.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }
}
