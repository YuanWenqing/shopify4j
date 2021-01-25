package codemeans.shopify4j.rest.admin.model.orders;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
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
  private List<String> bcc;
  private String subject;
  private String customMessage;
}
