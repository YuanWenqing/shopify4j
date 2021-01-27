package codemeans.shopify4j.rest.admin.api.products;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.products.SmartCollectionApi.CountReq;
import codemeans.shopify4j.rest.admin.api.products.SmartCollectionApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.SmartCollection;
import codemeans.shopify4j.rest.admin.model.products.SmartCollectionList;
import codemeans.shopify4j.core.exception.RestApiException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestSmartCollectionApi {

  private final SmartCollectionApi api = ContextForTest.TEST_STORE.smartCollections();

  @Test
  public void testCount() throws RestApiException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq();
    SmartCollectionList smartCollectionList = api.list(listReq).object();
    System.out.println(smartCollectionList);

    SmartCollection smartCollection1 = smartCollectionList.getSmartCollections().get(0);
    SmartCollection smartCollection2 = api.get(smartCollection1.getId()).object();
    System.out.println(smartCollection2);
    assertEquals(smartCollection1, smartCollection2);

  }
}
