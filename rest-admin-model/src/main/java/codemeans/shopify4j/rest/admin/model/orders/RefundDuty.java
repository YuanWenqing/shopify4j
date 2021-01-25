package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.enums.RefundType;
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
   * @see RefundType
   */
  private String refundType;
}
