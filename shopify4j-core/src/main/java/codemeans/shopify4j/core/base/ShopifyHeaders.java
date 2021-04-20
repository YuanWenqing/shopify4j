package codemeans.shopify4j.core.base;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public interface ShopifyHeaders {

  String ADMIN_ACCESS_TOKEN = "X-Shopify-Access-Token";
  String STOREFRONT_ACCESS_TOKEN = "X-Shopify-Storefront-Access-Token";
  String PARTNER_ACCESS_TOKEN = "X-Shopify-Access-Token";
  String API_VERSION = "X-Shopify-API-Version";
  String API_DEPRECATED_REASON = "X-Shopify-API-Deprecated-Reason";
  String API_CALL_LIMIT = "X-Shopify-Shop-Api-Call-Limit";
  String RETRY_AFTER = "Retry-After";
  String LOCATION = "Location";
  String STAGE = "X-Shopify-Stage";
  String SHOPID = "X-ShopId";
  String LOGIN_REQUIRED = "X-Shopify-Login-Required";

  /* headers for webhook event */
  String TOPIC = "X-Shopify-Topic";
  String HMAC_SHA256 = "X-Shopify-Hmac-Sha256";
  String SHOP_DOMAIN = "X-Shopify-Shop-Domain";
  String WEBHOOK_ID = "X-Shopify-Webhook-Id";
}

