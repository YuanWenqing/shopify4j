package codemeans.shopify4j.admin.rest.sdk;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * delegate to another {@link StoreFactory} and cache created {@link Store}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedStoreFactory implements StoreFactory {

  private final StoreFactory delegate;

  private final Map<String, Store> storeMap = Maps.newConcurrentMap();

  private CachedStoreFactory(StoreFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public Store createStore(String storeDomain) {
    if (!storeMap.containsKey(storeDomain)) {
      synchronized (storeDomain.intern()) {
        if (!storeMap.containsKey(storeDomain)) {
          Store store = delegate.createStore(storeDomain);
          storeMap.put(storeDomain, store);
        }
      }
    }
    return storeMap.get(storeDomain);
  }

  public static CachedStoreFactory of(StoreFactory storeFactory) {
    return new CachedStoreFactory(storeFactory);
  }
}
