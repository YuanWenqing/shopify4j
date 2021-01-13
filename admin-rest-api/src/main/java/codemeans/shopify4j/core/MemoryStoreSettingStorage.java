package codemeans.shopify4j.core;

import com.google.common.collect.Maps;
import java.util.Map;

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
    this(Maps.newConcurrentMap());
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
