package codemeans.shopify4j.core;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public interface StoreSettingStorage {

  StoreSetting getStoreSetting(String storeDomain);

}
