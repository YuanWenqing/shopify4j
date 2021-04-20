package codemeans.shopify4j.graphql.partner;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.partner.types.QueryResponse;
import codemeans.shopify4j.graphql.partner.types.QueryRootQuery;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public interface GraphqlPartner {

  String getOrganizationId();

  String getApiVersion();

  String getGraphqlEndpoint();

  /**
   * 原始请求
   */
  String request(String query) throws GraphqlApiException;

  QueryResponse query(QueryRootQuery query) throws GraphqlApiException;

}
