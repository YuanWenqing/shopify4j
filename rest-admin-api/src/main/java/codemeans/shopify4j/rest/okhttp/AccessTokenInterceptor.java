package codemeans.shopify4j.rest.okhttp;

import codemeans.shopify4j.core.store.AccessTokenProvider;
import codemeans.shopify4j.core.store.ShopifyClientException;
import codemeans.shopify4j.rest.http.ShopifyHeaders;
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

  private final AccessTokenProvider accessTokenProvider;

  public AccessTokenInterceptor(AccessTokenProvider accessTokenProvider) {
    this.accessTokenProvider = accessTokenProvider;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    String accessToken = accessTokenProvider.getAccessToken(request.url().host());
    if (StringUtils.isBlank(accessToken)) {
      throw new ShopifyClientException("blank accessToken, request: " + request);
    }
    request = request.newBuilder()
        .addHeader(ShopifyHeaders.ACCESS_TOKEN, accessToken)
        .build();
    return chain.proceed(request);
  }
}
