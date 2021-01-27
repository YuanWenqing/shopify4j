package codemeans.shopify4j.rest.admin.api;

import codemeans.shopify4j.core.exception.RestApiException;

/**
 * @author: yuanwq
 * @date: 2021-01-14
 */
public interface Pipeline<API, R> {

  /**
   * @return type of final returned value
   */
  Class<R> typeOfR();

  R runWith(API api) throws RestApiException;
}
