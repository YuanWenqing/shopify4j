package codemeans.shopify4j.core.base;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface StoreFactory<S> {

  S getStore(String myshopifyDomain);

}
