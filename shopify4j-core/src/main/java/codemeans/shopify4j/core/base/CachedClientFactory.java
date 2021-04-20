package codemeans.shopify4j.core.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;

/**
 * delegate to another {@link ClientFactory} and cache created {@code Client}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedClientFactory<C> implements ClientFactory<C> {

  @Getter
  private final ClientFactory<C> delegate;

  private final Map<String, C> clientMap = new ConcurrentHashMap<>();

  protected CachedClientFactory(ClientFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public C getClient(String clientHandle) {
    if (!clientMap.containsKey(clientHandle)) {
      synchronized (clientHandle.intern()) {
        if (!clientMap.containsKey(clientHandle)) {
          C client = delegate.getClient(clientHandle);
          clientMap.put(clientHandle, client);
        }
      }
    }
    return clientMap.get(clientHandle);
  }

  public static <S> CachedClientFactory<S> of(ClientFactory<S> clientFactory) {
    return new CachedClientFactory<>(clientFactory);
  }
}
