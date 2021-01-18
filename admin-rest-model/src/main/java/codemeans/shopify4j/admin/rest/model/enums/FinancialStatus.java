package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum FinancialStatus implements ShopifyEnum<FinancialStatus> {
  pending,
  authorized,
  partially_paid,
  getPartially_paid,
  partially_refunded,
  refunded,
  voided
}
