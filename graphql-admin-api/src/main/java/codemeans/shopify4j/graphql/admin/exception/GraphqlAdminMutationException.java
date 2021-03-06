package codemeans.shopify4j.graphql.admin.exception;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import com.shopify.graphql.support.Error;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlAdminMutationException extends GraphqlApiException {

  @Getter
  private MutationQuery query;
  @Getter
  private MutationResponse response;
  @Getter
  private List<Error> errors;

  public GraphqlAdminMutationException(MutationQuery query, MutationResponse response) {
    super("Query: " + query + ", Response: " + response.toJson());
    this.query = query;
    this.response = response;
    this.errors = response.getErrors() != null ? response.getErrors() : Collections.emptyList();
  }
}
