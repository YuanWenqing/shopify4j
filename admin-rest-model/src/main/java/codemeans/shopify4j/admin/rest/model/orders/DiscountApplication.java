package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.discounts.AllocationMethod;
import codemeans.shopify4j.admin.rest.model.discounts.DiscountValueType;
import codemeans.shopify4j.admin.rest.model.discounts.TargetSelection;
import codemeans.shopify4j.admin.rest.model.discounts.TargetType;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class DiscountApplication {

  private DiscountApplicationType type;
  private String title;
  private String description;
  private BigDecimal value;
  private DiscountValueType valueType;
  private AllocationMethod allocationMethod;
  private TargetSelection targetSelection;
  private TargetType targetType;
}
