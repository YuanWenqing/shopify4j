package codemeans.shopify4j.admin.rest.api;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.products.SmartCollectionApi;
import codemeans.shopify4j.admin.rest.api.products.SmartCollectionApi.CountReq;
import codemeans.shopify4j.admin.rest.api.products.SmartCollectionApi.ListReq;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.SmartCollection;
import codemeans.shopify4j.admin.rest.model.products.SmartCollectionList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestSmartCollectionApi {

  private final SmartCollectionApi api = ContextForTest.TEST_STORE.smartCollections();

  @Test
  public void testCount() throws ShopifyServerException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq);
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ListReq listReq = new ListReq();
    SmartCollectionList smartCollectionList = api.list(listReq);
    System.out.println(smartCollectionList);

    SmartCollection smartCollection1 = smartCollectionList.getSmartCollections().get(0);
    SmartCollection smartCollection2 = api.get(smartCollection1.getId());
    System.out.println(smartCollection2);
    assertEquals(smartCollection1, smartCollection2);

  }
}
