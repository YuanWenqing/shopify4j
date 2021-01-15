package codemeans.shopify4j.admin.rest.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The order in which products in the collection appear.
 *
 * @author: yuanwq
 * @date: 2021-01-15
 */
public enum SortOrder {

  @JsonProperty("alpha-asc")
  ALPHA_ASC,
  @JsonProperty("alpha-desc")
  ALPHA_DESC,
  @JsonProperty("best-selling")
  BEST_SELLING,
  @JsonProperty("created")
  CREATED,
  @JsonProperty("created-desc")
  CREATED_DESC,
  @JsonProperty("manual")
  MANUAL,
  @JsonProperty("price-asc")
  PRICE_ASC,
  @JsonProperty("price-desc")
  PRICE_DESC,
}
