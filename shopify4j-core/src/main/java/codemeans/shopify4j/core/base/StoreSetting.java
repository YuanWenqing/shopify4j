package codemeans.shopify4j.core.base;

import codemeans.shopify4j.core.app.PrivateApp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2020-08-26
 */
@Data
@Accessors(chain = true)
public class StoreSetting {

  /**
   * store domain, format like {@code your-shop.myshopify.com}
   */
  private String myshopifyDomain;
  private PrivateApp privateApp;

  public static StoreSetting fromProperties(Properties properties) {
    StoreSetting setting = new StoreSetting();
    setting.setMyshopifyDomain(properties.getProperty("myshopify-domain"));
    PrivateApp app = new PrivateApp()
        .setAdminApiKey(properties.getProperty("private-app.admin-api-key"))
        .setAdminApiPassword(properties.getProperty("private-app.admin-api-password"))
        .setStorefrontAccessToken(properties.getProperty("private-app.storefront-access-token"));
    setting.setPrivateApp(app);
    return setting;
  }

  public static StoreSetting load(InputStream inputStream) throws IOException {
    Properties properties = new Properties();
    properties.load(inputStream);
    return fromProperties(properties);
  }
}
