package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum DiscountType implements ShopifyEnum<DiscountType> {

  percentage,
  fixed_amount,
  shipping
}
