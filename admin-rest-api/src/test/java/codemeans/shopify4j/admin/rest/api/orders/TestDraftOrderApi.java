package codemeans.shopify4j.admin.rest.api.orders;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.orders.DraftOrderApi.CountReq;
import codemeans.shopify4j.admin.rest.api.orders.DraftOrderApi.ListReq;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrder;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrderList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class TestDraftOrderApi {

  private final DraftOrderApi api = ContextForTest.TEST_STORE.draftOrders();

  @Test
  public void testCount() throws ShopifyServerException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq);
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ListReq listReq = new ListReq();
    DraftOrderList orderList = api.list(listReq);
    System.out.println(orderList);
    DraftOrder order1 = orderList.getDraftOrders().get(0);
    DraftOrder order2 = api.get(order1.getId());
    System.out.println(order2);
    assertEquals(order1, order2);
  }
}
