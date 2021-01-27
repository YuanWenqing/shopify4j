package codemeans.shopify4j.graphql.storefront.exception;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import com.shopify.graphql.support.Query;
import com.shopify.graphql.support.SchemaViolationError;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlStorefrontSchemaException extends GraphqlApiException {

  @Getter
  private Query query;
  @Getter
  private SchemaViolationError schemaViolationError;

  public GraphqlStorefrontSchemaException(Query query, String resp,
      SchemaViolationError schemaViolationError) {
    super("Query: " + query + ", Resp: " + resp, schemaViolationError);
    this.query = query;
    this.schemaViolationError = schemaViolationError;
  }

}
