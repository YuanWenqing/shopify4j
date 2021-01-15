package codemeans.shopify4j.admin.rest.api;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.ProductApi.ListReq;
import codemeans.shopify4j.admin.rest.api.impl.ProductApiImpl;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.api.ProductApi.CountReq;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestProductApi {

  private final ProductApi api = new ProductApiImpl(ContextForTest.TEST_STORE);

  @Test
  public void testGetProduct() throws ShopifyServerException {
    Product product = api.get(5496978866341L);
    System.out.println(product);
  }

  @Test
  public void testCount() throws ShopifyServerException {
    CountReq countReq = new CountReq();
    countReq.setVendor("mypreferr");
    Count count = api.count(countReq);
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ListReq listReq = new ListReq()
        .setVendor("mypreferr");
    ProductList productList = api.list(listReq);
    System.out.println(productList);
  }
}
