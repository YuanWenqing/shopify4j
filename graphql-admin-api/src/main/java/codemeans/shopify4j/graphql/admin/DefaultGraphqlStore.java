package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.core.store.StoreSetting;
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
  private final GraphqlInvoker graphqlInvoker;

  public DefaultGraphqlStore(StoreSetting storeSetting, GraphqlInvoker graphqlInvoker) {
    this.storeSetting = storeSetting;
    this.graphqlEndpoint = String.format("https://%s/admin/api/%s/graphql.json",
        storeSetting.getStoreDomain(), storeSetting.getApiVersion());
    this.graphqlInvoker = graphqlInvoker;
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
    try {
      String body = query.toString();
      String resp = graphqlInvoker.request(graphqlEndpoint, body);
      return QueryResponse.fromJson(resp);
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlApiException(query, schemaViolationError);
    }
  }

  @Override
  public MutationResponse mutation(MutationQuery query) throws GraphqlApiException {
    try {
      String body = query.toString();
      String resp = graphqlInvoker.request(graphqlEndpoint, body);
      return MutationResponse.fromJson(resp);
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlApiException(query, schemaViolationError);
    }
  }
}
