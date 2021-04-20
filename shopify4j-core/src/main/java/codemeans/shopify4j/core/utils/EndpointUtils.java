package codemeans.shopify4j.core.utils;

import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-04-20
 */
public class EndpointUtils {

  public static String parseDomain(String endpoint) {
    HttpUrl httpUrl = HttpUrl.parse(endpoint);
    if (httpUrl == null) {
      return null;
    }
    return httpUrl.host();
  }

  public static String parsePartnerOrganizationId(String partnerEndpoint) {
    HttpUrl httpUrl = HttpUrl.parse(partnerEndpoint);
    if (httpUrl == null) {
      return null;
    }
    if (StringUtils.equalsIgnoreCase(httpUrl.host(), "partners.shopify.com")) {
      return httpUrl.pathSegments().stream()
          .findFirst()
          .orElse(null);
    }
    return null;
  }

}
