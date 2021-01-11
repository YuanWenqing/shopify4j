package codemeans.shopify4j.admin.rest.model.events;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface EventVerb<T extends Enum<T>> {

  @SuppressWarnings("unchecked")
  default String verb() {
    Enum<T> e = (Enum<T>) this;
    return e.name().toLowerCase();
  }

  static <T extends Enum<T> & EventVerb> T byVerb(Class<T> type, String verb) {
    if (StringUtils.isBlank(verb)) {
      return null;
    }
    for (T t : EnumUtils.getEnumList(type)) {
      if (StringUtils.equals(t.verb(), verb)) {
        return t;
      }
    }
    return null;
  }
}
