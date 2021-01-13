package codemeans.shopify4j.core.http;

import codemeans.shopify4j.core.exception.SerializingException;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import lombok.NonNull;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class JsonCodec implements ICodec {

  public static final JsonCodec DEFAULT_INSTANCE = new JsonCodec();

  private final ObjectMapper ROOT_WRAPPING = new ObjectMapper()
      .enable(SerializationFeature.WRAP_ROOT_VALUE)
      .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .registerModule(new JodaModule());
  private final ObjectMapper ROOT_UNWRAPPING = new ObjectMapper()
      .disable(SerializationFeature.WRAP_ROOT_VALUE)
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
}
