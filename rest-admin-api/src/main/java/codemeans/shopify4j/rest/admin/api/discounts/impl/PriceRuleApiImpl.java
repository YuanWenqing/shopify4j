package codemeans.shopify4j.rest.admin.api.discounts.impl;

import codemeans.shopify4j.rest.admin.api.discounts.PriceRuleApi;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.discounts.PriceRule;
import codemeans.shopify4j.rest.admin.model.discounts.PriceRuleList;
import codemeans.shopify4j.rest.admin.sdk.ShopifyStore;
import codemeans.shopify4j.rest.core.exception.ShopifyServerException;
import codemeans.shopify4j.rest.core.http.HttpRequest;
import codemeans.shopify4j.rest.core.http.HttpResponse;
import codemeans.shopify4j.rest.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class PriceRuleApiImpl implements PriceRuleApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public PriceRuleApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static PriceRuleApi of(ShopifyStore store) {
    return new PriceRuleApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/price_rules.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/price_rules/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/price_rules/%s.json", baseEndpoint, id);
  }

  @Override
  public HttpResponse<PriceRuleList> list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, PriceRuleList.class);
  }

  @Override
  public HttpResponse<Count> count() throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public HttpResponse<PriceRule> get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), PriceRule.class);
  }

  @Override
  public HttpResponse<PriceRule> create(PriceRule req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, PriceRule.class);
  }

  @Override
  public HttpResponse<PriceRule> update(long id, PriceRule req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, PriceRule.class);
  }

  @Override
  public HttpResponse<String> delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    return invoker.delete(httpRequest, String.class);
  }
}