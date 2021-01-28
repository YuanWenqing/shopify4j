package codemeans.shopify4j.core.oauth;

import codemeans.shopify4j.core.app.PublicApp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.io.IOException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Slf4j
public class AppOauthFlow {

  @Getter
  private final OkHttpClient okHttpClient;
  @Getter
  private final ObjectMapper objectMapper;

  public AppOauthFlow() {
    this(defaultHttpClient(), defaultObjectMapper());
  }

  public AppOauthFlow(OkHttpClient okHttpClient, ObjectMapper objectMapper) {
    this.okHttpClient = okHttpClient;
    this.objectMapper = objectMapper;
  }

  public String authorizationUrl(PublicApp app, AuthorizationReq req) {
    HttpUrl.Builder builder = HttpUrl
        .parse(String.format("https://%s/admin/oauth/authorize", req.getShop()))
        .newBuilder();
    builder.setQueryParameter("client_id", app.getClientId())
        .setQueryParameter("scope", StringUtils.join(app.getScopes(), ","))
        .setQueryParameter("redirect_uri", req.getRedirectUri());
    if (StringUtils.isNotBlank(req.getState())) {
      builder.setQueryParameter("state", req.getState());
    }
    if (StringUtils.isNotBlank(req.getAccessMode())) {
      builder.setQueryParameter("grant_options[]", req.getAccessMode());
    }
    return builder.toString();
  }

  public OauthAccessToken exchangeAccessToken(PublicApp app, ConfirmRedirection redirection)
      throws IOException {
    String url = String.format("https://%s/admin/oauth/access_token", redirection.getShop());
    RequestBody requestBody = new FormBody.Builder()
        .add("client_id", app.getClientId())
        .add("client_secret", app.getClientSecret())
        .add("code", redirection.getCode())
        .build();
    Request request = new Request.Builder()
        .url(url)
        .post(requestBody)
        .build();
    String body = null;
    try (Response response = okHttpClient.newCall(request).execute()) {
      body = response.body().string();
      if (log.isDebugEnabled()) {
        log.debug("request: {}, app: {}, redirection: {}, response.code={}, response.body: {}",
            request, app, redirection, response.code(), response.body());
      }
      if (!response.isSuccessful()) {
        throw new IOException(
            "fail to exchange access_token, request: " + request + ", response.code=" + response
                .code() + ", response.body: " + body);
      }
      return objectMapper.readValue(body, OauthAccessToken.class);
    } catch (JsonProcessingException e) {
      throw new IOException(
          "fail to parse access_token, request: " + request + ", response.body: " + body, e);
    }
  }

  public static OkHttpClient defaultHttpClient() {
    return new OkHttpClient();
  }

  public static ObjectMapper defaultObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    return objectMapper;
  }
}
