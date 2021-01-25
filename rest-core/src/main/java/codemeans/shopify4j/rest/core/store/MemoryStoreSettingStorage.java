package codemeans.shopify4j.rest.core.store;

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
    storeSettingMap.put(storeSetting.getStoreDomain(), storeSetting);
    return this;
  }

  @Override
  public StoreSetting getStoreSetting(String storeDomain) {
    return storeSettingMap.get(storeDomain);
  }

}