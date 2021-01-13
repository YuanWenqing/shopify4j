package codemeans.shopify4j.admin.rest.api;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.impl.ProductApiImpl;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestProductApi {

  private final ProductApi api = new ProductApiImpl(ContextForTest.TEST_STORE);


  @Test
  public void testGet() throws ShopifyServerException {
    Product product = api.getProduct(5496978866341L);
    System.out.println(product);
  }
}
