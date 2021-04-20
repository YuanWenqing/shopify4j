package codemeans.shopify4j.graphql.partner.apps;

import static codemeans.shopify4j.graphql.partner.ContextForTest.PARTNER;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.partner.types.Operations;
import codemeans.shopify4j.graphql.partner.types.QueryResponse;
import codemeans.shopify4j.graphql.partner.types.QueryRootQuery;
import com.shopify.graphql.support.ID;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-04-20
 */
public class TestApp {

  @Test
  public void testGetApp() throws GraphqlApiException {
    QueryRootQuery queryRootQuery = Operations.query(query -> query
        .app(new ID("gid://partners/App/4877699"), app -> app
            .name()
            .apiKey()
            .events(args -> args.first(10), events -> events
                .edges(edges -> edges
                    .node(node -> node
                        .occurredAt()
                        .type()
                        .shop(shop -> shop
                            .name()
                            .avatarUrl()
                            .myshopifyDomain()
                        )
                    )
                )
            )
        )
    );
    System.out.println(queryRootQuery.toString());
    QueryResponse queryResponse = PARTNER.query(queryRootQuery);
    System.out.println(queryResponse.prettyPrintJson());

  }
}
