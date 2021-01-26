package codemeans.shopify4j.rest.http;

import java.util.Map;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface ICodec extends Serializer, Deserializer {

  /**
   * encode Request object as a query parameter map
   */
  Map<String, String> asQueryMap(Object req);
}
