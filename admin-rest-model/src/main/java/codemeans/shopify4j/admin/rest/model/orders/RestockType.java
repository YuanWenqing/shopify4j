package codemeans.shopify4j.admin.rest.model.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum RestockType {
  no_restock,
  cancel,
  @JsonProperty("return")
  $return,
  legacy_restock
}
