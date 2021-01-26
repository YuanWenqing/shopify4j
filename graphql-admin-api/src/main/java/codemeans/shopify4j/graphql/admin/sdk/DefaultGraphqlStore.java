package codemeans.shopify4j.graphql.admin.sdk;

import codemeans.shopify4j.core.store.StoreSetting;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class DefaultGraphqlStore implements GraphqlStore {

  private final StoreSetting storeSetting;
  private final String graphqlEndpoint;

  public DefaultGraphqlStore(StoreSetting storeSetting) {
    this.storeSetting = storeSetting;
    this.graphqlEndpoint = String.format("https://%s/admin/api/%s/graphql.json",
        storeSetting.getStoreDomain(), storeSetting.getApiVersion());
  }

  @Override
  public StoreSetting getStoreSetting() {
    return storeSetting;
  }

  @Override
  public String getGraphqlEndpoint() {
    return graphqlEndpoint;
  }
}
