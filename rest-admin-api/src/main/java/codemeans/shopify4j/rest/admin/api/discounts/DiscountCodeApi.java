package codemeans.shopify4j.rest.admin.api.discounts;

import codemeans.shopify4j.rest.admin.model.discounts.DiscountCode;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeApi {

  HttpResponse<DiscountCode> create(long priceRuleId, DiscountCode req)
      throws HttpResponseException;

  HttpResponse<DiscountCode> update(long priceRuleId, long discountCodeId, DiscountCode req)
      throws HttpResponseException;

  HttpResponse<DiscountCodeList> list(long priceRuleId) throws HttpResponseException;

  HttpResponse<DiscountCode> get(long priceRuleId, long discountCodeId)
      throws HttpResponseException;

  HttpResponse<DiscountCode> lookup(String code) throws HttpResponseException;

  HttpResponse<String> delete(long priceRuleId, long discountCodeId) throws HttpResponseException;

}
