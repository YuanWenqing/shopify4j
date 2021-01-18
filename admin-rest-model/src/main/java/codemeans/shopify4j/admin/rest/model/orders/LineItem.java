package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.common.MoneySet;
import codemeans.shopify4j.admin.rest.model.common.NameValueAttribute;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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
   * @see codemeans.shopify4j.admin.rest.model.enums.ItemFulfillmentStatus
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
  @Setter(AccessLevel.NONE)
  private List<NameValueAttribute> properties;

  public LineItem addProperty(NameValueAttribute attribute) {
    if (properties == null) {
      properties = new ArrayList<>();
    }
    this.properties.add(attribute);
    return this;
  }

  private Boolean taxable;

  @Setter(AccessLevel.NONE)
  private List<TaxLine> taxLines;

  public LineItem addTaxLine(TaxLine taxLine) {
    if (taxLines == null) {
      taxLines = new ArrayList<>();
    }
    taxLines.add(taxLine);
    return this;
  }

  private AppliedDiscount appliedDiscount;

  private String tipPaymentGateway;
  private String tipPaymentMethod;
  private BigDecimal totalDiscount;
  private MoneySet totalDiscountSet;
  @Setter(AccessLevel.NONE)
  private List<DiscountAllocation> discountAllocations;

  public LineItem addDiscountAllocation(DiscountAllocation discountAllocation) {
    if (discountAllocations == null) {
      discountAllocations = new ArrayList<>();
    }
    discountAllocations.add(discountAllocation);
    return this;
  }

  private OriginLocation originLocation;
  @Setter(AccessLevel.NONE)
  private List<Duty> duties;

  public LineItem addDuty(Duty duty) {
    if (duties == null) {
      duties = new ArrayList<>();
    }
    duties.add(duty);
    return this;
  }

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
