package codemeans.shopify4j.admin.rest.internal;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public interface ShopifyEnum<T extends Enum<T>> {

  /**
   * valid value for shopify api, default is lowercase of name
   */
  @SuppressWarnings("unchecked")
  default String shopifyValue() {
    Enum<T> tEnum = (Enum<T>) this;
    return tEnum.name().toLowerCase();
  }

  static <T extends Enum<T> & ShopifyEnum> T asEnum(String value, Class<T> enumType) {
    for (T t : EnumUtils.getEnumList(enumType)) {
      if (StringUtils.equals(value, t.shopifyValue())) {
        return t;
      }
    }
    return null;
  }
}
