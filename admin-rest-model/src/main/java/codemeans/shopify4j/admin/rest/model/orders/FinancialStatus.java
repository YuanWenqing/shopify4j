package codemeans.shopify4j.admin.rest.model.orders;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum FinancialStatus {
  pending,
  authorized,
  partially_paid,
  getPartially_paid,
  partially_refunded,
  refunded,
  voided
}
