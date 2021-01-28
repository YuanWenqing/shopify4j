package codemeans.shopify4j.graphql;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-28
 */
public class Gids {

  /**
   * graphql gid: https://shopify.dev/docs/admin-api/graphql/reference/scalar#id-2021-01
   * <br>
   * like: gid://shopify/Product/10079785100
   *
   * @see #gid(Class, long)
   */
  public static String gid(String resourceType, long legacyResourceId) {
    return String.format("gid://shopify/%s/%s", resourceType, legacyResourceId);
  }

  /**
   * @see #gid(String, long)
   */
  public static String gid(Class<?> resourceType, long legacyResourceId) {
    return gid(resourceType.getSimpleName(), legacyResourceId);
  }

  public static long parseLegacyResourceId(String gid) {
    String id = StringUtils.substringAfterLast(gid, "/");
    return Long.parseLong(id);
  }
}
