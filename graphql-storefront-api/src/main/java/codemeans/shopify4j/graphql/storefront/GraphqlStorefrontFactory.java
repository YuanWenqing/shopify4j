package codemeans.shopify4j.graphql.storefront;


import codemeans.shopify4j.core.graphql.GraphqlInvoker;
import codemeans.shopify4j.core.store.StoreFactory;
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
}
