package codemeans.shopify4j.admin.rest.http;

import codemeans.shopify4j.admin.rest.exception.SerializingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class JsonCodec implements Serializer, Deserializer {

  private final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .enable(SerializationFeature.WRAP_ROOT_VALUE)
      .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .registerModule(new JodaModule());

  @Override
  public String serialize(Object o) throws SerializingException {
    try {
      return OBJECT_MAPPER.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      throw new SerializingException("fail to serialize: " + o, e);
    }
  }

  @Override
  public <T> T deserialize(Class<T> type, String str) throws SerializingException {
    try {
      return OBJECT_MAPPER.readValue(str, type);
    } catch (JsonProcessingException e) {
      throw new SerializingException("fail to deserialize, type=" + type + ", str: " + str, e);
    }
  }
}
