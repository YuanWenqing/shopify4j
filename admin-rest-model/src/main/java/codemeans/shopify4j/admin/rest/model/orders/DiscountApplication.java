package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.enums.TargetType;
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
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.DiscountValueType
   */
  private String valueType;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.AllocationMethod
   */
  private String allocationMethod;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TargetSelection
   */
  private String targetSelection;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TargetType
   */
  private TargetType targetType;
}
