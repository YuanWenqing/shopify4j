package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;
import codemeans.shopify4j.admin.rest.model.metafield.Metafield;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
public enum MetafieldValueType implements ShopifyEnum<MetafieldValueType> {
  string,
  integer,
  json_string
}
