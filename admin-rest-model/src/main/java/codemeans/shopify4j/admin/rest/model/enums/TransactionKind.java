package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum TransactionKind implements ShopifyEnum<TransactionKind> {
  authorization,
  capture,
  sale,
  @JsonProperty("void")
  $void,
  refund
}
