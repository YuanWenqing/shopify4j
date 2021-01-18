package codemeans.shopify4j.admin.rest.model.orders;

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

  private String appId;
  private OrderAddress billingAddress;
  private String browserIp;
  private Boolean buyerAcceptsMarketing;
  private CancelReason cancelReason;
  @Setter(AccessLevel.NONE)
  private DateTime cancelledAt;
  private String cartToken;
  private String checkoutToken;
  private ClientDetails clientDetails;
  @Setter(AccessLevel.NONE)
  private DateTime closedAt;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private String currency;
  private BigDecimal currentTotalDiscount;
  private MoneySet currentTotalDiscountsSet;
  private MoneySet currentTotalDutiesSet;
  private BigDecimal currentTotalPrice;
  private MoneySet currentTotalPriceSet;
  private BigDecimal currentSubtotalPrice;
  private MoneySet currentSubtotalPriceSet;
  private BigDecimal currentTotalTax;
  private MoneySet currentTotalTaxSet;
  private Customer customer;
  private String customerLocale;
  @Setter(AccessLevel.NONE)
  private List<DiscountApplication> discountApplications;

  public Order addDiscountApplication(DiscountApplication discountApplication) {
    this.discountApplications.add(discountApplication);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<AppliedDiscountCode> appliedDiscountCodes;

  public Order addAppliedDiscountCode(AppliedDiscountCode appliedDiscountCode) {
    this.appliedDiscountCodes.add(appliedDiscountCode);
    return this;
  }

  private String email;
  private FinancialStatus financialStatus;

  @Setter(AccessLevel.NONE)
  private List<Fulfillment> fulfillments;

  public Order addFulfillment(Fulfillment fulfillment) {
    this.fulfillments.add(fulfillment);
    return this;
  }

  private OrderFulfillmentStatus fulfillmentStatus;
  private Long id;
  private String landingSite;
  @Setter(AccessLevel.NONE)
  private final List<LineItem> lineItems = new ArrayList<>();

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

  @Setter(AccessLevel.NONE)
  private Integer number;
  @Setter(AccessLevel.NONE)
  private Long orderNumber;
  private MoneySet originalTotalDutiesSet;
  @Setter(AccessLevel.NONE)
  private List<String> paymentGatewayNames;

  public Order addPaymentGatewayName(String paymentGatewayName) {
    this.paymentGatewayNames.add(paymentGatewayName);
    return this;
  }

  private String phone;
  private String presentmentCurrency;
  @Setter(AccessLevel.NONE)
  private DateTime processedAt;
  private ProcessingMethod processingMethod;
  private String referringSite;
  @Setter(AccessLevel.NONE)
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
  @Setter(AccessLevel.NONE)
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
  @Setter(AccessLevel.NONE)
  private BigDecimal totalTipReceived;
  private Integer totalWeight;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  private Long userId;
  @Setter(AccessLevel.NONE)
  private String orderStatusUrl;
}
