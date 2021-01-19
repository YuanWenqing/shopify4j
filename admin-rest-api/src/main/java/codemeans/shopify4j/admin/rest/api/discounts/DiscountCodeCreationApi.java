package codemeans.shopify4j.admin.rest.api.discounts;

import codemeans.shopify4j.admin.rest.model.discounts.DiscountCodeCreation;
import codemeans.shopify4j.admin.rest.model.discounts.DiscountCodeList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface DiscountCodeCreationApi {

  HttpResponse<DiscountCodeCreation> create(long priceRuleId, DiscountCodeList req) throws ShopifyServerException;

  HttpResponse<DiscountCodeCreation> get(long priceRuleId, long creationId) throws ShopifyServerException;

  HttpResponse<DiscountCodeList> listDiscountCodes(long priceRuleId, long creationId)
      throws ShopifyServerException;

}
