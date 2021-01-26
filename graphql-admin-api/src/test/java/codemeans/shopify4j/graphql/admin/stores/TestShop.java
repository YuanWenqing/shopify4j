package codemeans.shopify4j.graphql.admin.stores;

import static codemeans.shopify4j.graphql.admin.ContextForTest.TEST_STORE;

import codemeans.shopify4j.graphql.admin.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.Operations;
import codemeans.shopify4j.graphql.admin.types.QueryResponse;
import codemeans.shopify4j.graphql.admin.types.QueryRootQuery;
import codemeans.shopify4j.graphql.admin.types.Shop;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class TestShop {

  @Test
  public void testGetShop() throws GraphqlApiException {
    QueryRootQuery queryRootQuery = Operations.query(query ->
        query.shop(shop ->
            shop.name()
                .myshopifyDomain()
                .primaryDomain(domain -> domain.host().sslEnabled().url())
                .email()
                .contactEmail()));
    QueryResponse queryResponse = TEST_STORE.query(queryRootQuery);
    System.out.println(queryResponse.prettyPrintJson());
    Shop shop = queryResponse.getData().getShop();
    System.out.println(shop.responseData);
  }
}
