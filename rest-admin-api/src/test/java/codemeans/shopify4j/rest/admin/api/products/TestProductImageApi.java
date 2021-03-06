package codemeans.shopify4j.rest.admin.api.products;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductImage;
import codemeans.shopify4j.rest.admin.model.products.ProductImageList;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestProductImageApi {

  private final ProductImageApi api = ContextForTest.TEST_STORE.productImages();

  private final Long productId = 6245046223000L;

  @Test
  public void testCount() throws RestApiException {
    Count count = api.count(productId, null).object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ProductImageList productImageList = api.list(productId, new ProductImageApi.ListReq()).object();
    System.out.println(productImageList);
    ProductImage expect = productImageList.getImages().get(0);
    ProductImage actual = api.get(expect.getProductId(), expect.getId()).object();
    assertEquals(expect, actual);
  }
}
