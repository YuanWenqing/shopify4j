package codemeans.shopify4j.graphql.admin.products;

import static codemeans.shopify4j.graphql.admin.ContextForTest.TEST_STORE;

import codemeans.shopify4j.core.exception.GraphqlApiException;
import codemeans.shopify4j.graphql.admin.types.ImageInput;
import codemeans.shopify4j.graphql.admin.types.MutationQuery;
import codemeans.shopify4j.graphql.admin.types.MutationResponse;
import codemeans.shopify4j.graphql.admin.types.Operations;
import codemeans.shopify4j.graphql.admin.types.Product;
import codemeans.shopify4j.graphql.admin.types.ProductConnection;
import codemeans.shopify4j.graphql.admin.types.ProductInput;
import codemeans.shopify4j.graphql.admin.types.ProductVariantInput;
import codemeans.shopify4j.graphql.admin.types.QueryResponse;
import codemeans.shopify4j.graphql.admin.types.QueryRootQuery;
import com.google.gson.Gson;
import com.shopify.graphql.support.ID;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
public class TestProduct {

  static final Gson GSON = new Gson();

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

    queryRootQuery = Operations.query(query -> query
        .product(id, product -> product
            .title()
            .handle()
            .description()
            .images(args -> args.first(100), images -> images
                .edges(edges -> edges
                    .node(node -> node
                        .id()
                        .originalSrc()
                        .transformedSrc()
                    )
                )
            )
        )
    );
    Product product = TEST_STORE.query(queryRootQuery).getData().getProduct();
    System.out.println(GSON.toJson(product));
  }

  @Test
  public void testProductCreate() throws GraphqlApiException {
    List<ImageInput> imageInputList = new ArrayList<>();
    imageInputList.add(new ImageInput()
        .setSrc("https://use-img.prefercdn.com/common/f8e/279/57937cfd36c81486c3f522410e"));
    imageInputList.add(new ImageInput()
        .setSrc("https://use-img.prefercdn.com/common/ab8/58d/c5f5389fbf6e07579ca99e7ecd"));
    imageInputList.add(new ImageInput()
        .setSrc("https://use-img.prefercdn.com/common/496/55a/6a925eacb95d0460a9b8ba12e4"));
    imageInputList.add(new ImageInput()
        .setSrc("https://use-img.prefercdn.com/common/293/d1a/f86a52c3883cbd1979a23647c4"));
    List<ProductVariantInput> variantInputs = new ArrayList<>();
    variantInputs.add(new ProductVariantInput()
        .setOptions(Collections.singletonList("S"))
        .setImageSrc(imageInputList.get(variantInputs.size()).getSrc()));
    variantInputs.add(new ProductVariantInput()
        .setOptions(Collections.singletonList("M"))
        .setImageSrc(imageInputList.get(variantInputs.size()).getSrc()));
    variantInputs.add(new ProductVariantInput()
        .setOptions(Collections.singletonList("L"))
        .setImageSrc(imageInputList.get(variantInputs.size()).getSrc()));
    variantInputs.add(new ProductVariantInput()
        .setOptions(Collections.singletonList("XL"))
        .setImageSrc(imageInputList.get(variantInputs.size()).getSrc()));
    ProductInput productInput = new ProductInput()
        .setTitle(getClass().getSimpleName() + DateTime.now())
        .setImages(imageInputList)
        .setOptions(Collections.singletonList("Size"))
        .setVariants(variantInputs);
    MutationQuery mutationQuery = Operations.mutation(mutation -> mutation
        .productCreate(productInput, query -> query
            .product(product -> product
                .title()
                .totalVariants()
                .options(options -> options
                    .name()
                    .position()
                    .values()
                )
                .images(args -> args.first(10), images -> images
                    .edges(edges -> edges
                        .node(node -> node
                            .id()
                            .originalSrc()
                            .transformedSrc()
                            .height()
                            .width()
                        )
                    )
                )
                .variants(args -> args.first(10), variants -> variants
                    .edges(edges -> edges
                        .node(node -> node
                            .selectedOptions(options -> options
                                .name()
                                .value()
                            )
                            .image(image -> image
                                .id()
                                .originalSrc()
                                .transformedSrc()
                                .height()
                                .width()
                            )
                        )
                    )
                )
            )
            .userErrors(errors -> errors
                .field()
                .message()
            )
        )
    );

    MutationResponse response = TEST_STORE.mutation(mutationQuery);
    System.out.println(response.prettyPrintJson());
  }
}
