package codemeans.shopify4j.core.http;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public interface ShopifyHeaders {

  String ACCESS_TOKEN = "X-Shopify-Access-Token";
  String API_VERSION = "X-Shopify-API-Version";
  String API_DEPRECATED_REASON = "X-Shopify-API-Deprecated-Reason";
  String API_CALL_LIMIT = "X-Shopify-Shop-Api-Call-Limit";
  String RETRY_AFTER = "Retry-After";
  String LOCATION = "Location";

}
