package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public enum ArticleVerb implements ShopifyEnum<ArticleVerb> {
  create,
  destroy,
  published,
  unpublished,
  update;

}
