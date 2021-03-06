package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.enums.DiscountValueType;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class AppliedDiscount {

  private String title;
  private String description;
  private BigDecimal value;
  /**
   * @see DiscountValueType
   */
  private String valueType;
  private BigDecimal amount;

}
