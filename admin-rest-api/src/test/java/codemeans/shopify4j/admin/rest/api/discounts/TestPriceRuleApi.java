package codemeans.shopify4j.admin.rest.api.discounts;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.ContextForTest;
import codemeans.shopify4j.admin.rest.api.discounts.PriceRuleApi.ListReq;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.discounts.PriceRule;
import codemeans.shopify4j.admin.rest.model.discounts.PriceRuleList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class TestPriceRuleApi {

  private final PriceRuleApi api = ContextForTest.TEST_STORE.priceRules();

  @Test
  public void testCount() throws ShopifyServerException {
    Count count = api.count().object();
    System.out.println(count);
  }

  @Test
  public void testList() throws ShopifyServerException {
    ListReq listReq = new ListReq();
    PriceRuleList priceRuleList = api.list(listReq).object();
    System.out.println(priceRuleList);

    PriceRule priceRule1 = priceRuleList.getPriceRules().get(0);
    PriceRule priceRule2 = api.get(priceRule1.getId()).object();
    System.out.println(priceRule2);
    assertEquals(priceRule1, priceRule2);

  }
}
