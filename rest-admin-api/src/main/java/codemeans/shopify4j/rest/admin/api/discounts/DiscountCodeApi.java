package codemeans.shopify4j.rest.admin.api.discounts;

import codemeans.shopify4j.rest.admin.model.discounts.DiscountCode;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestApiException;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeApi {

  HttpResponse<DiscountCode> create(long priceRuleId, DiscountCode req)
      throws RestApiException;

  HttpResponse<DiscountCode> update(long priceRuleId, long discountCodeId, DiscountCode req)
      throws RestApiException;

  HttpResponse<DiscountCodeList> list(long priceRuleId) throws RestApiException;

  HttpResponse<DiscountCode> get(long priceRuleId, long discountCodeId)
      throws RestApiException;

  HttpResponse<DiscountCode> lookup(String code) throws RestApiException;

  HttpResponse<String> delete(long priceRuleId, long discountCodeId) throws RestApiException;

}
