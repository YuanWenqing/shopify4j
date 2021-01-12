package codemeans.shopify4j.admin.rest.core;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface Invoker {

  String baseEndpoint();

  String apiVersion();

  OkHttpClient okHttpClient();

  Response invoke(Request request);
}
