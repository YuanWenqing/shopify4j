package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.core.auth.PrivateAppAdminAccessTokenProvider;
import codemeans.shopify4j.core.store.CachedStoreFactory;
import codemeans.shopify4j.core.store.MemoryStoreSettingStorage;
import codemeans.shopify4j.core.store.PrivateApp;
import codemeans.shopify4j.core.store.StoreFactory;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.rest.http.RestInvoker;
import codemeans.shopify4j.rest.okhttp.OkHttpRestInvoker;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.commons.io.IOUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class ContextForTest {

  public static final StoreSetting STORE_SETTING = loadStoreSetting("store.properties");
  public static final MemoryStoreSettingStorage STORE_SETTING_STORAGE = new MemoryStoreSettingStorage();

  static {
    STORE_SETTING_STORAGE.registerStore(STORE_SETTING);
  }

  public static final RestInvoker INVOKER = new OkHttpRestInvoker(
      new PrivateAppAdminAccessTokenProvider(STORE_SETTING_STORAGE));
  public static final StoreFactory<RestAdmin> FACTORY = CachedStoreFactory
      .of(new RestAdminFactory(INVOKER));
  public static final RestAdmin TEST_STORE = FACTORY.getStore(STORE_SETTING.getMyshopifyDomain());

  private static StoreSetting loadStoreSetting(String resourceName) {
    try {
      StoreSetting setting = new StoreSetting();
      Properties properties = new Properties();
      properties.load(new StringReader(IOUtils.resourceToString(resourceName,
          StandardCharsets.UTF_8, ContextForTest.class.getClassLoader())));
      setting.setMyshopifyDomain(properties.getProperty("myshopify-domain"));
      PrivateApp app = new PrivateApp()
          .setAdminApiPassword(properties.getProperty("private-admin-api-password"));
      setting.setPrivateApp(app);
      return setting;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
