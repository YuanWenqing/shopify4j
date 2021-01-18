package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: yuanwq
 * @date: 2021-01-09
 */
public enum PublishedScope implements ShopifyEnum<PublishedScope> {
  @JsonProperty("web")
  WEB,
  @JsonProperty("global")
  GLOBAL

}
