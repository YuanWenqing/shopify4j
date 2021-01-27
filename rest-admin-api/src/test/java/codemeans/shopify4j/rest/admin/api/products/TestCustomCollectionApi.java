package codemeans.shopify4j.rest.admin.api.products;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.products.CustomCollectionApi.CountReq;
import codemeans.shopify4j.rest.admin.api.products.CustomCollectionApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.CustomCollection;
import codemeans.shopify4j.rest.admin.model.products.CustomCollectionList;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestCustomCollectionApi {

  private final CustomCollectionApi api = ContextForTest.TEST_STORE.customCollections();

  @Test
  public void testCount() throws RestApiException {
    CountReq countReq = new CountReq();
    Count count = api.count(countReq).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq();
    CustomCollectionList customCollectionList = api.list(listReq).object();
    System.out.println(customCollectionList);

    CustomCollection customCollection1 = customCollectionList.getCustomCollections().get(0);
    CustomCollection customCollection2 = api.get(customCollection1.getId()).object();
    System.out.println(customCollection2);
    assertEquals(customCollection1, customCollection2);

  }
}
