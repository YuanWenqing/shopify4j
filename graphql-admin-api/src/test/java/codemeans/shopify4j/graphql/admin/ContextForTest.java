package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.core.auth.PrivateAppAdminAccessTokenProvider;
import codemeans.shopify4j.core.graphql.GraphqlInvoker;
import codemeans.shopify4j.core.graphql.OkHttpGraphqlInvoker;
import codemeans.shopify4j.core.store.CachedStoreFactory;
import codemeans.shopify4j.core.store.MemoryStoreSettingStorage;
import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.core.store.StoreSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class ContextForTest {

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
    File propertiesFile = new File(workdir, "store.properties");
    try (FileInputStream inputStream = new FileInputStream(propertiesFile)) {
      return StoreSetting.load(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
