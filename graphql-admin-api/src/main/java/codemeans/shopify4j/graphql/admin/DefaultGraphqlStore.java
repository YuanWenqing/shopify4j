package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.graphql.admin.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.exception.GraphqlMutationException;
import codemeans.shopify4j.graphql.admin.exception.GraphqlQueryException;
import codemeans.shopify4j.graphql.admin.exception.GraphqlSchemaException;
import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import codemeans.shopify4j.graphql.admin.types.QueryResponse;
import codemeans.shopify4j.graphql.admin.types.QueryRootQuery;
import com.shopify.graphql.support.SchemaViolationError;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class DefaultGraphqlStore implements GraphqlStore {

  private final StoreSetting storeSetting;
  private final String graphqlEndpoint;
  private final GraphqlInvoker invoker;

  public DefaultGraphqlStore(StoreSetting storeSetting, GraphqlInvoker invoker) {
    this.storeSetting = storeSetting;
    this.graphqlEndpoint = String.format("https://%s/admin/api/%s/graphql.json",
        storeSetting.getStoreDomain(), storeSetting.getApiVersion());
    this.invoker = invoker;
  }

  @Override
  public StoreSetting getStoreSetting() {
    return storeSetting;
  }

  @Override
  public String getGraphqlEndpoint() {
    return graphqlEndpoint;
  }

  @Override
  public QueryResponse query(QueryRootQuery query) throws GraphqlApiException {
    String resp = null;
    try {
      String queryBody = query.toString();
      resp = invoker.request(graphqlEndpoint, queryBody);
      QueryResponse response = QueryResponse.fromJson(resp);
      if (response.getErrors() != null && !response.getErrors().isEmpty()) {
        throw new GraphqlQueryException(query, response);
      }
      return response;
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlSchemaException(query, resp, schemaViolationError);
    }
  }

  @Override
  public MutationResponse mutation(MutationQuery query) throws GraphqlApiException {
    String resp = null;
    try {
      String queryBody = query.toString();
      resp = invoker.request(graphqlEndpoint, queryBody);
      MutationResponse response = MutationResponse.fromJson(resp);
      if (response.getErrors() != null && !response.getErrors().isEmpty()) {
        throw new GraphqlMutationException(query, response);
      }
      return response;
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlSchemaException(query, resp, schemaViolationError);
    }
  }
}
