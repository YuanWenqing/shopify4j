package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.core.auth.PrivateAppAdminAccessTokenProvider;
import codemeans.shopify4j.core.store.CachedStoreFactory;
import codemeans.shopify4j.core.store.MemoryStoreSettingStorage;
import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.graphql.GraphqlInvoker;
import codemeans.shopify4j.graphql.OkHttpGraphqlInvoker;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class ContextForTest {

  public static final Properties PROPERTIES = new Properties();
  public static final StoreSetting STORE_SETTING = loadTestStore();
  public static final MemoryStoreSettingStorage STORE_SETTING_STORAGE = new MemoryStoreSettingStorage();

  static {
    STORE_SETTING_STORAGE.registerStore(STORE_SETTING);
  }

  public static final GraphqlInvoker INVOKER = OkHttpGraphqlInvoker.admin(
      new PrivateAppAdminAccessTokenProvider(STORE_SETTING_STORAGE));
  public static final StoreFactory<GraphqlAdmin> FACTORY = CachedStoreFactory
      .of(new GraphqlAdminFactory(INVOKER));
  public static final GraphqlAdmin TEST_STORE = FACTORY
      .getStore(STORE_SETTING.getMyshopifyDomain());

  private static StoreSetting loadTestStore() {
    File workdir = new File(System.getProperty("user.dir")).getParentFile();
    File propertiesFile = new File(workdir, "test.properties");
    try (FileInputStream inputStream = new FileInputStream(propertiesFile)) {
      PROPERTIES.load(inputStream);
      return StoreSetting.fromProperties(PROPERTIES);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
