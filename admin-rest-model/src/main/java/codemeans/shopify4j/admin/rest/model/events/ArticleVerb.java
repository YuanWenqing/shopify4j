package codemeans.shopify4j.admin.rest.model.events;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public enum ArticleVerb implements EventVerb {
  create,
  destroy,
  published,
  unpublished,
  update;

}
