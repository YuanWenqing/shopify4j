package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public enum ProductStatus implements ShopifyEnum<ProductStatus> {

  active,
  archived,
  draft;
}
