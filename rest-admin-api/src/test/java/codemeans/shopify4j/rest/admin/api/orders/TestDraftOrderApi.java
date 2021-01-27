package codemeans.shopify4j.rest.admin.api.orders;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.orders.DraftOrderApi.CountReq;
import codemeans.shopify4j.rest.admin.api.orders.DraftOrderApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrder;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrderList;
import codemeans.shopify4j.core.exception.RestApiException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class TestDraftOrderApi {

  private final DraftOrderApi api = ContextForTest.TEST_STORE.draftOrders();

  @Test
  public void testCount() throws RestApiException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq();
    DraftOrderList orderList = api.list(listReq).object();
    System.out.println(orderList);
    DraftOrder order1 = orderList.getDraftOrders().get(0);
    DraftOrder order2 = api.get(order1.getId()).object();
    System.out.println(order2);
    assertEquals(order1, order2);
  }
}
