package codemeans.shopify4j.admin.rest.model.customers;

import codemeans.shopify4j.admin.rest.internal.Utils;
import codemeans.shopify4j.admin.rest.model.common.Metafield;
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
@JsonRootName("customer")
public class Customer {

  private Boolean acceptsMarketing;
  @Setter(AccessLevel.NONE)
  private DateTime acceptsMarketingUpdatedAt;
  @Setter(AccessLevel.NONE)
  private List<CustomerAddress> addresses;

  private Customer addAddress(CustomerAddress address) {
    if (addresses == null) {
      addresses = new ArrayList<>();
    }
    this.addresses.add(address);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private String currency;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  @Setter(AccessLevel.NONE)
  private CustomerAddress defaultAddress;
  private String email;
  private String firstName;
  private Long id;
  private String lastName;
  @Setter(AccessLevel.NONE)
  private Long lastOrderId;
  @Setter(AccessLevel.NONE)
  private String lastOrderName;
  private Metafield metafield;
  @Setter(AccessLevel.NONE)
  private MarketingOptInLevel marketingOptInLevel;
  private String multipassIdentifier;
  private String note;
  @Setter(AccessLevel.NONE)
  private int ordersCount;
  private String phone;
  @Setter(AccessLevel.NONE)
  private CustomerState state;
  @JsonIgnore
  private List<String> tags;

  public Customer addTag(String tag) {
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
  public Customer setTags(String tags) {
    this.tags = Utils.splitTags(tags);
    return this;
  }

  private Boolean taxExempt;
  @Setter(AccessLevel.NONE)
  private List<TaxExemption> taxExemptions;

  private Customer addTaxExemption(TaxExemption taxExemption) {
    if (taxExemptions == null) {
      taxExemptions = new ArrayList<>();
    }
    this.taxExemptions.add(taxExemption);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private BigDecimal totalSpent;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  @Setter(AccessLevel.NONE)
  private Boolean verifiedEmail;
}
