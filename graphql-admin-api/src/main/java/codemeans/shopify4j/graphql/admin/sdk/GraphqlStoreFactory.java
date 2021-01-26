package codemeans.shopify4j.graphql.admin.sdk;


import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class GraphqlStoreFactory implements StoreFactory<GraphqlStore> {

  private final StoreSettingStorage storeSettingStorage;

  public GraphqlStoreFactory(@NonNull StoreSettingStorage storeSettingStorage) {
    this.storeSettingStorage = storeSettingStorage;
  }

  @Override
  public GraphqlStore getStore(String storeDomain) {
    StoreSetting setting = storeSettingStorage.getStoreSetting(storeDomain);
    if (setting == null) {
      throw new IllegalArgumentException("No Credential for " + storeDomain);
    }
    return new DefaultGraphqlStore(setting);
  }
}
