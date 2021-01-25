package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;
import codemeans.shopify4j.admin.rest.model.events.Webhook;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum WebhookFormat implements ShopifyEnum<WebhookFormat> {
  json, xml
}
