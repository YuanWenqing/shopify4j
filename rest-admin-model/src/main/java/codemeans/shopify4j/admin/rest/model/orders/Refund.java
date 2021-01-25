package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
@JsonRootName("refund")
public class Refund {

  @ReadOnly
  private DateTime createdAt;
  @ReadOnly
  private List<Duty> duties;
  @ReadOnly
  private Long id;
  private String note;
  @ReadOnly
  private List<OrderAdjustment> orderAdjustments;
  private DateTime processedAt;
  private List<RefundDuty> refundDuties;
  private List<RefundLineItem> refundLineItems;
  private List<Transaction> transactions;
  private Long userId;
}
