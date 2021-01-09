package codemeans.shopify4j.admin.rest.model.auth;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public interface CredentialProvider {

  Credential getCredential(String storeDomain);

}
