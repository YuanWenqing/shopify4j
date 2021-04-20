package codemeans.shopify4j.graphql.storefront;


import codemeans.shopify4j.core.base.CachedClientFactory;
import codemeans.shopify4j.core.base.ClientFactory;
import codemeans.shopify4j.graphql.GraphqlInvoker;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class GraphqlStorefrontFactory implements ClientFactory<GraphqlStorefront> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-01";

  public GraphqlStorefrontFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlStorefront getClient(String myshopifyDomain) {
    return new DefaultGraphqlStorefront(myshopifyDomain, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlStorefrontFactory cached() {
    return new CachedGraphqlStorefrontFactory(this);
  }

  public static class CachedGraphqlStorefrontFactory extends
      CachedClientFactory<GraphqlStorefront> {

    protected CachedGraphqlStorefrontFactory(ClientFactory delegate) {
      super(delegate);
    }
  }

}
