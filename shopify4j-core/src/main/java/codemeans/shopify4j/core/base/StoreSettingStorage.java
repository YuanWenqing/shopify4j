package codemeans.shopify4j.core.base;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public interface StoreSettingStorage {

  StoreSetting getStoreSetting(String myshopifyDomain);

}
