package codemeans.shopify4j.graphql.storefront.exception;

import codemeans.shopify4j.graphql.storefront.types.MutationQuery;
import codemeans.shopify4j.graphql.storefront.types.MutationResponse;
import codemeans.shopify4j.graphql.storefront.types.UserError;
import java.util.List;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-02-04
 */
public class GraphqlStorefrontUserErrorException extends GraphqlStorefrontMutationException {

  @Getter
  private List<UserError> userErrors;

  public GraphqlStorefrontUserErrorException(MutationQuery query,
      MutationResponse response, List<UserError> userErrors) {
    super(query, response);
    this.userErrors = userErrors;
  }
}
