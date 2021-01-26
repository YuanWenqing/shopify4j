package codemeans.shopify4j.core.store;

/**
 * private app use api password as accessToken: https://shopify.dev/tutorials/authenticate-a-private-app-with-shopify-admin
 *
 * @author: yuanwq
 * @date: 2021-01-13
 */
public class PrivateAppAccessTokenProvider implements AccessTokenProvider {

  private final StoreSettingStorage settingStorage;

  public PrivateAppAccessTokenProvider(StoreSettingStorage settingStorage) {
    this.settingStorage = settingStorage;
  }

  @Override
  public String getAccessToken(String storeDomain) {
    StoreSetting setting = settingStorage.getStoreSetting(storeDomain);
    if (setting != null) {
      return setting.getApiPassword();
    }
    return null;
  }
}
