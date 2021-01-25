package codemeans.shopify4j.rest.core.store;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public interface AccessTokenProvider {

  String getAccessToken(String storeDomain);

  static AccessTokenProvider constant(String accessToken) {
    return storeDomain -> accessToken;
  }
}
