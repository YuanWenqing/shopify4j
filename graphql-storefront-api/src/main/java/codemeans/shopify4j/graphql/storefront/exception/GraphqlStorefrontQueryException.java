package codemeans.shopify4j.graphql.storefront.exception;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.storefront.types.QueryResponse;
import codemeans.shopify4j.graphql.storefront.types.QueryRootQuery;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlStorefrontQueryException extends GraphqlApiException {

  @Getter
  private QueryRootQuery query;
  @Getter
  private QueryResponse response;

  public GraphqlStorefrontQueryException(QueryRootQuery query, QueryResponse response) {
    super("Query: " + query + ", Response: " + response.toJson());
    this.query = query;
    this.response = response;
  }
}
