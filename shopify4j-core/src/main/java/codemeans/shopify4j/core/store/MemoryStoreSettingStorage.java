package codemeans.shopify4j.core.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class MemoryStoreSettingStorage implements StoreSettingStorage {

  private Map<String, StoreSetting> storeSettingMap;

  public MemoryStoreSettingStorage(Map<String, StoreSetting> storeSettingMap) {
    this.storeSettingMap = storeSettingMap;
  }

  public MemoryStoreSettingStorage() {
    this(new ConcurrentHashMap<>());
  }

  public MemoryStoreSettingStorage registerStore(StoreSetting storeSetting) {
    storeSettingMap.put(storeSetting.getMyshopifyDomain(), storeSetting);
    return this;
  }

  @Override
  public StoreSetting getStoreSetting(String myshopifyDomain) {
    return storeSettingMap.get(myshopifyDomain);
  }

}
