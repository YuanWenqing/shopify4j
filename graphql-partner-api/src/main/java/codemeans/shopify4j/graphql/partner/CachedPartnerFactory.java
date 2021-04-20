package codemeans.shopify4j.graphql.partner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;

/**
 * delegate to another {@link PartnerFactory} and cache created {@code Partner}
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class CachedPartnerFactory<P> implements PartnerFactory<P> {

  @Getter
  private final PartnerFactory<P> delegate;

  private final Map<String, P> partnerMap = new ConcurrentHashMap<>();

  protected CachedPartnerFactory(PartnerFactory delegate) {
    this.delegate = delegate;
  }

  @Override
  public P getPartner(String organizationId) {
    if (!partnerMap.containsKey(organizationId)) {
      synchronized (organizationId.intern()) {
        if (!partnerMap.containsKey(organizationId)) {
          P partner = delegate.getPartner(organizationId);
          partnerMap.put(organizationId, partner);
        }
      }
    }
    return partnerMap.get(organizationId);
  }

  public static <P> CachedPartnerFactory<P> of(PartnerFactory<P> partnerFactory) {
    return new CachedPartnerFactory<>(partnerFactory);
  }
}
