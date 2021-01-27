package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.rest.http.RestInvoker;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class RestStoreFactory implements StoreFactory<RestStore> {

  private final RestInvoker invoker;
  private String apiVersion = "2021-01";

  public RestStoreFactory(@NonNull RestInvoker invoker) {
    this.invoker = invoker;
  }

  @Override
  public RestStore getStore(String myshopifyDomain) {
    return new DefaultRestStore(myshopifyDomain, apiVersion, invoker);
  }
}
