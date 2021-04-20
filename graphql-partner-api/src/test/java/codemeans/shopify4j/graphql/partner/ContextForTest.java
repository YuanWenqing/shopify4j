package codemeans.shopify4j.graphql.partner;

import codemeans.shopify4j.core.auth.AccessTokenProvider;
import codemeans.shopify4j.core.base.CachedClientFactory;
import codemeans.shopify4j.core.base.ClientFactory;
import codemeans.shopify4j.graphql.GraphqlInvoker;
import codemeans.shopify4j.graphql.OkHttpGraphqlInvoker;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: yuanwq
 * @date: 2021-04-20
 */
public class ContextForTest {

  public static final Properties PROPERTIES = loadProperties();

  public static final GraphqlInvoker INVOKER = OkHttpGraphqlInvoker.partner(
      AccessTokenProvider.constant(PROPERTIES.getProperty("partner.access-token")));
  public static final ClientFactory<GraphqlPartner> FACTORY = CachedClientFactory
      .of(new GraphqlPartnerFactory(INVOKER));
  public static final GraphqlPartner PARTNER = FACTORY
      .getClient(PROPERTIES.getProperty("partner.organization-id"));


  private static Properties loadProperties() {
    File workdir = new File(System.getProperty("user.dir")).getParentFile();
    File propertiesFile = new File(workdir, "test.properties");
    try (FileInputStream inputStream = new FileInputStream(propertiesFile)) {
      Properties properties = new Properties();
      properties.load(inputStream);
      return properties;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
