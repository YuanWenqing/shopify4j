package codemeans.shopify4j.okhttp;

import codemeans.shopify4j.core.exception.SerializingException;
import codemeans.shopify4j.core.exception.ShopifyClientException;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.ICodec;
import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.core.http.JsonCodec;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class OkHttpInvoker implements Invoker {

  private final OkHttpClient okHttpClient;
  private final ICodec codec;

  public OkHttpInvoker() {
    this(createOkHttpClient(), JsonCodec.DEFAULT_INSTANCE);
  }

  public OkHttpInvoker(OkHttpClient okHttpClient, ICodec codec) {
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
  public <T> T get(String url, Class<T> respType) throws ShopifyServerException {
    Request request = new Request.Builder().url(url).build();
    return invoke(request, respType);
  }

  private <T> T invoke(Request request, Class<T> respType) throws ShopifyServerException {
    String body = null;
    try (Response response = okHttpClient.newCall(request).execute()) {
      body = response.body().string();
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
}
