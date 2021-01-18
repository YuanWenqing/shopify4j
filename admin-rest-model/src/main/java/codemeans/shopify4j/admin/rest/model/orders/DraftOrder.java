package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.common.NameValueAttribute;
import codemeans.shopify4j.admin.rest.model.customers.Customer;
import codemeans.shopify4j.admin.rest.model.customers.TaxExemption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
@JsonRootName("draft_order")
public class DraftOrder {

  private static final String COMMA = ",";

  private Long id;
  private Long orderId;
  private String name;
  private Customer customer;
  private OrderAddress shippingAddress;
  private OrderAddress billingAddress;
  private String note;
  @Setter(AccessLevel.NONE)
  private List<NameValueAttribute> noteAttributes;

  public DraftOrder addNoteAttribute(NameValueAttribute attribute) {
    if (noteAttributes == null) {
      noteAttributes = new ArrayList<>();
    }
    this.noteAttributes.add(attribute);
    return this;
  }

  private String email;
  private String currency;
  @Setter(AccessLevel.NONE)
  private DateTime invoiceSentAt;
  private String invoiceUrl;

  @Setter(AccessLevel.NONE)
  private final List<LineItem> lineItems = new ArrayList<>();

  public DraftOrder addLineItem(LineItem lineItem) {
    this.lineItems.add(lineItem);
    return this;
  }

  private ShippingLine shippingLine;

  @JsonIgnore
  private List<String> tags;

  public DraftOrder addTag(String tag) {
    if (tags == null) {
      this.tags = Lists.newArrayList();
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
    if (tags == null) {
      return null;
    }
    return StringUtils.join(tags, COMMA);
  }

  @JsonProperty("tags")
  public DraftOrder setTags(String tags) {
    if (StringUtils.isNotBlank(tags)) {
      this.tags = Lists.newArrayList(Splitter.on(COMMA).trimResults().splitToList(tags));
    }
    return this;
  }

  private Boolean taxExempt;
  @Setter(AccessLevel.NONE)
  private List<TaxExemption> taxExemptions;

  private DraftOrder addTaxExemption(TaxExemption taxExemption) {
    if (taxExemptions == null) {
      taxExemptions = new ArrayList<>();
    }
    this.taxExemptions.add(taxExemption);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<TaxLine> taxLines;

  public DraftOrder addTaxLine(TaxLine taxLine) {
    if (taxLines == null) {
      taxLines = new ArrayList<>();
    }
    taxLines.add(taxLine);
    return this;
  }

  private AppliedDiscount appliedDiscount;
  private Boolean taxIncluded;
  private BigDecimal totalTax;
  private BigDecimal subtotalPrice;
  private BigDecimal totalPrice;
  @Setter(AccessLevel.NONE)
  private DateTime completedAt;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  private DraftOrderStatus status;

  @Data
  @Accessors(chain = true)
  public static class ShippingLine {

    private String handle;
    private BigDecimal price;
    private String title;
    private Boolean custom;
  }
}
