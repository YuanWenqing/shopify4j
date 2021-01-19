package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import codemeans.shopify4j.admin.rest.annotation.Required;
import codemeans.shopify4j.admin.rest.internal.Utils;
import codemeans.shopify4j.admin.rest.model.common.MoneySet;
import codemeans.shopify4j.admin.rest.model.common.NameValueAttribute;
import codemeans.shopify4j.admin.rest.model.customers.Customer;
import codemeans.shopify4j.admin.rest.model.shipping.Fulfillment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
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
@JsonRootName("order")
public class Order {

  @ReadOnly
  private String appId;
  private OrderAddress billingAddress;
  @ReadOnly
  private String browserIp;
  private Boolean buyerAcceptsMarketing;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.CancelReason
   */
  private String cancelReason;
  @ReadOnly
  private DateTime cancelledAt;
  @ReadOnly
  private String cartToken;
  @ReadOnly
  private String checkoutToken;
  @ReadOnly
  private ClientDetails clientDetails;
  @ReadOnly
  private DateTime closedAt;
  @ReadOnly
  private DateTime createdAt;
  private String currency;
  @ReadOnly
  private BigDecimal currentTotalDiscounts;
  @ReadOnly
  private MoneySet currentTotalDiscountsSet;
  @ReadOnly
  private MoneySet currentTotalDutiesSet;
  @ReadOnly
  private BigDecimal currentTotalPrice;
  @ReadOnly
  private MoneySet currentTotalPriceSet;
  @ReadOnly
  private BigDecimal currentSubtotalPrice;
  @ReadOnly
  private MoneySet currentSubtotalPriceSet;
  @ReadOnly
  private BigDecimal currentTotalTax;
  @ReadOnly
  private MoneySet currentTotalTaxSet;
  private Customer customer;
  @ReadOnly
  private String customerLocale;
  @ReadOnly
  private List<DiscountApplication> discountApplications;

  @Setter(AccessLevel.NONE)
  private List<AppliedDiscountCode> discountCodes;

  public Order addAppliedDiscountCode(AppliedDiscountCode discountCode) {
    this.discountCodes.add(discountCode);
    return this;
  }

  private String email;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.FinancialStatus
   */
  private String financialStatus;

  @Setter(AccessLevel.NONE)
  private List<Fulfillment> fulfillments;

  public Order addFulfillment(Fulfillment fulfillment) {
    this.fulfillments.add(fulfillment);
    return this;
  }

  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.OrderFulfillmentStatus
   */
  private String fulfillmentStatus;
  @Deprecated
  private String gateway;
  @ReadOnly
  private Long id;
  @ReadOnly
  private String landingSite;
  @Setter(AccessLevel.NONE)
  @Required
  private final List<LineItem> lineItems = new ArrayList<>();

  @Required
  public Order addLineItem(LineItem lineItem) {
    this.lineItems.add(lineItem);
    return this;
  }

  private Long locationId;
  private String name;
  private String note;
  @Setter(AccessLevel.NONE)
  private List<NameValueAttribute> noteAttributes;

  public Order addNoteAttribute(NameValueAttribute attribute) {
    if (noteAttributes == null) {
      noteAttributes = new ArrayList<>();
    }
    this.noteAttributes.add(attribute);
    return this;
  }

  @ReadOnly
  private Integer number;
  @ReadOnly
  private Long orderNumber;
  @ReadOnly
  private MoneySet originalTotalDutiesSet;
  @ReadOnly
  private List<String> paymentGatewayNames;

  private String phone;
  private String presentmentCurrency;
  private DateTime processedAt;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.ProcessingMethod
   */
  @ReadOnly
  private String processingMethod;
  private String referringSite;
  @ReadOnly
  private List<Refund> refunds;
  private OrderAddress shippingAddress;

  @Setter(AccessLevel.NONE)
  private List<ShippingLine> shippingLines;

  public Order addShippingLine(ShippingLine shippingLine) {
    if (shippingLines == null) {
      shippingLines = new ArrayList<>();
    }
    shippingLines.add(shippingLine);
    return this;
  }

  private String sourceName;
  private BigDecimal subtotalPrice;
  private MoneySet subtotalPriceSet;
  @JsonIgnore
  private List<String> tags;

  public Order addTag(String tag) {
    if (tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tag);
    return this;
  }

  @JsonIgnore
  public List<String> getTagsAsList() {
    return tags;
  }

  @JsonProperty("tags")
  public String getTagsAsText() {
    return Utils.joinTags(tags);
  }

  @JsonProperty("tags")
  public Order setTags(String tags) {
    this.tags = Utils.splitTags(tags);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<TaxLine> taxLines;

  public Order addTaxLine(TaxLine taxLine) {
    if (taxLines == null) {
      taxLines = new ArrayList<>();
    }
    taxLines.add(taxLine);
    return this;
  }

  private Boolean taxesIncluded;
  private Boolean test;
  @ReadOnly
  private String token;
  private BigDecimal totalDiscounts;
  private MoneySet totalDiscountsSet;
  private BigDecimal totalLineItemsPrice;
  private MoneySet totalLineItemsPriceSet;
  private BigDecimal totalOutstanding;
  private BigDecimal totalPrice;
  private MoneySet totalPriceSet;
  private MoneySet totalShippingPriceSet;
  private BigDecimal totalTax;
  private MoneySet totalTaxSet;
  @ReadOnly
  private BigDecimal totalTipReceived;
  private Integer totalWeight;
  @ReadOnly
  private DateTime updatedAt;
  private Long userId;
  @ReadOnly
  private String orderStatusUrl;
}
