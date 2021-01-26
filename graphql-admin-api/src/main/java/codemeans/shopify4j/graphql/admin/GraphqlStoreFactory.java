package codemeans.shopify4j.graphql.admin;


import codemeans.shopify4j.core.store.StoreFactory;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class GraphqlStoreFactory implements StoreFactory<GraphqlStore> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-01";

  public GraphqlStoreFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlStore getStore(String storeDomain) {
    return new DefaultGraphqlStore(storeDomain, apiVersion, graphqlInvoker);
  }
}
