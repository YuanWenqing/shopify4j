package codemeans.shopify4j.admin.rest.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public enum InventoryPolicy {

  @JsonProperty("deny")
  DENY,
  @JsonProperty("continue")
  CONTINUE;
}
