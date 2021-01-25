package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

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
