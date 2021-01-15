package codemeans.shopify4j.admin.rest.sdk;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * delegate to another {@link ShopifyStoreFactory} and cache created {@link ShopifyStore}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedShopifyStoreFactory implements ShopifyStoreFactory {

  private final ShopifyStoreFactory delegate;

  private final Map<String, ShopifyStore> storeMap = Maps.newConcurrentMap();

  private CachedShopifyStoreFactory(ShopifyStoreFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public ShopifyStore getStore(String storeDomain) {
    if (!storeMap.containsKey(storeDomain)) {
      synchronized (storeDomain.intern()) {
        if (!storeMap.containsKey(storeDomain)) {
          ShopifyStore shopifyStore = delegate.getStore(storeDomain);
          storeMap.put(storeDomain, shopifyStore);
        }
      }
    }
    return storeMap.get(storeDomain);
  }

  public static CachedShopifyStoreFactory of(ShopifyStoreFactory storeFactory) {
    return new CachedShopifyStoreFactory(storeFactory);
  }
}
