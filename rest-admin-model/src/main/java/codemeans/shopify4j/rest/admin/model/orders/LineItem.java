package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.common.MoneySet;
import codemeans.shopify4j.rest.admin.model.common.NameValueAttribute;
import codemeans.shopify4j.rest.admin.model.enums.ItemFulfillmentStatus;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class LineItem {

  private Boolean custom;
  private Integer fulfillableQuantity;
  private String fulfillmentService;
  /**
   * @see ItemFulfillmentStatus
   */
  private String fulfillmentStatus;
  private Integer grams;
  private Long id;
  private BigDecimal price;
  private MoneySet priceSet;
  private Long productId;
  private Boolean productExists;
  private Integer quantity;
  private Boolean requiresShipping;
  private String sku;
  private String title;
  private Long variantId;
  private String variantTitle;
  private String variantInventoryManagement;
  private String vendor;
  private String name;
  private Boolean giftCard;
  private List<NameValueAttribute> properties;
  private Boolean taxable;
  private List<TaxLine> taxLines;
  private AppliedDiscount appliedDiscount;
  private String tipPaymentGateway;
  private String tipPaymentMethod;
  private BigDecimal totalDiscount;
  private MoneySet totalDiscountSet;
  private List<DiscountAllocation> discountAllocations;
  private OriginLocation originLocation;
  private List<Duty> duties;

  @Data
  @Accessors(chain = true)
  public static class OriginLocation {

    private Long id;
    private String countryCode;
    private String provinceCode;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String zip;
  }

}
