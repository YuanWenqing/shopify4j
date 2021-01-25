package codemeans.shopify4j.admin.rest.model.discounts;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
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
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
@JsonRootName("price_rule")
public class PriceRule {

  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.AllocationMethod
   */
  private String allocationMethod;
  @ReadOnly
  private DateTime createdAt;
  @ReadOnly
  private DateTime updatedAt;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.CustomerSelection
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
   * @see codemeans.shopify4j.admin.rest.model.enums.TargetSelection
   */
  private String targetSelection;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TargetType
   */
  private String targetType;
  private String title;
  private Integer usageLimit;

  private BigDecimal value;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.DiscountValueType
   */
  private String valueType;
  private Integer allocationLimit;

}
