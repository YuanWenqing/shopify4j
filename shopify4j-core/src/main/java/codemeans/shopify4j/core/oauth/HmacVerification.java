package codemeans.shopify4j.core.oauth;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class HmacVerification {

  /**
   * @see codemeans.shopify4j.core.verify.HmacVerification#verifyQueryString(String, String)
   * @deprecated
   */
  public static boolean verifyHmac(String queryString, String clientSecret) {
    return codemeans.shopify4j.core.verify.HmacVerification
        .verifyQueryString(clientSecret, queryString);
  }
}
