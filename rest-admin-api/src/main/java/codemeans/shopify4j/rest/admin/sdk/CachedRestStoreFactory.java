package codemeans.shopify4j.rest.admin.sdk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * delegate to another {@link RestStoreFactory} and cache created {@link RestStore}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedRestStoreFactory implements RestStoreFactory {

  private final RestStoreFactory delegate;

  private final Map<String, RestStore> storeMap = new ConcurrentHashMap<>();

  private CachedRestStoreFactory(RestStoreFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public RestStore getStore(String storeDomain) {
    if (!storeMap.containsKey(storeDomain)) {
      synchronized (storeDomain.intern()) {
        if (!storeMap.containsKey(storeDomain)) {
          RestStore restStore = delegate.getStore(storeDomain);
          storeMap.put(storeDomain, restStore);
        }
      }
    }
    return storeMap.get(storeDomain);
  }

  public static CachedRestStoreFactory of(RestStoreFactory storeFactory) {
    return new CachedRestStoreFactory(storeFactory);
  }
}
