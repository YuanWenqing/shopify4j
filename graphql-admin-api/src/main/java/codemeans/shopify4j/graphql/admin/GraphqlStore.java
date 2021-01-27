package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import codemeans.shopify4j.graphql.admin.types.QueryResponse;
import codemeans.shopify4j.graphql.admin.types.QueryRootQuery;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public interface GraphqlStore {

  String getMyshopifyDomain();

  String getApiVersion();

  String getGraphqlEndpoint();

  QueryResponse query(QueryRootQuery query) throws GraphqlApiException;

  MutationResponse mutation(MutationQuery query) throws GraphqlApiException;

}
