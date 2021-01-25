package codemeans.shopify4j.rest.core.http;

import codemeans.shopify4j.rest.core.exception.SerializingException;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface Deserializer {

  <T> T deserialize(Class<T> type, String str) throws SerializingException;
}
