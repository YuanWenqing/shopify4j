package codemeans.shopify4j.graphql.storefront;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.storefront.types.MutationQuery;
import codemeans.shopify4j.graphql.storefront.types.MutationResponse;
import codemeans.shopify4j.graphql.storefront.types.QueryResponse;
import codemeans.shopify4j.graphql.storefront.types.QueryRootQuery;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public interface GraphqlStorefront {

  String getMyshopifyDomain();

  String getApiVersion();

  String getGraphqlEndpoint();

  QueryResponse query(QueryRootQuery query) throws GraphqlApiException;

  MutationResponse mutation(MutationQuery query) throws GraphqlApiException;

}
