package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
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
  private List<RefundLineItem> refundLineItems;

  public Refund addRefundLineItem(RefundLineItem refundLineItem) {
    if (refundLineItems == null) {
      refundLineItems = new ArrayList<>();
    }
    this.refundLineItems.add(refundLineItem);
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
