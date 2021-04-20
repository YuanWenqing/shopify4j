package codemeans.shopify4j.core.base;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface ClientFactory<C> {

  /**
   * @param clientHandle myshopify domain for storefront and admin api, organizationId for partner
   * api
   */
  C getClient(String clientHandle);

}
