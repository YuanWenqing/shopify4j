package codemeans.shopify4j.admin.rest;

import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStoreImpl;
import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.okhttp.OkHttpInvoker;
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
  public static final Invoker INVOKER = new OkHttpInvoker();
  public static final ShopifyStore TEST_STORE = new ShopifyStoreImpl(STORE_SETTING, INVOKER);


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
