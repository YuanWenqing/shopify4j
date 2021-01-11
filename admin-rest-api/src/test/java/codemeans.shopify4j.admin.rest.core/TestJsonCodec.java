package codemeans.shopify4j.admin.rest.core;

import codemeans.shopify4j.admin.rest.exception.SerializingException;
import codemeans.shopify4j.admin.rest.model.products.Product;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class TestJsonCodec {

  private final JsonCodec codec = new JsonCodec();

  @Test
  public void testProduct() throws IOException, SerializingException {
    String string = IOUtils.resourceToString("sample/product.json", StandardCharsets.UTF_8,
        this.getClass().getClassLoader());
    Product product = codec.deserialize(Product.class, string);
    System.out.println(product);
  }
}
