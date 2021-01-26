package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.products.ProductApi.CountReq;
import codemeans.shopify4j.rest.admin.api.products.ProductApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Product;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.exception.RestApiException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestProductApi {

  private final ProductApi api = ContextForTest.TEST_STORE.products();

  @Test
  public void testGetProduct() throws RestApiException {
    Product product = api.get(5496978866341L).object();
    System.out.println(product);
  }

  @Test
  public void testCount() throws RestApiException {
    CountReq countReq = new CountReq();
    countReq.setVendor("mypreferr");
    Count count = api.count(countReq).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq()
        .setVendor("mypreferr");
    ProductList productList = api.list(listReq).object();
    System.out.println(productList);
  }
}
