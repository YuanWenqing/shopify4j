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
  @Setter(AccessLevel.NONE)
  private List<Long> entitledCollectionIds;

  public PriceRule addEntitledCollectionId(long collectionId) {
    if (entitledCollectionIds == null) {
      entitledCollectionIds = new ArrayList<>();
    }
    entitledCollectionIds.add(collectionId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> entitledCountryIds;

  public PriceRule addEntitledCountryId(long countryId) {
    if (entitledCountryIds == null) {
      entitledCountryIds = new ArrayList<>();
    }
    entitledCountryIds.add(countryId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> entitledProductIds;

  public PriceRule addEntitledProductId(long productId) {
    if (entitledProductIds == null) {
      entitledProductIds = new ArrayList<>();
    }
    entitledProductIds.add(productId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> entitledVariantIds;

  public PriceRule addEntitledVariantId(long variantId) {
    if (entitledVariantIds == null) {
      entitledVariantIds = new ArrayList<>();
    }
    entitledVariantIds.add(variantId);
    return this;
  }

  @ReadOnly
  private Long id;
  private Boolean oncePerCustomer;
  @Setter(AccessLevel.NONE)
  private List<Long> prerequisiteCustomerIds;

  public PriceRule addPrerequisiteCustomerId(long customerId) {
    if (prerequisiteCustomerIds == null) {
      prerequisiteCustomerIds = new ArrayList<>();
    }
    prerequisiteCustomerIds.add(customerId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> prerequisiteSavedSearchIds;

  public PriceRule addPrerequisiteSavedSearchId(long savedSearchId) {
    if (prerequisiteSavedSearchIds == null) {
      prerequisiteSavedSearchIds = new ArrayList<>();
    }
    prerequisiteSavedSearchIds.add(savedSearchId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> prerequisiteProductIds;

  public PriceRule addPrerequisiteProductId(long productId) {
    if (prerequisiteProductIds == null) {
      prerequisiteProductIds = new ArrayList<>();
    }
    prerequisiteProductIds.add(productId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> prerequisiteVariantIds;

  public PriceRule addPrerequisiteVariantId(long variantId) {
    if (prerequisiteVariantIds == null) {
      prerequisiteVariantIds = new ArrayList<>();
    }
    prerequisiteVariantIds.add(variantId);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Long> prerequisiteCollectionIds;

  public PriceRule addPrerequisiteCollectionId(long collectionId) {
    if (prerequisiteCollectionIds == null) {
      prerequisiteCollectionIds = new ArrayList<>();
    }
    prerequisiteCollectionIds.add(collectionId);
    return this;
  }

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
