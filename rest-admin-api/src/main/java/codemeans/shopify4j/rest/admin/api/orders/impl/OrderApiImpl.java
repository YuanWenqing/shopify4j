package codemeans.shopify4j.rest.admin.api.orders.impl;

import codemeans.shopify4j.rest.admin.RestStore;
import codemeans.shopify4j.rest.admin.api.orders.OrderApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.common.Empty;
import codemeans.shopify4j.rest.admin.model.orders.Order;
import codemeans.shopify4j.rest.admin.model.orders.OrderList;
import codemeans.shopify4j.rest.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public class OrderApiImpl implements OrderApi {

  private final String baseEndpoint;
  private final RestInvoker invoker;

  public OrderApiImpl(String baseEndpoint, RestInvoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static OrderApi of(RestStore store) {
    return new OrderApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/orders.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/orders/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/orders/%s.json", baseEndpoint, id);
  }

  private String singleOperationEndpoint(long id, String operation) {
    return String.format("%s/orders/%s/%s.json", baseEndpoint, id, operation);
  }

  @Override
  public HttpResponse<OrderList> list(ListReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, OrderList.class);
  }

  @Override
  public HttpResponse<Count> count(CountReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<Order> get(long id) throws RestApiException {
    return invoker.get(singleEndpoint(id), Order.class);
  }

  @Override
  public HttpResponse<Order> create(Order req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Order.class);
  }

  @Override
  public HttpResponse<Order> update(long id, Order req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, Order.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }

  @Override
  public HttpResponse<Order> close(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "close"));
    httpRequest.setBody(Empty.INSTANCE);
    return invoker.postJson(httpRequest, Order.class);
  }

  @Override
  public HttpResponse<Order> open(long id) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "open"));
    httpRequest.setBody(Empty.INSTANCE);
    return invoker.postJson(httpRequest, Order.class);
  }

  @Override
  public HttpResponse<Order> cancel(long id, CancelReq req) throws RestApiException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "cancel"));
    httpRequest.setBody(req);
    return invoker.postJson(httpRequest, Order.class);
  }
}
