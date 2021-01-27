package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.core.store.CachedStoreFactory;
import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.rest.http.RestInvoker;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class RestAdminFactory implements StoreFactory<RestAdmin> {

  private final RestInvoker invoker;
  private String apiVersion = "2021-01";

  public RestAdminFactory(@NonNull RestInvoker invoker) {
    this.invoker = invoker;
  }

  @Override
  public RestAdmin getStore(String myshopifyDomain) {
    return new DefaultRestAdmin(myshopifyDomain, apiVersion, invoker);
  }

  public CachedRestAdminFactory cached() {
    return new CachedRestAdminFactory(this);
  }

  public static class CachedRestAdminFactory extends CachedStoreFactory<RestAdmin> {

    protected CachedRestAdminFactory(StoreFactory delegate) {
      super(delegate);
    }
  }

}
