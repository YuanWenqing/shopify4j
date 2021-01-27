package codemeans.shopify4j.core.auth;

import codemeans.shopify4j.core.store.StoreSetting;
import codemeans.shopify4j.core.store.StoreSettingStorage;

/**
 * @author: yuanwq
 * @date: 2021-01-27
 */
public class PrivateAppStorefrontAccessTokenProvider implements AccessTokenProvider {

  private final StoreSettingStorage settingStorage;

  public PrivateAppStorefrontAccessTokenProvider(StoreSettingStorage settingStorage) {
    this.settingStorage = settingStorage;
  }

  @Override
  public String getAccessToken(String myshopifyDomain) {
    StoreSetting setting = settingStorage.getStoreSetting(myshopifyDomain);
    if (setting != null && setting.getPrivateApp() != null) {
      return setting.getPrivateApp().getStorefrontAccessToken();
    }
    return null;
  }
}
