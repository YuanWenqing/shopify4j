package codemeans.shopify4j.rest.okhttp;

import codemeans.shopify4j.core.auth.AccessTokenInterceptor;
import codemeans.shopify4j.core.auth.AccessTokenProvider;
import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.core.exception.ShopifyClientException;
import codemeans.shopify4j.rest.exception.RestResponseException;
import codemeans.shopify4j.rest.http.HttpRequest;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.ICodec;
import codemeans.shopify4j.rest.http.RestInvoker;
import codemeans.shopify4j.rest.http.SerializingException;
import codemeans.shopify4j.rest.jackson.JacksonCodec;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Slf4j
public class OkHttpRestInvoker implements RestInvoker {

  private static final MediaType MEDIA_TYPE_JSON = MediaType
      .parse("application/json; charset=utf-8");

  private final OkHttpClient okHttpClient;
  private final ICodec codec;

  public static OkHttpRestInvoker admin(AccessTokenProvider accessTokenProvider) {
    return new OkHttpRestInvoker(
        createOkHttpClient(AccessTokenInterceptor.admin(accessTokenProvider)),
        JacksonCodec.DEFAULT_INSTANCE);
  }

  public OkHttpRestInvoker(OkHttpClient okHttpClient, ICodec codec) {
    this.okHttpClient = okHttpClient;
    this.codec = codec;
  }

  public static OkHttpClient createOkHttpClient(AccessTokenInterceptor accessTokenInterceptor) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    // timeout
    builder.connectTimeout(60, TimeUnit.SECONDS)
        .callTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS);
    // custom redirect
    builder.followRedirects(false);
    // interceptor
    builder.addInterceptor(new SeeOtherInterceptor())
        .addInterceptor(accessTokenInterceptor);
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
  public <T> HttpResponse<T> get(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    Request request = new Request.Builder()
        .url(httpUrl)
        .build();
    return invoke(request, respType);
  }

  @Override
  public <T> HttpResponse<T> postJson(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException {
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
  public <T> HttpResponse<T> putJson(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException {
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
  public <T> HttpResponse<T> delete(HttpRequest httpRequest, Class<T> respType)
      throws RestApiException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    Request request = new Request.Builder()
        .url(httpUrl)
        .delete()
        .build();
    return invoke(request, respType);
  }

  private HttpUrl buildHttpUrl(HttpRequest httpRequest) {
    HttpUrl.Builder builder = HttpUrl.parse(httpRequest.getEndpoint()).newBuilder();
    httpRequest.getQueries().forEach(builder::addQueryParameter);
    return builder.build();
  }

  private <T> HttpResponse<T> invoke(Request request, Class<T> respType)
      throws RestApiException {
    String body = null;
    final long beg = System.currentTimeMillis();
    try (Response response = okHttpClient.newCall(request).execute()) {
      body = response.body().string();
      HttpResponse<T> httpResponse = new HttpResponse<>(response.code(), body);
      httpResponse.addAllHeaders(response.headers().toMultimap());
      if (log.isDebugEnabled()) {
        final long cost = System.currentTimeMillis() - beg;
        log.debug("cost={}, request={}, response.code={}, response.body={}",
            cost, request, response.code(), body);
      }
      if (response.isSuccessful()) {
        httpResponse.setObject(codec.deserialize(respType, body));
        return httpResponse;
      }
      throw new RestResponseException(httpResponse);
    } catch (IOException e) {
      throw new ShopifyClientException("fail to invoke request: " + request, e);
    } catch (SerializingException e) {
      throw new ShopifyClientException(
          "fail to deserialize response, request: " + request + ", response.body: " + body, e);
    }
  }
}
