package codemeans.shopify4j.admin.rest.model.orders;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class RefundDuty {

  private Long dutyId;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.RefundType
   */
  private String refundType;
}
