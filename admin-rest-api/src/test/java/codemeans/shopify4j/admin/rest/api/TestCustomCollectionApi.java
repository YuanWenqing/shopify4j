package codemeans.shopify4j.admin.rest.api;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.products.CustomCollectionApi;
import codemeans.shopify4j.admin.rest.api.products.CustomCollectionApi.CountReq;
import codemeans.shopify4j.admin.rest.api.products.CustomCollectionApi.ListReq;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.CustomCollection;
import codemeans.shopify4j.admin.rest.model.products.CustomCollectionList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestCustomCollectionApi {

  private final CustomCollectionApi api = ContextForTest.TEST_STORE.customCollections();

  @Test
  public void testCount() throws ShopifyServerException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq);
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ListReq listReq = new ListReq();
    CustomCollectionList customCollectionList = api.list(listReq);
    System.out.println(customCollectionList);

    CustomCollection customCollection1 = customCollectionList.getCustomCollections().get(0);
    CustomCollection customCollection2 = api.get(customCollection1.getId());
    System.out.println(customCollection2);
    assertEquals(customCollection1, customCollection2);

  }
}
