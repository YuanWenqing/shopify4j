package codemeans.shopify4j.graphql.storefront;


import codemeans.shopify4j.graphql.GraphqlInvoker;
import codemeans.shopify4j.core.base.CachedStoreFactory;
import codemeans.shopify4j.core.base.StoreFactory;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class GraphqlStorefrontFactory implements StoreFactory<GraphqlStorefront> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-01";

  public GraphqlStorefrontFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlStorefront getStore(String myshopifyDomain) {
    return new DefaultGraphqlStorefront(myshopifyDomain, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlStorefrontFactory cached() {
    return new CachedGraphqlStorefrontFactory(this);
  }

  public static class CachedGraphqlStorefrontFactory extends CachedStoreFactory<GraphqlStorefront> {

    protected CachedGraphqlStorefrontFactory(StoreFactory delegate) {
      super(delegate);
    }
  }

}
