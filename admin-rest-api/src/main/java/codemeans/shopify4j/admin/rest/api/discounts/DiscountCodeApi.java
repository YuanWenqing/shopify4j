package codemeans.shopify4j.admin.rest.api.discounts;

import codemeans.shopify4j.admin.rest.model.discounts.DiscountCode;
import codemeans.shopify4j.admin.rest.model.discounts.DiscountCodeList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeApi {

  HttpResponse<DiscountCode> create(long priceRuleId, DiscountCode req)
      throws ShopifyServerException;

  HttpResponse<DiscountCode> update(long priceRuleId, long discountCodeId, DiscountCode req)
      throws ShopifyServerException;

  HttpResponse<DiscountCodeList> list(long priceRuleId) throws ShopifyServerException;

  HttpResponse<DiscountCode> get(long priceRuleId, long discountCodeId)
      throws ShopifyServerException;

  HttpResponse<DiscountCode> lookup(String code) throws ShopifyServerException;

  HttpResponse<String> delete(long priceRuleId, long discountCodeId) throws ShopifyServerException;

}
