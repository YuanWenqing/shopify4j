package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum TransactionSource implements ShopifyEnum<TransactionSource> {
  web,
  pos,
  iphone,
  android
}
