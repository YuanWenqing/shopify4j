package codemeans.shopify4j.graphql.admin.exception;

import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlMutationException extends GraphqlApiException {

  @Getter
  private MutationQuery query;
  @Getter
  private MutationResponse response;

  public GraphqlMutationException(MutationQuery query, MutationResponse response) {
    super("Query: " + query + ", Response: " + response.toJson());
    this.query = query;
    this.response = response;
  }
}
