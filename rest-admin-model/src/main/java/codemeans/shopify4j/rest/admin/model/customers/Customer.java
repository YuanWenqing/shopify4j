package codemeans.shopify4j.rest.admin.model.customers;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.internal.Utils;
import codemeans.shopify4j.rest.admin.model.enums.CustomerState;
import codemeans.shopify4j.rest.admin.model.enums.MarketingOptInLevel;
import codemeans.shopify4j.rest.admin.model.enums.TaxExemption;
import codemeans.shopify4j.rest.admin.model.metafield.Metafield;
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
@JsonRootName("customer")
public class Customer {

  private Boolean acceptsMarketing;
  private DateTime acceptsMarketingUpdatedAt;
  private List<CustomerAddress> addresses;
  @ReadOnly
  private String currency;
  @ReadOnly
  private DateTime createdAt;
  @ReadOnly
  private CustomerAddress defaultAddress;
  private String email;
  private String firstName;
  private Long id;
  private String lastName;
  @ReadOnly
  private Long lastOrderId;
  @ReadOnly
  private String lastOrderName;
  private Metafield metafield;
  /**
   * @see MarketingOptInLevel
   */
  @ReadOnly
  private String marketingOptInLevel;
  private String multipassIdentifier;
  private String note;
  @ReadOnly
  private int ordersCount;
  private String phone;
  /**
   * @see CustomerState
   */
  @ReadOnly
  private String state;
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
  /**
   * @see TaxExemption
   */
  private List<String> taxExemptions;
  @ReadOnly
  private BigDecimal totalSpent;
  @ReadOnly
  private DateTime updatedAt;
  @ReadOnly
  private Boolean verifiedEmail;
}
