package codemeans.shopify4j.graphql.admin.exception;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.QueryResponse;
import codemeans.shopify4j.graphql.admin.types.QueryRootQuery;
import com.shopify.graphql.support.Error;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlAdminQueryException extends GraphqlApiException {

  @Getter
  private QueryRootQuery query;
  @Getter
  private QueryResponse response;
  @Getter
  private List<Error> errors;

  public GraphqlAdminQueryException(QueryRootQuery query, QueryResponse response) {
    super("Query: " + query + ", Response: " + response.toJson());
    this.query = query;
    this.response = response;
    this.errors = response.getErrors() != null ? response.getErrors() : Collections.emptyList();
  }
}
