package codemeans.shopify4j.admin.rest.api.discounts.impl;

import codemeans.shopify4j.admin.rest.api.discounts.PriceRuleApi;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.discounts.PriceRule;
import codemeans.shopify4j.admin.rest.model.discounts.PriceRuleList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

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
  public PriceRuleList list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, PriceRuleList.class);
  }

  @Override
  public Count count() throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public PriceRule get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), PriceRule.class);
  }

  @Override
  public PriceRule create(PriceRule req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, PriceRule.class);
  }

  @Override
  public PriceRule update(long id, PriceRule req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id))
        .setBody(req);
    return invoker.putJson(httpRequest, PriceRule.class);
  }

  @Override
  public void delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    invoker.delete(httpRequest);
  }
}
