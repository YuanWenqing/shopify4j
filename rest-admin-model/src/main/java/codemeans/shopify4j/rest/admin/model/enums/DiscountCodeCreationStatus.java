package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public enum DiscountCodeCreationStatus implements ShopifyEnum<DiscountCodeCreationStatus> {

  queued,
  running,
  completed,
}
