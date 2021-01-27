package codemeans.shopify4j.core.store;

/**
 * @author: yuanwq
 * @date: 2021-01-27
 */
public enum AdminAccessScope {

  read_all_orders,
  read_analytics,
  read_assigned_fulfillment_orders, write_assigned_fulfillment_orders,
  read_checkouts, write_checkouts,
  read_content, write_content,
  read_customers, write_customers,
  read_discounts, write_discounts,
  read_draft_orders, write_draft_orders,
  read_fulfillments, write_fulfillments,
  read_inventory, write_inventory,
  read_locales, write_locales,
  read_locations,
  read_marketing_events, write_marketing_events,
  read_merchant_managed_fulfillment_orders, write_merchant_managed_fulfillment_orders,
  read_orders, write_orders,
  read_price_rules, write_price_rules,
  read_product_listings,
  read_products, write_products,
  read_reports, write_reports,
  read_resource_feedbacks, write_resource_feedbacks,
  read_script_tags, write_script_tags,
  read_shipping, write_shipping,
  read_shopify_payments_disputes,
  read_shopify_payments_payouts,
  read_themes, write_themes,
  read_third_party_fulfillment_orders, write_third_party_fulfillment_orders,
  read_translations, write_translations,
  read_users, write_users,
  write_order_edits
}
