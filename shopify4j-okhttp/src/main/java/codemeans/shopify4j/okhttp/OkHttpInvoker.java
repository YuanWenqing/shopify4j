package codemeans.shopify4j.okhttp;

import codemeans.shopify4j.core.exception.SerializingException;
import codemeans.shopify4j.core.exception.ShopifyClientException;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpRequest;
import codemeans.shopify4j.core.http.ICodec;
import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.core.jackson.JacksonCodec;
import codemeans.shopify4j.core.store.AccessTokenProvider;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Slf4j
public class OkHttpInvoker implements Invoker {

  private static final MediaType MEDIA_TYPE_JSON = MediaType
      .parse("application/json; charset=utf-8");

  private final AccessTokenProvider accessTokenProvider;
  private final OkHttpClient okHttpClient;
  private final ICodec codec;

  public OkHttpInvoker(AccessTokenProvider accessTokenProvider) {
    this(accessTokenProvider, createOkHttpClient(), JacksonCodec.DEFAULT_INSTANCE);
  }

  public OkHttpInvoker(AccessTokenProvider accessTokenProvider, OkHttpClient okHttpClient,
      ICodec codec) {
    this.accessTokenProvider = accessTokenProvider;
    this.okHttpClient = okHttpClient;
    this.codec = codec;
  }

  public static OkHttpClient createOkHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    // timeout
    builder.connectTimeout(60, TimeUnit.SECONDS)
        .callTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS);
    // redirect
    builder.followRedirects(true).followSslRedirects(true);
    return builder.build();
  }

  public OkHttpClient getOkHttpClient() {
    return okHttpClient;
  }

  @Override
  public ICodec getCodec() {
    return codec;
  }

  @Override
  public <T> T get(HttpRequest httpRequest, Class<T> respType) throws ShopifyServerException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    Request request = new Request.Builder()
        .url(httpUrl)
        .build();
    return invoke(request, respType);
  }

  @Override
  public <T> T postJson(HttpRequest httpRequest, Class<T> respType) throws ShopifyServerException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    String body;
    try {
      body = codec.serialize(httpRequest.getBody());
    } catch (SerializingException e) {
      throw new ShopifyClientException("request: " + httpRequest, e);
    }
    Request request = new Request.Builder()
        .url(httpUrl)
        .post(RequestBody.create(MEDIA_TYPE_JSON, body))
        .build();
    return invoke(request, respType);
  }

  @Override
  public <T> T putJson(HttpRequest httpRequest, Class<T> respType) throws ShopifyServerException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    String body;
    try {
      body = codec.serialize(httpRequest.getBody());
    } catch (SerializingException e) {
      throw new ShopifyClientException("request: " + httpRequest, e);
    }
    Request request = new Request.Builder()
        .url(httpUrl)
        .put(RequestBody.create(MEDIA_TYPE_JSON, body))
        .build();
    return invoke(request, respType);
  }

  @Override
  public void delete(HttpRequest httpRequest) throws ShopifyServerException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    Request request = new Request.Builder()
        .url(httpUrl)
        .delete()
        .build();
    invoke(request, String.class);
  }

  private HttpUrl buildHttpUrl(HttpRequest httpRequest) {
    HttpUrl.Builder builder = HttpUrl.parse(httpRequest.getEndpoint()).newBuilder();
    httpRequest.getQueries().forEach(builder::addQueryParameter);
    return builder.build();
  }

  private <T> T invoke(Request request, Class<T> respType) throws ShopifyServerException {
    String body = null;
    request = authenticateRequest(request);
    try (Response response = okHttpClient.newCall(request).execute()) {
      body = response.body().string();
      if (log.isDebugEnabled()) {
        log.debug("request: {}, response.code={}, response.body={}",
            request, response.code(), body);
      }
      if (response.code() >= 300) {
        throw new ShopifyServerException(response.code(), body);
      }
      return codec.deserialize(respType, body);
    } catch (IOException e) {
      throw new ShopifyClientException("fail to invoke request: " + request, e);
    } catch (SerializingException e) {
      throw new ShopifyClientException(
          "fail to deserialize response, request: " + request + ", response.body: " + body, e);
    }
  }

  private Request authenticateRequest(Request request) {
    String accessToken = accessTokenProvider.getAccessToken(request.url().host());
    if (StringUtils.isBlank(accessToken)) {
      throw new ShopifyClientException("blank accessToken, request: " + request);
    }
    return request.newBuilder()
        .addHeader("X-Shopify-Access-Token", accessToken)
        .build();
  }
}
