package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.core.store.MemoryStoreSettingStorage;
import codemeans.shopify4j.core.auth.PrivateAppAccessTokenProvider;
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
      new PrivateAppAccessTokenProvider(STORE_SETTING_STORAGE));
  public static final RestStore TEST_STORE = new DefaultRestStore(STORE_SETTING, INVOKER);

  private static StoreSetting loadStoreSetting(String resourceName) {
    try {
      StoreSetting setting = new StoreSetting();
      Properties properties = new Properties();
      properties.load(new StringReader(IOUtils.resourceToString(resourceName,
          StandardCharsets.UTF_8, ContextForTest.class.getClassLoader())));
      setting.setStoreDomain(properties.getProperty("store-domain"));
      setting.setApiKey(properties.getProperty("api-key"));
      setting.setApiPassword(properties.getProperty("api-password"));
      setting.setApiVersion(properties.getProperty("api-version", setting.getApiVersion()));
      return setting;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
