package codemeans.shopify4j.core.jackson;

import codemeans.shopify4j.core.exception.IllegalDefinitionException;
import codemeans.shopify4j.core.exception.SerializingException;
import codemeans.shopify4j.core.http.ICodec;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class JacksonCodec implements ICodec {

  private static final String COMMA = ",";

  public static final JacksonCodec DEFAULT_INSTANCE = new JacksonCodec();

  private final ObjectMapper ROOT_WRAPPING = new ObjectMapper()
      .enable(SerializationFeature.WRAP_ROOT_VALUE)
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .registerModule(new JodaModule());
  private final ObjectMapper ROOT_UNWRAPPING = new ObjectMapper()
      .disable(SerializationFeature.WRAP_ROOT_VALUE)
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .disable(DeserializationFeature.UNWRAP_ROOT_VALUE)
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .registerModule(new JodaModule());

  @Override
  public String serialize(@NonNull Object o) throws SerializingException {
    try {
      return getObjectMapper(o.getClass()).writeValueAsString(o);
    } catch (JsonProcessingException e) {
      throw new SerializingException("fail to serialize: " + o, e);
    }
  }

  private ObjectMapper getObjectMapper(Class<?> type) {
    JsonRootName jsonRootName = type.getAnnotation(JsonRootName.class);
    if (jsonRootName != null) {
      return ROOT_WRAPPING;
    }
    return ROOT_UNWRAPPING;
  }

  @Override
  public <T> T deserialize(Class<T> type, String str) throws SerializingException {
    try {
      return getObjectMapper(type).readValue(str, type);
    } catch (JsonProcessingException e) {
      throw new SerializingException("fail to deserialize, type=" + type + ", str: " + str, e);
    }
  }

  @Override
  public Map<String, String> asQueryMap(Object req) {
    Map<String, String> map = new LinkedHashMap<>();
    JsonNode jsonNode = ROOT_UNWRAPPING.valueToTree(req);
    Iterator<Entry<String, JsonNode>> iterator = jsonNode.fields();
    while (iterator.hasNext()) {
      Entry<String, JsonNode> entry = iterator.next();
      if (entry.getValue() == null
          || entry.getValue().isNull()
          || (entry.getValue().isArray() && entry.getValue().isEmpty())) {
        continue;
      }
      String value;
      if (entry.getValue().isObject()) {
        throw new IllegalDefinitionException(entry.getKey(), entry.getValue(),
            "Unhandled Object type");
      } else if (entry.getValue().isArray()) {
        value = StringUtils.join(entry.getValue().elements(), COMMA);
      } else {
        value = entry.getValue().asText();
      }
      map.put(entry.getKey(), value);
    }
    return map;
  }
}
