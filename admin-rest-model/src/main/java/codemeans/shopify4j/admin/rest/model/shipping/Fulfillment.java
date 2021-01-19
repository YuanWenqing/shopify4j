package codemeans.shopify4j.admin.rest.model.shipping;

import codemeans.shopify4j.admin.rest.model.orders.LineItem;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
@JsonRootName("fulfillment")
public class Fulfillment {

  private DateTime createdAt;
  private Long id;
  @Setter(AccessLevel.NONE)
  private final List<LineItem> lineItems = new ArrayList<>();

  public Fulfillment addLineItem(LineItem lineItem) {
    this.lineItems.add(lineItem);
    return this;
  }

  private Long locationId;
  private String name;
  private Boolean notifyCustomer;
  private Long orderId;
  private Receipt receipt;
  private String service;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.ShipmentStatus
   */
  private String shipmentStatus;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.FulfillmentStatus
   */
  private String status;
  private String trackingCompany;
  @Setter(AccessLevel.NONE)
  private List<String> trackingNumbers;

  public Fulfillment addTrackingNumber(String trackingNumber) {
    this.trackingNumbers.add(trackingNumber);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<String> trackingUrls;

  public Fulfillment addTrackingUrl(String trackingUrl) {
    this.trackingUrls.add(trackingUrl);
    return this;
  }

  private DateTime updatedAt;
  private String variantInventoryManagement;
}
