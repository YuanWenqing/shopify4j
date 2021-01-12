package codemeans.shopify4j.admin.rest.auth;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public interface StoreCredentialStorage {

  StoreCredential getCredential(String storeDomain);

}
