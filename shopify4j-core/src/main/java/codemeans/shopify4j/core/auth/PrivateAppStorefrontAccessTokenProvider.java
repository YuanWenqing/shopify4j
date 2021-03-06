package codemeans.shopify4j.core.auth;

import codemeans.shopify4j.core.base.StoreSetting;
import codemeans.shopify4j.core.base.StoreSettingStorage;
import codemeans.shopify4j.core.base.EndpointUtils;
import org.apache.commons.lang3.StringUtils;

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
  public String getAccessToken(String endpoint) {
    StoreSetting setting = settingStorage.getStoreSetting(EndpointUtils.parseDomain(endpoint));
    if (setting != null && setting.getPrivateApp() != null) {
      return setting.getPrivateApp().getStorefrontAccessToken();
    }
    return StringUtils.EMPTY;
  }
}
