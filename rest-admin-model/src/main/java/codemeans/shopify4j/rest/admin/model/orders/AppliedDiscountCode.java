package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.enums.DiscountType;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class AppliedDiscountCode {

  private String code;
  private BigDecimal amount;
  /**
   * @see DiscountType
   */
  private String type;

}
