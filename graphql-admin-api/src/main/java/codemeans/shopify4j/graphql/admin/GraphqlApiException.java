package codemeans.shopify4j.graphql.admin;

import com.shopify.graphql.support.Query;
import com.shopify.graphql.support.SchemaViolationError;
import lombok.Getter;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class GraphqlApiException extends Exception {

  @Getter
  private Query query;

  public GraphqlApiException() {
  }

  public GraphqlApiException(String message) {
    super(message);
  }

  public GraphqlApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public GraphqlApiException(Throwable cause) {
    super(cause);
  }

  public GraphqlApiException(Query query, SchemaViolationError schemaViolationError) {
    this("Query: " + query + ", Error: " + schemaViolationError.getMessage(),
        schemaViolationError);
    this.query = query;
  }
}
