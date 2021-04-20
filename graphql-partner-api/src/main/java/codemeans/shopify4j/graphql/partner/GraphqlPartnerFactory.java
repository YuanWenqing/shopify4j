package codemeans.shopify4j.graphql.partner;

import codemeans.shopify4j.graphql.GraphqlInvoker;
import lombok.Data;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class GraphqlPartnerFactory implements PartnerFactory<GraphqlPartner> {

  private final GraphqlInvoker graphqlInvoker;
  private String apiVersion = "2021-04";

  public GraphqlPartnerFactory(@NonNull GraphqlInvoker graphqlInvoker) {
    this.graphqlInvoker = graphqlInvoker;
  }

  @Override
  public GraphqlPartner getPartner(String organizationId) {
    return new DefaultGraphqlPartner(organizationId, apiVersion, graphqlInvoker);
  }

  public CachedGraphqlPartnerFactory cached() {
    return new CachedGraphqlPartnerFactory(this);
  }

  public static class CachedGraphqlPartnerFactory extends CachedPartnerFactory<GraphqlPartner> {

    protected CachedGraphqlPartnerFactory(PartnerFactory delegate) {
      super(delegate);
    }
  }

}
