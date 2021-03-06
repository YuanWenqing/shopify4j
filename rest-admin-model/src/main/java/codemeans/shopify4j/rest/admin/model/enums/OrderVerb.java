package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public enum OrderVerb implements ShopifyEnum<OrderVerb> {
  authorization_failure,
  authorization_pending,
  authorization_success,
  cancelled,
  capture_failure,
  capture_pending,
  capture_success,
  closed,
  confirmed,
  fulfillment_cancelled,
  fulfillment_pending,
  fulfillment_success,
  mail_sent,
  placed,
  re_opened,
  refund_failure,
  refund_pending,
  refund_success,
  restock_line_items,
  sale_failure,
  sale_pending,
  sale_success,
  update,
  void_failure,
  void_pending,
  void_success;

}
