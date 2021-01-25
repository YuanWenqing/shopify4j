package codemeans.shopify4j.admin.rest.sdk;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface ShopifyStoreFactory {

  ShopifyStore getStore(String storeDomain);

}
