package codemeans.shopify4j.admin.rest.api.discounts.impl;

import codemeans.shopify4j.admin.rest.api.discounts.DiscountCodeApi;
import codemeans.shopify4j.admin.rest.model.discounts.DiscountCode;
import codemeans.shopify4j.admin.rest.model.discounts.DiscountCodeList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class DiscountCodeApiImpl implements DiscountCodeApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public DiscountCodeApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static DiscountCodeApi of(ShopifyStore store) {
    return new DiscountCodeApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint(long priceRuleId) {
    return String.format("%s/price_rules/%s/discount_codes.json", baseEndpoint, priceRuleId);
  }

  private String lookupEndpoint() {
    return String.format("%s/discount_codes/lookup.json", baseEndpoint);
  }

  private String singleEndpoint(long priceRuleId, long imageId) {
    return String.format("%s/price_rules/%s/discount_codes/%s.json",
        baseEndpoint, priceRuleId, imageId);
  }

  @Override
  public DiscountCodeList list(long priceRuleId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(priceRuleId));
    return invoker.get(httpRequest, DiscountCodeList.class);
  }

  @Override
  public DiscountCode get(long priceRuleId, long imageId) throws ShopifyServerException {
    return invoker.get(singleEndpoint(priceRuleId, imageId), DiscountCode.class);
  }

  @Override
  public DiscountCode lookup(String code) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(lookupEndpoint());
    httpRequest.addQuery("code", code);
    return invoker.get(httpRequest, DiscountCode.class);
  }

  @Override
  public DiscountCode create(long priceRuleId, DiscountCode req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(priceRuleId))
        .setBody(req);
    return invoker.postJson(httpRequest, DiscountCode.class);
  }

  @Override
  public DiscountCode update(long priceRuleId, long imageId, DiscountCode req)
      throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(priceRuleId, imageId))
        .setBody(req);
    return invoker.putJson(httpRequest, DiscountCode.class);
  }

  @Override
  public void delete(long priceRuleId, long imageId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(priceRuleId, imageId));
    invoker.delete(httpRequest);
  }
}
