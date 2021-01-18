package codemeans.shopify4j.admin.rest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public class Utils {

  public static final String COMMA = ",";

  public static <T> T checkNotNull(T reference, Object errorMessage) {
    if (reference == null) {
      throw new NullPointerException(String.valueOf(errorMessage));
    }
    return reference;
  }

  /**
   * @return null for null {@code tags} or a mutable list
   */
  public static List<String> splitTags(String tags) {
    if (tags == null) {
      return null;
    }
    return Arrays.stream(StringUtils.splitByWholeSeparator(tags, COMMA))
        .map(String::trim)
        .collect(Collectors.toList());
  }

  public static String joinTags(List<String> tags) {
    if (tags == null) {
      return null;
    }
    return StringUtils.join(tags, COMMA);
  }
}
