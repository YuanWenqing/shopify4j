package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum CancelReason implements ShopifyEnum<CancelReason> {
  customer,
  fraud,
  inventory,
  declined,
  other
}
