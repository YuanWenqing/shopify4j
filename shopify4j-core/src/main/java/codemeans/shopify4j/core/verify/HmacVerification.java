package codemeans.shopify4j.core.verify;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class HmacVerification {

  /**
   * https://shopify.dev/tutorials/authenticate-with-oauth#verification
   */
  public static boolean verifyQueryString(String clientSecret, String queryString) {
    Map<String, String> map = splitQueryString(queryString);
    String hmac = map.remove("hmac");
    queryString = joinQueryString(map);
    String digest = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, clientSecret).hmacHex(queryString);
    return StringUtils.equalsIgnoreCase(digest, hmac);
  }

  private static String joinQueryString(Map<String, String> map) {
    if (map.isEmpty()) {
      return StringUtils.EMPTY;
    }
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      builder.append(entry.getKey())
          .append("=")
          .append(entry.getValue())
          .append("&");
    }
    return builder.substring(0, builder.length() - 1);
  }

  private static LinkedHashMap<String, String> splitQueryString(String queryString) {
    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    for (String part : queryString.split("&")) {
      String[] arr = part.split("=", 2);
      String key = arr[0];
      String value = arr.length > 1 ? arr[1] : StringUtils.EMPTY;
      map.put(key, value);
    }
    return map;
  }

  /**
   * https://shopify.dev/tutorials/manage-webhooks#verifying-webhooks
   */
  public static boolean verifyWebhookEvent(String clientSecret, String eventData, String hmac) {
    byte[] bytes = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, clientSecret).hmac(eventData);
    String digest = Base64.encodeBase64String(bytes);
    return StringUtils.equalsIgnoreCase(digest, hmac);
  }
}
