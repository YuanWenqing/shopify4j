package codemeans.shopify4j.graphql.partner;

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
public class GraphqlPartnerFactory implements ClientFactory<GraphqlPartner> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-04";

  public GraphqlPartnerFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlPartner getClient(String organizationId) {
    return new DefaultGraphqlPartner(organizationId, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlPartnerFactory cached() {
    return new CachedGraphqlPartnerFactory(this);
  }

  public static class CachedGraphqlPartnerFactory extends CachedClientFactory<GraphqlPartner> {

    protected CachedGraphqlPartnerFactory(ClientFactory delegate) {
      super(delegate);
    }
  }

}
