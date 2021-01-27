package codemeans.shopify4j.core.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;

/**
 * delegate to another {@link StoreFactory} and cache created {@code Store}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedStoreFactory<S> implements StoreFactory<S> {

  @Getter
  private final StoreFactory<S> delegate;

  private final Map<String, S> storeMap = new ConcurrentHashMap<>();

  protected CachedStoreFactory(StoreFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public S getStore(String myshopifyDomain) {
    if (!storeMap.containsKey(myshopifyDomain)) {
      synchronized (myshopifyDomain.intern()) {
        if (!storeMap.containsKey(myshopifyDomain)) {
          S store = delegate.getStore(myshopifyDomain);
          storeMap.put(myshopifyDomain, store);
        }
      }
    }
    return storeMap.get(myshopifyDomain);
  }

  public static <S> CachedStoreFactory<S> of(StoreFactory<S> storeFactory) {
    return new CachedStoreFactory<>(storeFactory);
  }
}
