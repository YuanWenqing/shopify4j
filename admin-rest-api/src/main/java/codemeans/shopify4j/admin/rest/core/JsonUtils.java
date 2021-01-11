package codemeans.shopify4j.admin.rest.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class JsonUtils {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .enable(SerializationFeature.WRAP_ROOT_VALUE)
      .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .registerModule(new JodaModule());
}
