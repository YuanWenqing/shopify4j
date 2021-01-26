package codemeans.shopify4j.graphql.admin.sdk;

import codemeans.shopify4j.core.store.StoreSetting;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public interface GraphqlStore {

  StoreSetting getStoreSetting();

  String getGraphqlEndpoint();
}
