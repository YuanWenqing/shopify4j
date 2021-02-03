package codemeans.shopify4j.rest.admin.api.discounts;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCode;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeList;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestDiscountCodeApi {

  private final long priceRuleId = 751407857816L;
  private final DiscountCodeApi api = ContextForTest.TEST_STORE.discountCodes();

  @Test
  public void testList() throws RestApiException {
    DiscountCodeList list = api.list(priceRuleId).object();
    System.out.println(list);

    DiscountCode value1 = list.getDiscountCodes().get(0);
    DiscountCode value2 = api.get(priceRuleId, value1.getId()).object();
    System.out.println(value2);
    assertEquals(value1, value2);

    DiscountCode value3 = api.lookup(value1.getCode()).object();
    System.out.println(value3);
    assertEquals(value1, value3);
  }
}
