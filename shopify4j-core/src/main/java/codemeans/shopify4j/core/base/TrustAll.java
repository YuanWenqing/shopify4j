package codemeans.shopify4j.core.base;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/**
 * @author: yuanwq
 * @date: 2020-01-14
 */
public class TrustAll {

  static SSLSocketFactory createSSLSocketFactory() {
    SSLSocketFactory sSLSocketFactory = null;
    try {
      SSLContext sc = SSLContext.getInstance("TLS");
      sc.init(null, new TrustManager[]{new TrustAllManager()},
          new SecureRandom());
      sSLSocketFactory = sc.getSocketFactory();
    } catch (Exception e) {
    }
    return sSLSocketFactory;
  }

  static class TrustAllManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
    }
  }

  static class TrustAllHostnameVerifier implements HostnameVerifier {

    @Override
    public boolean verify(String hostname, SSLSession session) {
      return true;
    }
  }

  public static OkHttpClient trustAll(OkHttpClient okHttpClient) {
    OkHttpClient.Builder builder = okHttpClient.newBuilder();
    builder.sslSocketFactory(TrustAll.createSSLSocketFactory(), new TrustAllManager());
    builder.hostnameVerifier(new TrustAllHostnameVerifier());
    return builder.build();
  }
}
