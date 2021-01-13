package codemeans.shopify4j.core.store;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public interface AccessTokenProvider {

  String getAccessToken(String storeDomain);

}
