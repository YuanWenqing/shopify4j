package codemeans.shopify4j.rest.admin;

import static codemeans.shopify4j.rest.admin.internal.Utils.checkNotNull;

import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;
import codemeans.shopify4j.rest.http.Invoker;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class RestStoreFactory implements StoreFactory<RestStore> {

  private final StoreSettingStorage storeSettingStorage;
  private final Invoker invoker;

  public RestStoreFactory(
      @NonNull StoreSettingStorage storeSettingStorage,
      @NonNull Invoker invoker) {
    this.storeSettingStorage = storeSettingStorage;
    this.invoker = invoker;
  }

  @Override
  public RestStore getStore(String storeDomain) {
    StoreSetting setting = storeSettingStorage.getStoreSetting(storeDomain);
    checkNotNull(setting, "No Credential for " + storeDomain);

    return new DefaultRestStore(setting, invoker);
  }
}
