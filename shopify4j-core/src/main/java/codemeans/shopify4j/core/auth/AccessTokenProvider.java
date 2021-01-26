package codemeans.shopify4j.core.auth;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public interface AccessTokenProvider {

  String getAccessToken(String myshopifyDomain);

  static AccessTokenProvider constant(String accessToken) {
    return myshopifyDomain -> accessToken;
  }
}
