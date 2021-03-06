package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.annotation.Required;
import codemeans.shopify4j.rest.admin.internal.Utils;
import codemeans.shopify4j.rest.admin.model.common.MoneySet;
import codemeans.shopify4j.rest.admin.model.common.NameValueAttribute;
import codemeans.shopify4j.rest.admin.model.customers.Customer;
import codemeans.shopify4j.rest.admin.model.enums.CancelReason;
import codemeans.shopify4j.rest.admin.model.enums.FinancialStatus;
import codemeans.shopify4j.rest.admin.model.enums.OrderFulfillmentStatus;
import codemeans.shopify4j.rest.admin.model.enums.ProcessingMethod;
import codemeans.shopify4j.rest.admin.model.shipping.Fulfillment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@JsonRootName("order")
public class Order {

  @ReadOnly
  private String appId;
  private OrderAddress billingAddress;
  @ReadOnly
  private String browserIp;
  private Boolean buyerAcceptsMarketing;
  /**
   * @see CancelReason
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
  private List<AppliedDiscountCode> discountCodes;
  private String email;
  /**
   * @see FinancialStatus
   */
  private String financialStatus;
  private List<Fulfillment> fulfillments;
  /**
   * @see OrderFulfillmentStatus
   */
  private String fulfillmentStatus;
  @Deprecated
  private String gateway;
  @ReadOnly
  private Long id;
  @ReadOnly
  private String landingSite;
  @Required
  private List<LineItem> lineItems;
  private Long locationId;
  private String name;
  private String note;
  private List<NameValueAttribute> noteAttributes;
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
   * @see ProcessingMethod
   */
  @ReadOnly
  private String processingMethod;
  private String referringSite;
  @ReadOnly
  private List<Refund> refunds;
  private OrderAddress shippingAddress;
  private List<ShippingLine> shippingLines;
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

  private List<TaxLine> taxLines;
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
