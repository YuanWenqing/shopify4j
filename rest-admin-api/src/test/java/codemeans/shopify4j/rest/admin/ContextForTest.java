package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.core.auth.PrivateAppAdminAccessTokenProvider;
import codemeans.shopify4j.core.base.CachedClientFactory;
import codemeans.shopify4j.core.base.MemoryStoreSettingStorage;
import codemeans.shopify4j.core.base.ClientFactory;
import codemeans.shopify4j.core.base.StoreSetting;
import codemeans.shopify4j.rest.http.RestInvoker;
import codemeans.shopify4j.rest.okhttp.OkHttpRestInvoker;
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

  public static final RestInvoker INVOKER = OkHttpRestInvoker.admin(
      new PrivateAppAdminAccessTokenProvider(STORE_SETTING_STORAGE));
  public static final ClientFactory<RestAdmin> FACTORY = CachedClientFactory
      .of(new RestAdminFactory(INVOKER));
  public static final RestAdmin TEST_STORE = FACTORY.getClient(STORE_SETTING.getMyshopifyDomain());

  private static StoreSetting loadTestStore() {
    File workdir = new File(System.getProperty("user.dir")).getParentFile();
    File propertiesFile = new File(workdir, "test.properties");
    try (FileInputStream inputStream = new FileInputStream(propertiesFile)) {
      return StoreSetting.load(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
