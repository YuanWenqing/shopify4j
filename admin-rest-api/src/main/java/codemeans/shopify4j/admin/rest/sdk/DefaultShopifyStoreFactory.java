package codemeans.shopify4j.admin.rest.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import codemeans.shopify4j.admin.rest.auth.StoreCredential;
import codemeans.shopify4j.admin.rest.auth.StoreCredentialStorage;
import codemeans.shopify4j.admin.rest.http.Invoker;
import com.google.common.collect.Maps;
import java.util.Map;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class DefaultShopifyStoreFactory implements ShopifyStoreFactory {

  private final StoreCredentialStorage credentialStorage;
  private final Invoker invoker;

  private final Map<String, ShopifyStore> storeMap = Maps.newConcurrentMap();

  public DefaultShopifyStoreFactory(
      @NonNull StoreCredentialStorage credentialStorage,
      @NonNull Invoker invoker) {
    this.credentialStorage = credentialStorage;
    this.invoker = invoker;
  }

  @Override
  public ShopifyStore createStore(String storeDomain) {
    StoreCredential credential = credentialStorage.getCredential(storeDomain);
    checkNotNull(credential, "No Credential for " + storeDomain);

    return new ShopifyStoreImpl(credential, invoker);
  }
}
