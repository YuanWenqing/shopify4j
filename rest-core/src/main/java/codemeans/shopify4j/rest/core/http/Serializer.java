package codemeans.shopify4j.rest.core.http;

import codemeans.shopify4j.rest.core.exception.SerializingException;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface Serializer {

  String serialize(Object o) throws SerializingException;
}
