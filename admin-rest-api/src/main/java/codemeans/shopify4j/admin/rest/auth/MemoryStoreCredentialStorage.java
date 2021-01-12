package codemeans.shopify4j.admin.rest.auth;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class MemoryStoreCredentialStorage implements StoreCredentialStorage {

  private Map<String, StoreCredential> credentialMap;

  public MemoryStoreCredentialStorage(Map<String, StoreCredential> credentialMap) {
    this.credentialMap = credentialMap;
  }

  public MemoryStoreCredentialStorage() {
    this(Maps.newConcurrentMap());
  }

  public MemoryStoreCredentialStorage registerStore(StoreCredential credential) {
    credentialMap.put(credential.getStoreDomain(), credential);
    return this;
  }

  @Override
  public StoreCredential getCredential(String storeDomain) {
    return credentialMap.get(storeDomain);
  }

}
