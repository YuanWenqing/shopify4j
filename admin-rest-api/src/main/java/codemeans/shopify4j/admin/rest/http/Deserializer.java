package codemeans.shopify4j.admin.rest.http;

import codemeans.shopify4j.admin.rest.exception.SerializingException;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface Deserializer {

  <T> T deserialize(Class<T> type, String str) throws SerializingException;
}
