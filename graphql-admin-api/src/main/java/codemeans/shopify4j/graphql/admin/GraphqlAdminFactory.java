package codemeans.shopify4j.graphql.admin;


import codemeans.shopify4j.core.base.ClientFactory;
import codemeans.shopify4j.graphql.GraphqlInvoker;
import codemeans.shopify4j.core.base.CachedClientFactory;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class GraphqlAdminFactory implements ClientFactory<GraphqlAdmin> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-01";

  public GraphqlAdminFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlAdmin getClient(String myshopifyDomain) {
    return new DefaultGraphqlAdmin(myshopifyDomain, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlAdminFactory cached() {
    return new CachedGraphqlAdminFactory(this);
  }

  public static class CachedGraphqlAdminFactory extends CachedClientFactory<GraphqlAdmin> {

    protected CachedGraphqlAdminFactory(ClientFactory delegate) {
      super(delegate);
    }
  }

}
