package codemeans.shopify4j.rest.admin.model.discounts;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
public class PrerequisiteCondition {

  private BigDecimal greaterThanOrEqualTo;

  private BigDecimal lessThanOrEqualTo;

  private BigDecimal prerequisiteAmount;

  private Long prerequisiteQuantity;
  private Long entitledQuantity;

}
