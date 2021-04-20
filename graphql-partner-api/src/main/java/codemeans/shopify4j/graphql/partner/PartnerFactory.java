package codemeans.shopify4j.graphql.partner;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface PartnerFactory<P> {

  P getPartner(String organizationId);

}
