package codemeans.shopify4j.core.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * delegate to another {@link StoreFactory} and cache created {@code Store}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedStoreFactory<S> implements StoreFactory<S> {

  private final StoreFactory<S> delegate;

  private final Map<String, S> storeMap = new ConcurrentHashMap<>();

  private CachedStoreFactory(StoreFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public S getStore(String storeDomain) {
    if (!storeMap.containsKey(storeDomain)) {
      synchronized (storeDomain.intern()) {
        if (!storeMap.containsKey(storeDomain)) {
          S store = delegate.getStore(storeDomain);
          storeMap.put(storeDomain, store);
        }
      }
    }
    return storeMap.get(storeDomain);
  }

  public static <S> CachedStoreFactory<S> of(StoreFactory<S> storeFactory) {
    return new CachedStoreFactory<>(storeFactory);
  }
}
