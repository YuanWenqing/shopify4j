package codemeans.shopify4j.admin.rest.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;
import codemeans.shopify4j.core.http.Invoker;
import com.google.common.collect.Maps;
import java.util.Map;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class DefaultShopifyStoreFactory implements ShopifyStoreFactory {

  private final StoreSettingStorage storeSettingStorage;
  private final Invoker invoker;

  private final Map<String, ShopifyStore> storeMap = Maps.newConcurrentMap();

  public DefaultShopifyStoreFactory(
      @NonNull StoreSettingStorage storeSettingStorage,
      @NonNull Invoker invoker) {
    this.storeSettingStorage = storeSettingStorage;
    this.invoker = invoker;
  }

  @Override
  public ShopifyStore createStore(String storeDomain) {
    StoreSetting credential = storeSettingStorage.getStoreSetting(storeDomain);
    checkNotNull(credential, "No Credential for " + storeDomain);

    return new DefaultShopifyStore(credential, invoker);
  }
}
