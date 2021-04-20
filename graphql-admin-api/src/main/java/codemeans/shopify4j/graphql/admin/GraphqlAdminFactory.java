package codemeans.shopify4j.graphql.admin;


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
public class GraphqlAdminFactory implements StoreFactory<GraphqlAdmin> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-01";

  public GraphqlAdminFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlAdmin getStore(String myshopifyDomain) {
    return new DefaultGraphqlAdmin(myshopifyDomain, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlAdminFactory cached() {
    return new CachedGraphqlAdminFactory(this);
  }

  public static class CachedGraphqlAdminFactory extends CachedStoreFactory<GraphqlAdmin> {

    protected CachedGraphqlAdminFactory(StoreFactory delegate) {
      super(delegate);
    }
  }

}
