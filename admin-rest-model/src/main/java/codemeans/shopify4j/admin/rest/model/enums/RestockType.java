package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum RestockType implements ShopifyEnum<RestockType> {
  NO_RESTOCK,
  CANCEL,
  RETURN,
  LEGACY_RESTOCK
}
