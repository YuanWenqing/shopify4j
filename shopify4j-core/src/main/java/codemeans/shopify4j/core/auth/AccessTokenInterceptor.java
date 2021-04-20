package codemeans.shopify4j.core.auth;

import codemeans.shopify4j.core.exception.ShopifyClientException;
import codemeans.shopify4j.core.utils.ShopifyHeaders;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public class AccessTokenInterceptor implements Interceptor {

  private final String tokenHeader;
  private final AccessTokenProvider accessTokenProvider;

  public AccessTokenInterceptor(String tokenHeader, AccessTokenProvider accessTokenProvider) {
    this.tokenHeader = tokenHeader;
    this.accessTokenProvider = accessTokenProvider;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    // first try url
    String accessToken = accessTokenProvider.getAccessToken(request.url().toString());
    if (StringUtils.isBlank(accessToken)) {
      // try host: just for compatibility
      accessToken = accessTokenProvider.getAccessToken(request.url().host());
    }
    if (StringUtils.isBlank(accessToken)) {
      throw new ShopifyClientException("blank accessToken, request: " + request);
    }
    request = request.newBuilder()
        .addHeader(tokenHeader, accessToken)
        .build();
    return chain.proceed(request);
  }

  public static AccessTokenInterceptor admin(AccessTokenProvider accessTokenProvider) {
    return new AccessTokenInterceptor(ShopifyHeaders.ADMIN_ACCESS_TOKEN, accessTokenProvider);
  }

  public static AccessTokenInterceptor storefront(AccessTokenProvider accessTokenProvider) {
    return new AccessTokenInterceptor(ShopifyHeaders.STOREFRONT_ACCESS_TOKEN, accessTokenProvider);
  }

  public static AccessTokenInterceptor partner(AccessTokenProvider accessTokenProvider) {
    return new AccessTokenInterceptor(ShopifyHeaders.PARTNER_ACCESS_TOKEN, accessTokenProvider);
  }
}
