package codemeans.shopify4j.admin.rest.api.discounts;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.discounts.PriceRule;
import codemeans.shopify4j.admin.rest.model.discounts.PriceRuleList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface PriceRuleApi {

  PriceRule create(PriceRule priceRule) throws ShopifyServerException;

  PriceRule update(long id, PriceRule priceRule) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  PriceRule get(long id) throws ShopifyServerException;

  Count count() throws ShopifyServerException;

  PriceRuleList list(ListReq req) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private Long sinceId;
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime startsAtMin;
    private DateTime startsAtMax;
    private DateTime endsAtMin;
    private DateTime endsAtMax;
    private Integer timesUsed;
  }
}
