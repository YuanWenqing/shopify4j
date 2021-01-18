package codemeans.shopify4j.admin.rest.api.products;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.products.CollectApi.ListReq;
import codemeans.shopify4j.admin.rest.model.products.Collect;
import codemeans.shopify4j.admin.rest.model.products.CollectList;
import codemeans.shopify4j.admin.rest.model.products.Collection;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public class TestCollectionApi {

  private final CollectApi collectApi = ContextForTest.TEST_STORE.collects();
  private final CollectionApi api = ContextForTest.TEST_STORE.collections();

  @Test
  public void test() throws ShopifyServerException {
    ListReq listReq = new ListReq();
    CollectList collectList = collectApi.list(listReq);
    System.out.println(collectList);
    Collect collect = collectList.getCollects().get(0);
    long collectionId = collect.getCollectionId();
    Collection collection = api.get(collectionId);
    System.out.println(collection);
    assertEquals(collectionId, collection.getId().longValue());

    ProductList productList = api.products(collectionId, null);
    System.out.println(productList);
  }
}
