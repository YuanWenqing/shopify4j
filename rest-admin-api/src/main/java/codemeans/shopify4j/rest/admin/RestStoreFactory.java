package codemeans.shopify4j.rest.admin;

import static codemeans.shopify4j.rest.admin.internal.Utils.checkNotNull;

import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;
import codemeans.shopify4j.rest.http.RestInvoker;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class RestStoreFactory implements StoreFactory<RestStore> {

  private final StoreSettingStorage storeSettingStorage;
  private final RestInvoker invoker;
  private String apiVersion = "2021-01";

  public RestStoreFactory(
      @NonNull StoreSettingStorage storeSettingStorage,
      @NonNull RestInvoker invoker) {
    this.storeSettingStorage = storeSettingStorage;
    this.invoker = invoker;
  }

  @Override
  public RestStore getStore(String storeDomain) {
    StoreSetting setting = storeSettingStorage.getStoreSetting(storeDomain);
    checkNotNull(setting, "No Credential for " + storeDomain);

    return new DefaultRestStore(setting.getStoreDomain(), apiVersion, invoker);
  }
}
