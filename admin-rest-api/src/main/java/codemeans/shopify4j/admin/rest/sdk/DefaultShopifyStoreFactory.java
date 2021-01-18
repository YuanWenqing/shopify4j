package codemeans.shopify4j.admin.rest.sdk;

import static codemeans.shopify4j.admin.rest.model.Utils.checkNotNull;

import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class DefaultShopifyStoreFactory implements ShopifyStoreFactory {

  private final StoreSettingStorage storeSettingStorage;
  private final Invoker invoker;

  public DefaultShopifyStoreFactory(
      @NonNull StoreSettingStorage storeSettingStorage,
      @NonNull Invoker invoker) {
    this.storeSettingStorage = storeSettingStorage;
    this.invoker = invoker;
  }

  @Override
  public ShopifyStore getStore(String storeDomain) {
    StoreSetting credential = storeSettingStorage.getStoreSetting(storeDomain);
    checkNotNull(credential, "No Credential for " + storeDomain);

    return new DefaultShopifyStore(credential, invoker);
  }
}
