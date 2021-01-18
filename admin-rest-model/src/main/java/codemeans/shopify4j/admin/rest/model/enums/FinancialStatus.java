package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum FinancialStatus implements ShopifyEnum<FinancialStatus> {
  pending,
  authorized,
  paid,
  partially_paid,
  unpaid,
  refunded,
  partially_refunded,
  voided,
  any,
}
