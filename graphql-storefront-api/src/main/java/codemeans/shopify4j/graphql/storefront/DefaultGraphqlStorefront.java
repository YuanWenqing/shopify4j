package codemeans.shopify4j.graphql.storefront;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.core.graphql.GraphqlInvoker;
import codemeans.shopify4j.graphql.storefront.exception.GraphqlStorefrontMutationException;
import codemeans.shopify4j.graphql.storefront.exception.GraphqlStorefrontQueryException;
import codemeans.shopify4j.graphql.storefront.exception.GraphqlStorefrontSchemaException;
import codemeans.shopify4j.graphql.storefront.types.MutationQuery;
import codemeans.shopify4j.graphql.storefront.types.MutationResponse;
import codemeans.shopify4j.graphql.storefront.types.QueryResponse;
import codemeans.shopify4j.graphql.storefront.types.QueryRootQuery;
import com.shopify.graphql.support.SchemaViolationError;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class DefaultGraphqlStorefront implements GraphqlStorefront {

  private final String myshopifyDomain;
  private final String apiVersion;
  private final String graphqlEndpoint;
  private final GraphqlInvoker invoker;

  public DefaultGraphqlStorefront(String myshopifyDomain, String apiVersion,
      GraphqlInvoker invoker) {
    this.myshopifyDomain = myshopifyDomain;
    this.apiVersion = apiVersion;
    this.graphqlEndpoint = String.format("https://%s/api/%s/graphql.json",
        myshopifyDomain, apiVersion);
    this.invoker = invoker;
  }

  @Override
  public String getMyshopifyDomain() {
    return myshopifyDomain;
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public String getGraphqlEndpoint() {
    return graphqlEndpoint;
  }

  @Override
  public String request(String query) throws GraphqlApiException {
    return invoker.request(graphqlEndpoint, query);
  }

  @Override
  public QueryResponse query(QueryRootQuery query) throws GraphqlApiException {
    String resp = null;
    try {
      String queryBody = query.toString();
      resp = invoker.request(graphqlEndpoint, queryBody);
      QueryResponse response = QueryResponse.fromJson(resp);
      if (response.getErrors() != null && !response.getErrors().isEmpty()) {
        throw new GraphqlStorefrontQueryException(query, response);
      }
      return response;
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlStorefrontSchemaException(query, resp, schemaViolationError);
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
        throw new GraphqlStorefrontMutationException(query, response);
      }
      return response;
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlStorefrontSchemaException(query, resp, schemaViolationError);
    }
  }
}
