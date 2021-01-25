package codemeans.shopify4j.rest.admin.model.enums;

import codemeans.shopify4j.rest.admin.internal.ShopifyEnum;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum ShipmentStatus implements ShopifyEnum<ShipmentStatus> {
  label_printed,
  label_purchased,
  attempted_delivery,
  ready_for_pickup,
  confirmed,
  in_transit,
  out_for_delivery,
  delivered,
  failure
}
