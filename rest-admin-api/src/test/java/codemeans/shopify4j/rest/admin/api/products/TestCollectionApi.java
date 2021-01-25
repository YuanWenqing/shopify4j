package codemeans.shopify4j.rest.admin.api.products;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.products.CollectApi.ListReq;
import codemeans.shopify4j.rest.admin.model.products.Collect;
import codemeans.shopify4j.rest.admin.model.products.CollectList;
import codemeans.shopify4j.rest.admin.model.products.Collection;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
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
    CollectList collectList = collectApi.list(listReq).object();
    System.out.println(collectList);
    Collect collect = collectList.getCollects().get(0);
    long collectionId = collect.getCollectionId();
    Collection collection = api.get(collectionId).object();
    System.out.println(collection);
    assertEquals(collectionId, collection.getId().longValue());

    ProductList productList = api.products(collectionId, null).object();
    System.out.println(productList);
  }
}
