package codemeans.shopify4j.core.jackson;

import static junit.framework.TestCase.assertEquals;

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
    System.out.println(">>>>> product <<<<<");
    System.out.println(product);
    System.out.println(">>>>> serialize <<<<<");
    String serialized = codec.serialize(product);
    System.out.println(serialized);
    Product product2 = codec.deserialize(Product.class, serialized);
    assertEquals(product, product2);
  }
}
