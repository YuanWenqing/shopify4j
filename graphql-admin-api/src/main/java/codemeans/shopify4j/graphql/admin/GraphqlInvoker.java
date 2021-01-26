package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.graphql.admin.exception.GraphqlApiException;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public interface GraphqlInvoker {

  String request(String endpoint, String requestBody) throws GraphqlApiException;
}
