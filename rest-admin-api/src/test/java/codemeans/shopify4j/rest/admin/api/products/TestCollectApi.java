package codemeans.shopify4j.rest.admin.api.products;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.products.CollectApi.CountReq;
import codemeans.shopify4j.rest.admin.api.products.CollectApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Collect;
import codemeans.shopify4j.rest.admin.model.products.CollectList;
import codemeans.shopify4j.rest.http.RestApiException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class TestCollectApi {

  private final CollectApi api = ContextForTest.TEST_STORE.collects();

  @Test
  public void testCount() throws RestApiException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq();
    CollectList collectList = api.list(listReq).object();
    System.out.println(collectList);
    Collect collect1 = collectList.getCollects().get(0);
    Collect collect2 = api.get(collect1.getId()).object();
    System.out.println(collect2);
    assertEquals(collect1, collect2);
  }
}
