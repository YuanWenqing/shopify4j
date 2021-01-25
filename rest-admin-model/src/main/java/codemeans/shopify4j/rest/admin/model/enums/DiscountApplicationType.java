package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum DiscountApplicationType implements ShopifyEnum<DiscountApplicationType> {
  discount_code,
  manual,
  script
}
