package codemeans.shopify4j.rest.admin.api.orders.impl;

import codemeans.shopify4j.rest.admin.RestStore;
import codemeans.shopify4j.rest.admin.api.orders.DraftOrderApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.common.Empty;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrder;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrderInvoice;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrderList;
import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public class DraftOrderApiImpl implements DraftOrderApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public DraftOrderApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static DraftOrderApi of(RestStore store) {
    return new DraftOrderApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/draft_orders.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/draft_orders/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/draft_orders/%s.json", baseEndpoint, id);
  }

  private String singleOperationEndpoint(long id, String operation) {
    return String.format("%s/draft_orders/%s/%s.json", baseEndpoint, id, operation);
  }

  @Override
  public HttpResponse<DraftOrderList> list(ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, DraftOrderList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<DraftOrder> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), DraftOrder.class);
  }

  @Override
  public HttpResponse<DraftOrder> create(DraftOrder req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, DraftOrder.class);
  }

  @Override
  public HttpResponse<DraftOrder> update(long id, DraftOrder req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, DraftOrder.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }

  @Override
  public HttpResponse<DraftOrder> sendInvoice(long id, DraftOrderInvoice req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "send_invoice"));
    httpRequest.setBody(req);
    return invoker.postJson(httpRequest, DraftOrder.class);
  }

  @Override
  public HttpResponse<DraftOrder> complete(long id, Boolean paymentPending) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "close"))
        .setBody(Empty.INSTANCE);
    if (paymentPending != null) {
      httpRequest.addQuery("payment_pending", paymentPending.toString());
    }
    return invoker.putJson(httpRequest, DraftOrder.class);
  }

}
