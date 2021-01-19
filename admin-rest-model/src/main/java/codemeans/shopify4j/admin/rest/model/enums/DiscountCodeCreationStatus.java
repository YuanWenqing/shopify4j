package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public enum DiscountCodeCreationStatus implements ShopifyEnum<DiscountCodeCreationStatus> {

  queued,
  running,
  completed,
}
