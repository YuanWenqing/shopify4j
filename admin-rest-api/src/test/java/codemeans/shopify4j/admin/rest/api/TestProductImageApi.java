package codemeans.shopify4j.admin.rest.api;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.products.ProductImageApi;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.ProductImage;
import codemeans.shopify4j.admin.rest.model.products.ProductImageList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestProductImageApi {

  private final ProductImageApi api = ContextForTest.TEST_STORE.productImages();

  private final Long productId = 5496978866341L;

  @Test
  public void testCount() throws ShopifyServerException {
    Count count = api.count(productId, null);
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ProductImageList productImageList = api.list(productId, new ProductImageApi.ListReq());
    System.out.println(productImageList);
    ProductImage expect = productImageList.getImages().get(0);
    ProductImage actual = api.get(expect.getProductId(), expect.getId());
    assertEquals(expect, actual);
  }
}
