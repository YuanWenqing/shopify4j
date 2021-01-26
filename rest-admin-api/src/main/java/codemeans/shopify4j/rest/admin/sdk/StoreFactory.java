package codemeans.shopify4j.rest.admin.sdk;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface StoreFactory<S> {

  S getStore(String storeDomain);

}
