package codemeans.shopify4j.admin.rest.api.products.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import codemeans.shopify4j.admin.rest.api.products.SmartCollectionApi;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.SmartCollection;
import codemeans.shopify4j.admin.rest.model.products.SmartCollectionList;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class SmartCollectionApiImpl implements SmartCollectionApi {

  private final String baseEndpoint;
  private final Invoker invoker;

  public SmartCollectionApiImpl(String baseEndpoint, Invoker invoker) {
    this.baseEndpoint = baseEndpoint;
    this.invoker = invoker;
  }

  public static SmartCollectionApi of(ShopifyStore store) {
    return new SmartCollectionApiImpl(store.getBaseEndpoint(), store.getInvoker());
  }

  private String resourcesEndpoint() {
    return baseEndpoint + "/smart_collections.json";
  }

  private String countEndpoint() {
    return baseEndpoint + "/smart_collections/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/smart_collections/%s.json", baseEndpoint, id);
  }

  @Override
  public SmartCollectionList list(ListReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, SmartCollectionList.class);
  }

  @Override
  public Count count(CountReq req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(countEndpoint());
    httpRequest.addQueries(invoker.getCodec().asQueryMap(req));
    return invoker.get(httpRequest, Count.class);
  }

  @Override
  public SmartCollection get(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), SmartCollection.class);
  }

  @Override
  public SmartCollection create(SmartCollection req) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(resourcesEndpoint())
        .setBody(req);
    return invoker.postJson(httpRequest, SmartCollection.class);
  }

  @Override
  public SmartCollection update(SmartCollection req) throws ShopifyServerException {
    checkNotNull(req.getId(), "Null SmartCollection Id");
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(req.getId()))
        .setBody(req);
    return invoker.putJson(httpRequest, SmartCollection.class);
  }

  @Override
  public void delete(long id) throws ShopifyServerException {
    HttpRequest httpRequest = HttpRequest.of(singleEndpoint(id));
    invoker.delete(httpRequest);
  }
}
