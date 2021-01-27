package codemeans.shopify4j.graphql.admin;


import codemeans.shopify4j.core.graphql.GraphqlInvoker;
import codemeans.shopify4j.core.store.StoreFactory;
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
}
