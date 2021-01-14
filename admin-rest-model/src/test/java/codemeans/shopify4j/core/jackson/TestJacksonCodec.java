package codemeans.shopify4j.core.jackson;

import static junit.framework.TestCase.assertEquals;

import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.PublishedScope;
import codemeans.shopify4j.admin.rest.req.ProductCountReq;
import codemeans.shopify4j.core.exception.SerializingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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


  @Test
  public void testConvertAsQueryMap() {
    Product product = new Product()
        .setPublishedScope(PublishedScope.GLOBAL);
    Map<String, String> map = codec.asQueryMap(product);
    System.out.println(map);
    assertEquals("global", map.get("published_scope"));

    DateTime dateTime = DateTime.now();
    ProductCountReq countReq = new ProductCountReq()
        .setCreatedAtMin(dateTime);
    map = codec.asQueryMap(countReq);
    assertEquals(dateTime.withZone(DateTimeZone.UTC).toString(), map.get("created_at_min"));
    System.out.println(map);
  }
}
