package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

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
