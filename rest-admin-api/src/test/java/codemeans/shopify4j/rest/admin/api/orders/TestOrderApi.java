package codemeans.shopify4j.rest.admin.api.orders;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.orders.OrderApi.CountReq;
import codemeans.shopify4j.rest.admin.api.orders.OrderApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.OrderStatus;
import codemeans.shopify4j.rest.admin.model.orders.Order;
import codemeans.shopify4j.rest.admin.model.orders.OrderList;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class TestOrderApi {

  private final OrderApi api = ContextForTest.TEST_STORE.orders();

  @Test
  public void testCount() throws RestApiException {
    CountReq countReq = new CountReq()
        .setStatus(OrderStatus.any.shopifyValue());
    Count count = api.count(countReq).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq()
        .setStatus(OrderStatus.any.shopifyValue());
    OrderList orderList = api.list(listReq).object();
    System.out.println(orderList);
    Order order1 = orderList.getOrders().get(0);
    Order order2 = api.get(order1.getId()).object();
    System.out.println(order2);
    assertEquals(order1, order2);
  }
}
