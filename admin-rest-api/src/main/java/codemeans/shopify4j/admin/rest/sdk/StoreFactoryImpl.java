package codemeans.shopify4j.admin.rest.sdk;

import codemeans.shopify4j.admin.rest.auth.StoreCredentialStorage;
import codemeans.shopify4j.admin.rest.http.ICodec;
import codemeans.shopify4j.admin.rest.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class StoreFactoryImpl implements StoreFactory {

  private final StoreCredentialStorage credentialStorage;
  private final Invoker invoker;
  private final ICodec codec;

  public StoreFactoryImpl(StoreCredentialStorage credentialStorage,
      Invoker invoker, ICodec codec) {
    this.credentialStorage = credentialStorage;
    this.invoker = invoker;
    this.codec = codec;
  }

  @Override
  public Store createStore(String storeDomain) {
    // todo
    return null;
  }
}
