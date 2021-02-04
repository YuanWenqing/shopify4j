package codemeans.shopify4j.graphql.admin.exception;

import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import codemeans.shopify4j.graphql.admin.types.UserError;
import java.util.List;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-02-04
 */
public class GraphqlAdminUserErrorException extends GraphqlAdminMutationException {

  @Getter
  private List<UserError> userErrors;

  public GraphqlAdminUserErrorException(MutationQuery query,
      MutationResponse response, List<UserError> userErrors) {
    super(query, response);
    this.userErrors = userErrors;
  }
}
