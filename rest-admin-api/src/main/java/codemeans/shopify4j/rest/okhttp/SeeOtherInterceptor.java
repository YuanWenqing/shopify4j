package codemeans.shopify4j.rest.okhttp;

import codemeans.shopify4j.core.base.ShopifyHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public class SeeOtherInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response priorResponse = null;
    while (true) {
      Response response = chain.proceed(request);
      if (priorResponse != null) {
        response = response.newBuilder()
            .priorResponse(priorResponse.newBuilder()
                .body(null)
                .build())
            .build();
      }
      if (response.code() != HttpURLConnection.HTTP_SEE_OTHER) {
        return response;
      }
      Util.closeQuietly(response.body());
      String location = response.header(ShopifyHeaders.LOCATION);
      String redirectUrl = location + ".json";
      request = request.newBuilder()
          .url(redirectUrl)
          .build();
      priorResponse = response;
    }
  }
}
