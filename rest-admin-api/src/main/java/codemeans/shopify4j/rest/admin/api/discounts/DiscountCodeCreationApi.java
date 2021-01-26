package codemeans.shopify4j.rest.admin.api.discounts;

import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeCreation;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeCreationApi {

  HttpResponse<DiscountCodeCreation> create(long priceRuleId, DiscountCodeList req) throws HttpResponseException;

  HttpResponse<DiscountCodeCreation> get(long priceRuleId, long creationId) throws HttpResponseException;

  HttpResponse<DiscountCodeList> listDiscountCodes(long priceRuleId, long creationId)
      throws HttpResponseException;

}
