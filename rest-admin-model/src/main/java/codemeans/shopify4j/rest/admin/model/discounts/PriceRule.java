package codemeans.shopify4j.rest.admin.model.discounts;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.model.enums.AllocationMethod;
import codemeans.shopify4j.rest.admin.model.enums.CustomerSelection;
import codemeans.shopify4j.rest.admin.model.enums.DiscountValueType;
import codemeans.shopify4j.rest.admin.model.enums.TargetSelection;
import codemeans.shopify4j.rest.admin.model.enums.TargetType;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
@JsonRootName("price_rule")
public class PriceRule {

  /**
   * @see AllocationMethod
   */
  private String allocationMethod;
  @ReadOnly
  private DateTime createdAt;
  @ReadOnly
  private DateTime updatedAt;
  /**
   * @see CustomerSelection
   */
  private String customerSelection;
  private DateTime endsAt;
  private List<Long> entitledCollectionIds;
  private List<Long> entitledCountryIds;
  private List<Long> entitledProductIds;
  private List<Long> entitledVariantIds;
  @ReadOnly
  private Long id;
  private Boolean oncePerCustomer;
  private List<Long> prerequisiteCustomerIds;
  private List<Long> prerequisiteSavedSearchIds;
  private List<Long> prerequisiteProductIds;
  private List<Long> prerequisiteVariantIds;
  private List<Long> prerequisiteCollectionIds;
  @Setter(AccessLevel.NONE)
  private PrerequisiteCondition prerequisiteQuantityRange;

  public PriceRule prerequisiteQuantityRangeGTE(long quantity) {
    prerequisiteQuantityRange = new PrerequisiteCondition()
        .setGreaterThanOrEqualTo(new BigDecimal(quantity));
    return this;
  }

  @Setter(AccessLevel.NONE)
  private PrerequisiteCondition prerequisiteShippingPriceRange;

  public PriceRule prerequisiteShippingPriceRangeLTE(BigDecimal price) {
    prerequisiteShippingPriceRange = new PrerequisiteCondition().setLessThanOrEqualTo(price);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private PrerequisiteCondition prerequisiteSubtotalRange;

  public PriceRule prerequisiteSubtotalRangeGTE(BigDecimal subtotal) {
    prerequisiteSubtotalRange = new PrerequisiteCondition().setGreaterThanOrEqualTo(subtotal);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private PrerequisiteCondition prerequisiteToEntitlementPurchase;

  public PriceRule prerequisiteToEntitlementPurchase(BigDecimal prerequisiteAmount) {
    this.prerequisiteToEntitlementPurchase = new PrerequisiteCondition()
        .setPrerequisiteAmount(prerequisiteAmount);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private PrerequisiteCondition prerequisiteToEntitlementQuantityRatio;

  public PriceRule prerequisiteToEntitlementQuantityRatio(long prerequisiteQuantity,
      long entitledQuantity) {
    this.prerequisiteToEntitlementQuantityRatio = new PrerequisiteCondition()
        .setPrerequisiteQuantity(prerequisiteQuantity)
        .setEntitledQuantity(entitledQuantity);
    return this;
  }

  private DateTime startsAt;
  /**
   * @see TargetSelection
   */
  private String targetSelection;
  /**
   * @see TargetType
   */
  private String targetType;
  private String title;
  private Integer usageLimit;

  private BigDecimal value;
  /**
   * @see DiscountValueType
   */
  private String valueType;
  private Integer allocationLimit;

}
