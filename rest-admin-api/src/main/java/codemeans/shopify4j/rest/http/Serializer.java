package codemeans.shopify4j.rest.http;

import codemeans.shopify4j.rest.exception.SerializingException;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface Serializer {

  String serialize(Object o) throws SerializingException;
}
