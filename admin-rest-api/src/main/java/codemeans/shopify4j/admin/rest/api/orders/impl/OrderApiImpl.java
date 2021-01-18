package codemeans.shopify4j.admin.rest.api.orders.impl;

import codemeans.shopify4j.admin.rest.api.orders.OrderApi;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.common.Empty;
import codemeans.shopify4j.admin.rest.model.orders.Order;
import codemeans.shopify4j.admin.rest.model.orders.OrderList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public class OrderApiImpl implements OrderApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public OrderApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static OrderApi of(ShopifyStore store) {
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
  public OrderList list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, OrderList.class);
  }

  @Override
  public Count count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public Order get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), Order.class);
  }

  @Override
  public Order create(Order req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, Order.class);
  }

  @Override
  public Order update(long id, Order req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, Order.class);
  }

  @Override
  public void delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    invoker.delete(httpRequest);
  }

  @Override
  public Order close(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "close"));
    httpRequest.setBody(Empty.INSTANCE);
    return invoker.postJson(httpRequest, Order.class);
  }

  @Override
  public Order open(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "open"));
    httpRequest.setBody(Empty.INSTANCE);
    return invoker.postJson(httpRequest, Order.class);
  }

  @Override
  public Order cancel(long id, CancelReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleOperationEndpoint(id, "cancel"));
    httpRequest.setBody(req);
    return invoker.postJson(httpRequest, Order.class);
  }
}
