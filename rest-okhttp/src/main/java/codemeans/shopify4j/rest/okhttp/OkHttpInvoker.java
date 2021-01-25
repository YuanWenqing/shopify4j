package codemeans.shopify4j.rest.okhttp;

import codemeans.shopify4j.rest.core.exception.SerializingException;
import codemeans.shopify4j.rest.core.exception.ShopifyClientException;
import codemeans.shopify4j.rest.core.exception.ShopifyServerException;
import codemeans.shopify4j.rest.core.http.HttpRequest;
import codemeans.shopify4j.rest.core.http.HttpResponse;
import codemeans.shopify4j.rest.core.http.ICodec;
import codemeans.shopify4j.rest.core.http.Invoker;
import codemeans.shopify4j.rest.core.jackson.JacksonCodec;
import codemeans.shopify4j.rest.core.store.AccessTokenProvider;
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
public class OkHttpInvoker implements Invoker {

  private static final MediaType MEDIA_TYPE_JSON = MediaType
      .parse("application/json; charset=utf-8");

  private final OkHttpClient okHttpClient;
  private final ICodec codec;

  public OkHttpInvoker(AccessTokenProvider accessTokenProvider) {
    this(createOkHttpClient(accessTokenProvider), JacksonCodec.DEFAULT_INSTANCE);
  }

  public OkHttpInvoker(OkHttpClient okHttpClient, ICodec codec) {
    this.okHttpClient = okHttpClient;
    this.codec = codec;
  }

  public static OkHttpClient createOkHttpClient(AccessTokenProvider accessTokenProvider) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    // timeout
    builder.connectTimeout(60, TimeUnit.SECONDS)
        .callTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS);
    // custom redirect
    builder.followRedirects(false);
    // interceptor
    builder.addInterceptor(new SeeOtherInterceptor())
        .addInterceptor(new AccessTokenInterceptor(accessTokenProvider));
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
      throws ShopifyServerException {
    HttpUrl httpUrl = buildHttpUrl(httpRequest);
    Request request = new Request.Builder()
        .url(httpUrl)
        .build();
    return invoke(request, respType);
  }

  @Override
  public <T> HttpResponse<T> postJson(HttpRequest httpRequest, Class<T> respType)
      throws ShopifyServerException {
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
      throws ShopifyServerException {
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
      throws ShopifyServerException {
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
      throws ShopifyServerException {
    String body = null;
    try (Response response = okHttpClient.newCall(request).execute()) {
      body = response.body().string();
      HttpResponse<T> httpResponse = new HttpResponse<>(response.code(), body);
      httpResponse.addAllHeaders(response.headers().toMultimap());
      if (log.isDebugEnabled()) {
        log.debug("request: {}, response.code={}, response.body={}",
            request, response.code(), body);
      }
      if (response.isSuccessful()) {
        httpResponse.setObject(codec.deserialize(respType, body));
        return httpResponse;
      }
      throw new ShopifyServerException(httpResponse);
    } catch (IOException e) {
      throw new ShopifyClientException("fail to invoke request: " + request, e);
    } catch (SerializingException e) {
      throw new ShopifyClientException(
          "fail to deserialize response, request: " + request + ", response.body: " + body, e);
    }
  }
}