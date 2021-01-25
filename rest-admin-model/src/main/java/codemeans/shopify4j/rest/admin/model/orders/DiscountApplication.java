package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.enums.AllocationMethod;
import codemeans.shopify4j.rest.admin.model.enums.DiscountApplicationType;
import codemeans.shopify4j.rest.admin.model.enums.DiscountValueType;
import codemeans.shopify4j.rest.admin.model.enums.TargetSelection;
import codemeans.shopify4j.rest.admin.model.enums.TargetType;
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

  /**
   * @see DiscountApplicationType
   */
  private String type;
  private String title;
  private String description;
  private BigDecimal value;
  /**
   * @see DiscountValueType
   */
  private String valueType;
  /**
   * @see AllocationMethod
   */
  private String allocationMethod;
  /**
   * @see TargetSelection
   */
  private String targetSelection;
  /**
   * @see TargetType
   */
  private String targetType;
}
