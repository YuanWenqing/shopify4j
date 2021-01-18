package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public enum CollectionVerb implements ShopifyEnum<CollectionVerb> {
  create,
  destroy,
  published,
  unpublished,
  update;

}
