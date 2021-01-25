package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.internal.Utils;
import codemeans.shopify4j.rest.admin.model.common.NameValueAttribute;
import codemeans.shopify4j.rest.admin.model.customers.Customer;
import codemeans.shopify4j.rest.admin.model.enums.DraftOrderStatus;
import codemeans.shopify4j.rest.admin.model.enums.TaxExemption;
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
@JsonRootName("draft_order")
public class DraftOrder {

  private Long id;
  private Long orderId;
  private String name;
  private Customer customer;
  private OrderAddress shippingAddress;
  private OrderAddress billingAddress;
  private String note;
  private List<NameValueAttribute> noteAttributes;
  private String email;
  private String currency;
  private DateTime invoiceSentAt;
  private String invoiceUrl;
  private List<LineItem> lineItems;
  private ShippingLine shippingLine;

  @JsonIgnore
  private List<String> tags;

  public DraftOrder addTag(String tag) {
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
  public DraftOrder setTags(String tags) {
    this.tags = Utils.splitTags(tags);
    return this;
  }

  private Boolean taxExempt;
  /**
   * @see TaxExemption
   */
  private List<String> taxExemptions;
  private List<TaxLine> taxLines;
  private AppliedDiscount appliedDiscount;
  private Boolean taxIncluded;
  private BigDecimal totalTax;
  private BigDecimal subtotalPrice;
  private BigDecimal totalPrice;
  private DateTime completedAt;
  private DateTime createdAt;
  private DateTime updatedAt;
  /**
   * @see DraftOrderStatus
   */
  private String status;

  @Data
  @Accessors(chain = true)
  public static class ShippingLine {

    private String handle;
    private BigDecimal price;
    private String title;
    private Boolean custom;
  }
}
