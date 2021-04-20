package codemeans.shopify4j.graphql.partner;


import codemeans.shopify4j.graphql.GraphqlInvoker;
import codemeans.shopify4j.core.store.CachedStoreFactory;
import codemeans.shopify4j.core.store.StoreFactory;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class GraphqlPartnerFactory implements StoreFactory<GraphqlPartner> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-04";

  public GraphqlPartnerFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlPartner getStore(String myshopifyDomain) {
    return new DefaultGraphqlPartner(myshopifyDomain, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlPartnerFactory cached() {
    return new CachedGraphqlPartnerFactory(this);
  }

  public static class CachedGraphqlPartnerFactory extends CachedStoreFactory<GraphqlPartner> {

    protected CachedGraphqlPartnerFactory(StoreFactory delegate) {
      super(delegate);
    }
  }

}
