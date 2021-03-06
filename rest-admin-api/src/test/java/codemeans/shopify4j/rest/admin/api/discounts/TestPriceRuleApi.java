package codemeans.shopify4j.rest.admin.api.discounts;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.ContextForTest;
import codemeans.shopify4j.rest.admin.api.discounts.PriceRuleApi.ListReq;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.discounts.PriceRule;
import codemeans.shopify4j.rest.admin.model.discounts.PriceRuleList;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestPriceRuleApi {

  private final PriceRuleApi api = ContextForTest.TEST_STORE.priceRules();

  @Test
  public void testCount() throws RestApiException {
    Count count = api.count().object();
    System.out.println(count);
  }

  @Test
  public void testList() throws RestApiException {
    ListReq listReq = new ListReq();
    PriceRuleList priceRuleList = api.list(listReq).object();
    System.out.println(priceRuleList);

    PriceRule priceRule1 = priceRuleList.getPriceRules().get(0);
    PriceRule priceRule2 = api.get(priceRule1.getId()).object();
    System.out.println(priceRule2);
    assertEquals(priceRule1, priceRule2);

  }
}
