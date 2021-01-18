package codemeans.shopify4j.admin.rest.model.orders;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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

  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  @Setter(AccessLevel.NONE)
  private List<Duty> duties;

  public Refund addDuty(Duty duty) {
    if (duties == null) {
      duties = new ArrayList<>();
    }
    duties.add(duty);
    return this;
  }

  private Long id;
  private String note;
  @Setter(AccessLevel.NONE)
  private List<OrderAdjustment> orderAdjustments;

  public Refund addOrderAdjustment(OrderAdjustment orderAdjustment) {
    if (orderAdjustments == null) {
      orderAdjustments = new ArrayList<>();
    }
    this.orderAdjustments.add(orderAdjustment);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private DateTime processedAt;
  @Setter(AccessLevel.NONE)
  private List<RefundDuty> refundDuties;

  public Refund addRefundDuty(RefundDuty refundDuty) {
    if (refundDuties == null) {
      refundDuties = new ArrayList<>();
    }
    refundDuties.add(refundDuty);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Transaction> transactions;

  public Refund addTransaction(Transaction transaction) {
    if (transactions == null) {
      transactions = new ArrayList<>();
    }
    this.transactions.add(transaction);
    return this;
  }

  private Long userId;
}
