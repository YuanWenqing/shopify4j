package codemeans.shopify4j.core.store;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public interface StoreSettingStorage {

  StoreSetting getStoreSetting(String myshopifyDomain);

}
