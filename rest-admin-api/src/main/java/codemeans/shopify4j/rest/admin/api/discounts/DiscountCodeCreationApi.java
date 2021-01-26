package codemeans.shopify4j.rest.admin.api.discounts;

import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeCreation;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeList;
import codemeans.shopify4j.rest.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpResponse;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeCreationApi {

  HttpResponse<DiscountCodeCreation> create(long priceRuleId, DiscountCodeList req) throws RestApiException;

  HttpResponse<DiscountCodeCreation> get(long priceRuleId, long creationId) throws RestApiException;

  HttpResponse<DiscountCodeList> listDiscountCodes(long priceRuleId, long creationId)
      throws RestApiException;

}
