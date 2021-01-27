package codemeans.shopify4j.graphql.admin.products;

import static codemeans.shopify4j.graphql.admin.ContextForTest.TEST_STORE;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.Operations;
import codemeans.shopify4j.graphql.admin.types.Product;
import codemeans.shopify4j.graphql.admin.types.ProductConnection;
import codemeans.shopify4j.graphql.admin.types.QueryResponse;
import codemeans.shopify4j.graphql.admin.types.QueryRootQuery;
import com.google.gson.Gson;
import com.shopify.graphql.support.ID;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class TestProduct {

  @Test
  public void testListProducts() throws GraphqlApiException {
    QueryRootQuery queryRootQuery = Operations.query(query ->
        query.products(args -> args.first(10),
            products -> products
                .edges(edges -> edges.node(node -> node.title()))
                .pageInfo(pageInfo -> pageInfo.hasNextPage()))
    );
    QueryResponse queryResponse = TEST_STORE.query(queryRootQuery);
    System.out.println(queryResponse.prettyPrintJson());
    ProductConnection data = queryResponse.getData().getProducts();
    System.out.println(data.responseData);

    ID id = data.getEdges().get(0).getNode().getId();

    queryRootQuery = Operations.query(query ->
        query.product(id, product ->
            product.title()
                .handle()
                .description()
                .images(args -> args.first(100),
                    images -> images.edges(edges ->
                        edges.node(node ->
                            node.id()
                                .originalSrc()
                                .transformedSrc())))));
    Product product = TEST_STORE.query(queryRootQuery).getData().getProduct();
    System.out.println(new Gson().toJson(product));
  }
}
