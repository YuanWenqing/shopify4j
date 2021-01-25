package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * The order in which products in the collection appear.
 *
 * @author: yuanwq
 * @date: 2021-01-15
 */
public enum SortOrder implements ShopifyEnum<SortOrder> {

  ALPHA_ASC,
  ALPHA_DESC,
  BEST_SELLING,
  CREATED,
  CREATED_DESC,
  MANUAL,
  PRICE_ASC,
  PRICE_DESC,
  ;

  @Override
  public String shopifyValue() {
    return name().toLowerCase().replace("_", "-");
  }
}
