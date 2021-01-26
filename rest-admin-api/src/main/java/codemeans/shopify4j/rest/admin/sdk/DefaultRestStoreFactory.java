package codemeans.shopify4j.rest.admin.sdk;

import static codemeans.shopify4j.rest.admin.internal.Utils.checkNotNull;

import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;
import codemeans.shopify4j.rest.http.Invoker;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class DefaultRestStoreFactory implements RestStoreFactory {

  private final StoreSettingStorage storeSettingStorage;
  private final Invoker invoker;

  public DefaultRestStoreFactory(
      @NonNull StoreSettingStorage storeSettingStorage,
      @NonNull Invoker invoker) {
    this.storeSettingStorage = storeSettingStorage;
    this.invoker = invoker;
  }

  @Override
  public RestStore getStore(String storeDomain) {
    StoreSetting credential = storeSettingStorage.getStoreSetting(storeDomain);
    checkNotNull(credential, "No Credential for " + storeDomain);

    return new DefaultRestStore(credential, invoker);
  }
}
