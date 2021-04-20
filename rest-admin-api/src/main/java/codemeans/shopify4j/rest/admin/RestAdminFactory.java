package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.core.base.CachedClientFactory;
import codemeans.shopify4j.core.base.ClientFactory;
import codemeans.shopify4j.rest.http.RestInvoker;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class RestAdminFactory implements ClientFactory<RestAdmin> {

  private final RestInvoker invoker;
  private String apiVersion = "2021-01";

  public RestAdminFactory(@NonNull RestInvoker invoker) {
    this.invoker = invoker;
  }

  @Override
  public RestAdmin getClient(String myshopifyDomain) {
    return new DefaultRestAdmin(myshopifyDomain, apiVersion, invoker);
  }

  public CachedRestAdminFactory cached() {
    return new CachedRestAdminFactory(this);
  }

  public static class CachedRestAdminFactory extends CachedClientFactory<RestAdmin> {

    protected CachedRestAdminFactory(ClientFactory delegate) {
      super(delegate);
    }
  }

}
