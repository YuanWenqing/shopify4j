package codemeans.shopify4j.core.jackson;

import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.core.exception.SerializingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public class TestJacksonCodec {

  private final JacksonCodec codec = JacksonCodec.DEFAULT_INSTANCE;

  @Test
  public void testProduct() throws IOException, SerializingException {
    String string = IOUtils.resourceToString("sample/product.json", StandardCharsets.UTF_8,
        this.getClass().getClassLoader());
    Product product = codec.deserialize(Product.class, string);
    System.out.println(product);
  }
}
