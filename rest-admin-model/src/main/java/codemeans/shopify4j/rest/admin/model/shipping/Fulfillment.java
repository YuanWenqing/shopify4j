package codemeans.shopify4j.rest.admin.model.shipping;

import codemeans.shopify4j.rest.admin.model.enums.FulfillmentStatus;
import codemeans.shopify4j.rest.admin.model.enums.ShipmentStatus;
import codemeans.shopify4j.rest.admin.model.orders.LineItem;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
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
  private List<LineItem> lineItems;
  private Long locationId;
  private String name;
  private Boolean notifyCustomer;
  private Long orderId;
  private Receipt receipt;
  private String service;
  /**
   * @see ShipmentStatus
   */
  private String shipmentStatus;
  /**
   * @see FulfillmentStatus
   */
  private String status;
  private String trackingCompany;
  private List<String> trackingNumbers;
  private List<String> trackingUrls;
  private DateTime updatedAt;
  private String variantInventoryManagement;
}
