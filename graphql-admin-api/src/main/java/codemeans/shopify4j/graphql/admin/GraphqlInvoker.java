package codemeans.shopify4j.graphql.admin;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public interface GraphqlInvoker {

  String request(String endpoint, String query) throws GraphqlApiException;
}
