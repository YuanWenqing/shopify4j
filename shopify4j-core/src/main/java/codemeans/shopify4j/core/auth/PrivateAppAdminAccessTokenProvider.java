package codemeans.shopify4j.core.auth;

import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;

/**
 * private app use admin api password as accessToken: https://shopify.dev/tutorials/authenticate-a-private-app-with-shopify-admin
 *
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class PrivateAppAdminAccessTokenProvider implements AccessTokenProvider {

  private final StoreSettingStorage settingStorage;

  public PrivateAppAdminAccessTokenProvider(StoreSettingStorage settingStorage) {
    this.settingStorage = settingStorage;
  }

  @Override
  public String getAccessToken(String myshopifyDomain) {
    StoreSetting setting = settingStorage.getStoreSetting(myshopifyDomain);
    if (setting != null && setting.getPrivateApp() != null) {
      return setting.getPrivateApp().getAdminApiPassword();
    }
    return null;
  }
}
