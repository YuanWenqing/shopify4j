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
public interface GraphqlAdmin {

  String getMyshopifyDomain();

  String getApiVersion();

  String getGraphqlEndpoint();

  /**
   * 原始请求
   */
  String request(String query) throws GraphqlApiException;

  QueryResponse query(QueryRootQuery query) throws GraphqlApiException;

  MutationResponse mutation(MutationQuery query) throws GraphqlApiException;

}
