package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.auth.StoreCredentialStorage;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class StoreFactoryImpl implements StoreFactory {

  private final StoreCredentialStorage credentialStorage;

  public StoreFactoryImpl(StoreCredentialStorage credentialStorage) {
    this.credentialStorage = credentialStorage;
  }

  @Override
  public Store createStore(String storeDomain) {
    // todo
    return null;
  }
}
