package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.common.MoneySet;
import codemeans.shopify4j.rest.admin.model.enums.OrderAdjustmentKind;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class OrderAdjustment {

  private Long id;
  private Long orderId;
  private Long refundId;
  private BigDecimal amount;
  private BigDecimal taxAmount;
  /**
   * @see OrderAdjustmentKind
   */
  private String kind;
  private String reason;
  private MoneySet amountSet;
  private MoneySet taxAmountSet;
}
