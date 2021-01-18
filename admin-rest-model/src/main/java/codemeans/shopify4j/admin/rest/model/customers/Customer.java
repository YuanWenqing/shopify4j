package codemeans.shopify4j.admin.rest.model.customers;

import codemeans.shopify4j.admin.rest.model.Metafield;
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
@JsonRootName("customer")
public class Customer {

  private static final String COMMA = ",";

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
  public Customer setTags(String tags) {
    if (StringUtils.isNotBlank(tags)) {
      this.tags = Lists.newArrayList(Splitter.on(COMMA).trimResults().splitToList(tags));
    }
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
