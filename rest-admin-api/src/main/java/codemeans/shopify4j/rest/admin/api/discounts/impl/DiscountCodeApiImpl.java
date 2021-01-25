package codemeans.shopify4j.rest.admin.api.discounts.impl;

import codemeans.shopify4j.rest.admin.api.discounts.DiscountCodeApi;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCode;
import codemeans.shopify4j.rest.admin.model.discounts.DiscountCodeList;
import codemeans.shopify4j.rest.admin.sdk.ShopifyStore;
import codemeans.shopify4j.rest.core.exception.ShopifyServerException;
import codemeans.shopify4j.rest.core.http.HttpRequest;
import codemeans.shopify4j.rest.core.http.HttpResponse;
import codemeans.shopify4j.rest.core.http.Invoker;

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
  public HttpResponse<DiscountCodeList> list(long priceRuleId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(priceRuleId));
    return invoker.get(httpRequest, DiscountCodeList.class);
  }

  @Override
  public HttpResponse<DiscountCode> get(long priceRuleId, long imageId)
      throws ShopifyServerException {
    return invoker.get(singleEndpoint(priceRuleId, imageId), DiscountCode.class);
  }

  @Override
  public HttpResponse<DiscountCode> lookup(String code) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(lookupEndpoint());
    httpRequest.addQuery("code", code);
    return invoker.get(httpRequest, DiscountCode.class);
  }

  @Override
  public HttpResponse<DiscountCode> create(long priceRuleId, DiscountCode req)
      throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint(priceRuleId))
        .setBody(req);
    return invoker.postJson(httpRequest, DiscountCode.class);
  }

  @Override
  public HttpResponse<DiscountCode> update(long priceRuleId, long imageId, DiscountCode req)
      throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(priceRuleId, imageId))
        .setBody(req);
    return invoker.putJson(httpRequest, DiscountCode.class);
  }

  @Override
  public HttpResponse<String> delete(long priceRuleId, long imageId) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(priceRuleId, imageId));
    return invoker.delete(httpRequest, String.class);
  }
}