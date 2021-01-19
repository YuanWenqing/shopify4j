package codemeans.shopify4j.admin.rest.api.discounts;

import codemeans.shopify4j.admin.rest.model.discounts.DiscountCode;
import codemeans.shopify4j.admin.rest.model.discounts.DiscountCodeList;
import codemeans.shopify4j.core.exception.ShopifyServerException;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeApi {

  DiscountCode create(long priceRuleId, DiscountCode req) throws ShopifyServerException;

  DiscountCode update(long priceRuleId, long discountCodeId, DiscountCode req)
      throws ShopifyServerException;

  DiscountCodeList list(long priceRuleId) throws ShopifyServerException;

  DiscountCode get(long priceRuleId, long discountCodeId) throws ShopifyServerException;

  DiscountCode lookup(String code) throws ShopifyServerException;

  void delete(long priceRuleId, long discountCodeId) throws ShopifyServerException;

}
