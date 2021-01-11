package codemeans.shopify4j.admin.rest.model.events;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface EventTopics {

  String APP$UNINSTALLED = "app/uninstalled";
  String CARTS$CREATE = "carts/create";
  String CARTS$UPDATE = "carts/update";
  String CHECKOUTS$CREATE = "checkouts/create";
  String CHECKOUTS$DELETE = "checkouts/delete";
  String CHECKOUTS$UPDATE = "checkouts/update";
  String COLLECTION_LISTINGS$ADD = "collection_listings/add";
  String COLLECTION_LISTINGS$REMOVE = "collection_listings/remove";
  String COLLECTION_LISTINGS$UPDATE = "collection_listings/update";
  String COLLECTIONS$CREATE = "collections/create";
  String COLLECTIONS$DELETE = "collections/delete";
  String COLLECTIONS$UPDATE = "collections/update";
  String CUSTOMER_GROUPS$CREATE = "customer_groups/create";
  String CUSTOMER_GROUPS$DELETE = "customer_groups/delete";
  String CUSTOMER_GROUPS$UPDATE = "customer_groups/update";
  String CUSTOMER_PAYMENT_METHODS$CREATE = "customer_payment_methods/create";
  String CUSTOMER_PAYMENT_METHODS$REVOKE = "customer_payment_methods/revoke";
  String CUSTOMER_PAYMENT_METHODS$UPDATE = "customer_payment_methods/update";
  String CUSTOMERS$CREATE = "customers/create";
  String CUSTOMERS$DELETE = "customers/delete";
  String CUSTOMERS$DISABLE = "customers/disable";
  String CUSTOMERS$ENABLE = "customers/enable";
  String CUSTOMERS$UPDATE = "customers/update";
  String DISPUTES$CREATE = "disputes/create";
  String DISPUTES$UPDATE = "disputes/update";
  String DOMAINS$CREATE = "domains/create";
  String DOMAINS$DESTROY = "domains/destroy";
  String DOMAINS$UPDATE = "domains/update";
  String DRAFT_ORDERS$CREATE = "draft_orders/create";
  String DRAFT_ORDERS$DELETE = "draft_orders/delete";
  String DRAFT_ORDERS$UPDATE = "draft_orders/update";
  String FULFILLMENT_EVENTS$CREATE = "fulfillment_events/create";
  String FULFILLMENT_EVENTS$DELETE = "fulfillment_events/delete";
  String FULFILLMENTS$CREATE = "fulfillments/create";
  String FULFILLMENTS$UPDATE = "fulfillments/update";
  String INVENTORY_ITEMS$CREATE = "inventory_items/create";
  String INVENTORY_ITEMS$DELETE = "inventory_items/delete";
  String INVENTORY_ITEMS$UPDATE = "inventory_items/update";
  String INVENTORY_LEVELS$CONNECT = "inventory_levels/connect";
  String INVENTORY_LEVELS$DISCONNECT = "inventory_levels/disconnect";
  String INVENTORY_LEVELS$UPDATE = "inventory_levels/update";
  String LOCALES$CREATE = "locales/create";
  String LOCALES$UPDATE = "locales/update";
  String LOCATIONS$CREATE = "locations/create";
  String LOCATIONS$DELETE = "locations/delete";
  String LOCATIONS$UPDATE = "locations/update";
  String ORDER_TRANSACTIONS$CREATE = "order_transactions/create";
  String ORDERS$CANCELLED = "orders/cancelled";
  String ORDERS$CREATE = "orders/create";
  String ORDERS$DELETE = "orders/delete";
  String ORDERS$EDITED = "orders/edited";
  String ORDERS$FULFILLED = "orders/fulfilled";
  String ORDERS$PAID = "orders/paid";
  String ORDERS$PARTIALLY_FULFILLED = "orders/partially_fulfilled";
  String ORDERS$UPDATED = "orders/updated";
  String PRODUCT_LISTINGS$ADD = "product_listings/add";
  String PRODUCT_LISTINGS$REMOVE = "product_listings/remove";
  String PRODUCT_LISTINGS$UPDATE = "product_listings/update";
  String PRODUCTS$CREATE = "products/create";
  String PRODUCTS$DELETE = "products/delete";
  String PRODUCTS$UPDATE = "products/update";
  String PROFILES$CREATE = "profiles/create";
  String PROFILES$DELETE = "profiles/delete";
  String PROFILES$UPDATE = "profiles/update";
  String REFUNDS$CREATE = "refunds/create";
  String SHOP$UPDATE = "shop/update";
  String SUBSCRIPTION_BILLING_ATTEMPTS$FAILURE = "subscription_billing_attempts/failure";
  String SUBSCRIPTION_BILLING_ATTEMPTS$SUCCESS = "subscription_billing_attempts/success";
  String SUBSCRIPTION_CONTRACTS$CREATE = "subscription_contracts/create";
  String SUBSCRIPTION_CONTRACTS$UPDATE = "subscription_contracts/update";
  String TENDER_TRANSACTIONS$CREATE = "tender_transactions/create";
  String THEMES$CREATE = "themes/create";
  String THEMES$DELETE = "themes/delete";
  String THEMES$PUBLISH = "themes/publish";
  String THEMES$UPDATE = "themes/update";
}
