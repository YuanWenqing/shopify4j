package codemeans.shopify4j.graphql.admin;

import codemeans.shopify4j.core.store.AccessTokenInterceptor;
import codemeans.shopify4j.core.store.AccessTokenProvider;
import codemeans.shopify4j.core.store.ShopifyClientException;
import codemeans.shopify4j.graphql.admin.exception.GraphqlApiException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Slf4j
public class OkHttpGraphqlInvoker implements GraphqlInvoker {

  private static final MediaType MEDIA_TYPE_JSON = MediaType
      .parse("application/json; charset=utf-8");

  private final OkHttpClient okHttpClient;

  public OkHttpGraphqlInvoker(AccessTokenProvider accessTokenProvider) {
    this(createOkHttpClient(accessTokenProvider));
  }

  public OkHttpGraphqlInvoker(OkHttpClient okHttpClient) {
    this.okHttpClient = okHttpClient;
  }

  public static OkHttpClient createOkHttpClient(AccessTokenProvider accessTokenProvider) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    // timeout
    builder.connectTimeout(60, TimeUnit.SECONDS)
        .callTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS);
    builder.followRedirects(true);
    // interceptor
    builder.addInterceptor(new AccessTokenInterceptor(accessTokenProvider));
    return builder.build();
  }

  @Override
  public String request(String endpoint, String query) throws GraphqlApiException {
    Request request = new Request.Builder().url(endpoint)
        .post(RequestBody.create(MEDIA_TYPE_JSON, query))
        .build();
    try (Response response = okHttpClient.newCall(request).execute()) {
      String body = response.body().string();
      if (log.isDebugEnabled()) {
        log.debug("request: {}, request.body={}, response.code={}, response.body={}",
            request, query, response.code(), body);
      }
      if (response.isSuccessful()) {
        return body;
      }
      throw new GraphqlApiException("endpoint=" + endpoint + ", query: " + query);
    } catch (IOException e) {
      throw new ShopifyClientException("fail to invoke request: " + request, e);
    }
  }
}
