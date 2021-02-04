package codemeans.shopify4j.graphql.storefront.exception;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.storefront.types.MutationQuery;
import codemeans.shopify4j.graphql.storefront.types.MutationResponse;
import com.shopify.graphql.support.Error;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlStorefrontMutationException extends GraphqlApiException {

  @Getter
  private MutationQuery query;
  @Getter
  private MutationResponse response;
  @Getter
  private List<Error> errors;

  public GraphqlStorefrontMutationException(MutationQuery query, MutationResponse response) {
    super("Query: " + query + ", Response: " + response.toJson());
    this.query = query;
    this.response = response;
    this.errors = ObjectUtils.defaultIfNull(response.getErrors(), Collections.emptyList());
  }
}
