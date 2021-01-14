package codemeans.shopify4j.core.http;

import codemeans.shopify4j.core.exception.IllegalDefinitionException;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-14
 */
public class HttpUtil {

  public static final String APPLICATION_JSON = "application/json";

  private static final SnakeCaseStrategy QUERY_NAME_STRATEGY = (SnakeCaseStrategy) PropertyNamingStrategy.SNAKE_CASE;

  public static Map<String, String> convertAsQueryMap(Object req) {
    Map<String, String> map = new LinkedHashMap<>();
    for (Field field : req.getClass().getDeclaredFields()) {
      QueryParameter queryParameter = field.getAnnotation(QueryParameter.class);
      if (queryParameter != null && queryParameter.ignore()) {
        continue;
      }
      final String name = resolveQueryName(field);
      Object value = null;
      try {
        value = field.get(req);
      } catch (IllegalAccessException ignore) {
      }
      if (value == null) {
        continue;
      }
      map.put(name, resolveQueryValue(field, value));
    }
    return map;
  }

  private static String resolveQueryName(Field field) {
    QueryParameter queryParameter = field.getAnnotation(QueryParameter.class);
    if (queryParameter != null && StringUtils.isNotBlank(queryParameter.name())) {
      return queryParameter.name();
    }
    return QUERY_NAME_STRATEGY.translate(field.getName());
  }

  private static String resolveQueryValue(Field field, Object value) {
    QueryParameter queryParameter = field.getAnnotation(QueryParameter.class);
    if (value instanceof Iterable) {
      if (queryParameter == null) {
        throw new IllegalDefinitionException(
            "No @QueryParameter annotated on " + field.toGenericString());
      }
      return StringUtils.join((Iterable) value, queryParameter.valueJoinWith());
    }
    return value.toString();
  }
}
