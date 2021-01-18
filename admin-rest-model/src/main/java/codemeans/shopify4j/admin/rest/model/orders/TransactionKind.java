package codemeans.shopify4j.admin.rest.model.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum TransactionKind {
  authorization,
  capture,
  sale,
  @JsonProperty("void")
  $void,
  refund
}
