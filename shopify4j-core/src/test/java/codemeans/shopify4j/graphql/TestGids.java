package codemeans.shopify4j.graphql;

import static codemeans.shopify4j.graphql.Gids.gid;
import static codemeans.shopify4j.graphql.Gids.parseLegacyResourceId;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

/**
 * @author: yuanwq
 * @date: 2021-01-28
 */
public class TestGids {

  @Test
  public void testGid() {
    assertEquals("gid://shopify/Product/10079785100", gid("Product", 10079785100L));
    assertEquals("gid://shopify/String/10079785100", gid(String.class, 10079785100L));
  }

  @Test
  public void testParse() {
    assertEquals(10079785100L, parseLegacyResourceId("gid://shopify/Product/10079785100"));
  }
}
