package codemeans.shopify4j.admin.rest.model.enums;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public enum EventTopic implements ShopifyEnum<EventTopic> {

  APP$UNINSTALLED("app/uninstalled"),
  CARTS$CREATE("carts/create"),
  CARTS$UPDATE("carts/update"),
  CHECKOUTS$CREATE("checkouts/create"),
  CHECKOUTS$DELETE("checkouts/delete"),
  CHECKOUTS$UPDATE("checkouts/update"),
  COLLECTION_LISTINGS$ADD("collection_listings/add"),
  COLLECTION_LISTINGS$REMOVE("collection_listings/remove"),
  COLLECTION_LISTINGS$UPDATE("collection_listings/update"),
  COLLECTIONS$CREATE("collections/create"),
  COLLECTIONS$DELETE("collections/delete"),
  COLLECTIONS$UPDATE("collections/update"),
  CUSTOMER_GROUPS$CREATE("customer_groups/create"),
  CUSTOMER_GROUPS$DELETE("customer_groups/delete"),
  CUSTOMER_GROUPS$UPDATE("customer_groups/update"),
  CUSTOMER_PAYMENT_METHODS$CREATE("customer_payment_methods/create"),
  CUSTOMER_PAYMENT_METHODS$REVOKE("customer_payment_methods/revoke"),
  CUSTOMER_PAYMENT_METHODS$UPDATE("customer_payment_methods/update"),
  CUSTOMERS$CREATE("customers/create"),
  CUSTOMERS$DELETE("customers/delete"),
  CUSTOMERS$DISABLE("customers/disable"),
  CUSTOMERS$ENABLE("customers/enable"),
  CUSTOMERS$UPDATE("customers/update"),
  DISPUTES$CREATE("disputes/create"),
  DISPUTES$UPDATE("disputes/update"),
  DOMAINS$CREATE("domains/create"),
  DOMAINS$DESTROY("domains/destroy"),
  DOMAINS$UPDATE("domains/update"),
  DRAFT_ORDERS$CREATE("draft_orders/create"),
  DRAFT_ORDERS$DELETE("draft_orders/delete"),
  DRAFT_ORDERS$UPDATE("draft_orders/update"),
  FULFILLMENT_EVENTS$CREATE("fulfillment_events/create"),
  FULFILLMENT_EVENTS$DELETE("fulfillment_events/delete"),
  FULFILLMENTS$CREATE("fulfillments/create"),
  FULFILLMENTS$UPDATE("fulfillments/update"),
  INVENTORY_ITEMS$CREATE("inventory_items/create"),
  INVENTORY_ITEMS$DELETE("inventory_items/delete"),
  INVENTORY_ITEMS$UPDATE("inventory_items/update"),
  INVENTORY_LEVELS$CONNECT("inventory_levels/connect"),
  INVENTORY_LEVELS$DISCONNECT("inventory_levels/disconnect"),
  INVENTORY_LEVELS$UPDATE("inventory_levels/update"),
  LOCALES$CREATE("locales/create"),
  LOCALES$UPDATE("locales/update"),
  LOCATIONS$CREATE("locations/create"),
  LOCATIONS$DELETE("locations/delete"),
  LOCATIONS$UPDATE("locations/update"),
  ORDER_TRANSACTIONS$CREATE("order_transactions/create"),
  ORDERS$CANCELLED("orders/cancelled"),
  ORDERS$CREATE("orders/create"),
  ORDERS$DELETE("orders/delete"),
  ORDERS$EDITED("orders/edited"),
  ORDERS$FULFILLED("orders/fulfilled"),
  ORDERS$PAID("orders/paid"),
  ORDERS$PARTIALLY_FULFILLED("orders/partially_fulfilled"),
  ORDERS$UPDATED("orders/updated"),
  PRODUCT_LISTINGS$ADD("product_listings/add"),
  PRODUCT_LISTINGS$REMOVE("product_listings/remove"),
  PRODUCT_LISTINGS$UPDATE("product_listings/update"),
  PRODUCTS$CREATE("products/create"),
  PRODUCTS$DELETE("products/delete"),
  PRODUCTS$UPDATE("products/update"),
  PROFILES$CREATE("profiles/create"),
  PROFILES$DELETE("profiles/delete"),
  PROFILES$UPDATE("profiles/update"),
  REFUNDS$CREATE("refunds/create"),
  SHOP$UPDATE("shop/update"),
  SUBSCRIPTION_BILLING_ATTEMPTS$FAILURE("subscription_billing_attempts/failure"),
  SUBSCRIPTION_BILLING_ATTEMPTS$SUCCESS("subscription_billing_attempts/success"),
  SUBSCRIPTION_CONTRACTS$CREATE("subscription_contracts/create"),
  SUBSCRIPTION_CONTRACTS$UPDATE("subscription_contracts/update"),
  TENDER_TRANSACTIONS$CREATE("tender_transactions/create"),
  THEMES$CREATE("themes/create"),
  THEMES$DELETE("themes/delete"),
  THEMES$PUBLISH("themes/publish"),
  THEMES$UPDATE("themes/update"),
  ;

  private final String topic;

  EventTopic(java.lang.String topic) {
    this.topic = topic;
  }

  @Override
  public java.lang.String shopifyValue() {
    return topic;
  }
}
