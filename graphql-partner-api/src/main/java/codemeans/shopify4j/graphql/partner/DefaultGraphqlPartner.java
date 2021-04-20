package codemeans.shopify4j.graphql.partner;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.GraphqlInvoker;
import codemeans.shopify4j.graphql.partner.exception.GraphqlPartnerQueryException;
import codemeans.shopify4j.graphql.partner.exception.GraphqlPartnerSchemaException;
import codemeans.shopify4j.graphql.partner.types.QueryResponse;
import codemeans.shopify4j.graphql.partner.types.QueryRootQuery;
import com.shopify.graphql.support.SchemaViolationError;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class DefaultGraphqlPartner implements GraphqlPartner {

  private final String organizationId;
  private final String apiVersion;
  private final String graphqlEndpoint;
  private final GraphqlInvoker invoker;

  public DefaultGraphqlPartner(String organizationId, String apiVersion,
      GraphqlInvoker invoker) {
    this.organizationId = organizationId;
    this.apiVersion = apiVersion;
    this.graphqlEndpoint = String.format("https://partners.shopify.com//api/%s/graphql.json",
        this.organizationId, apiVersion);
    this.invoker = invoker;
  }

  @Override
  public String getOrganizationId() {
    return organizationId;
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
        throw new GraphqlPartnerQueryException(query, response);
      }
      return response;
    } catch (SchemaViolationError schemaViolationError) {
      throw new GraphqlPartnerSchemaException(query, resp, schemaViolationError);
    }
  }

}
