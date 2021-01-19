package codemeans.shopify4j.admin.rest.model.orders;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
@JsonRootName("draft_order_invoice")
public class DraftOrderInvoice {

  private String to;
  private String from;
  @Setter(AccessLevel.NONE)
  private List<String> bcc;

  public DraftOrderInvoice addBcc(String bccAddress) {
    if (bcc == null) {
      bcc = new ArrayList<>();
    }
    bcc.add(bccAddress);
    return this;
  }

  private String subject;
  private String customMessage;
}
