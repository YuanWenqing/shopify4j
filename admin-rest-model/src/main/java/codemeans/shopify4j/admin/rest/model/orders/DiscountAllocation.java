package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.common.MoneySet;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class DiscountAllocation {

  private BigDecimal amount;
  private Integer discountApplicationIndex;
  private MoneySet amountSet;
}
