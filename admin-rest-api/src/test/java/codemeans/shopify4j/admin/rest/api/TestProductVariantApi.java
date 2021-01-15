package codemeans.shopify4j.admin.rest.api;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.products.ProductVariantApi;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.ProductVariant;
import codemeans.shopify4j.admin.rest.model.products.ProductVariantList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestProductVariantApi {

  private final ProductVariantApi api = ContextForTest.TEST_STORE.productVariants();

  private final Long productId = 5496978866341L;

  @Test
  public void testCount() throws ShopifyServerException {
    Count count = api.count(productId);
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ProductVariantList productVariantList = api.list(productId, new ProductVariantApi.ListReq());
    System.out.println(productVariantList);
    ProductVariant expect = productVariantList.getVariants().get(0);
    ProductVariant actual = api.get(expect.getId());
    assertEquals(expect, actual);
  }
}
