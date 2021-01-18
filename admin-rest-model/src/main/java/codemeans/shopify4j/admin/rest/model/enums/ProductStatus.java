package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public enum ProductStatus implements ShopifyEnum<ProductStatus> {

  active,
  archived,
  draft;
}
