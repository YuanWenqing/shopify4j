package codemeans.shopify4j.admin.rest.api.orders;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrder;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrderList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public interface DraftOrderApi {

  DraftOrder create(DraftOrder req) throws ShopifyServerException;

  DraftOrder update(long id, DraftOrder req) throws ShopifyServerException;

  DraftOrderList list(ListReq req) throws ShopifyServerException;

  DraftOrder get(long id) throws ShopifyServerException;

  Count count(CountReq req) throws ShopifyServerException;

  DraftOrder sendInvoice(long id, SendInvoiceReq req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  DraftOrder complete(long id, Boolean paymentPending) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private final List<Long> ids = new ArrayList<>();

    public ListReq addId(long id) {
      this.ids.add(id);
      return this;
    }

    private Integer limit;
    private Long sinceId;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.DraftOrderStatus
     */
    private String status;
    private final List<String> fields = new ArrayList<>();

    public ListReq addField(String field) {
      this.fields.add(field);
      return this;
    }
  }

  @Data
  @Accessors(chain = true)
  class CountReq {

    private Long sinceId;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.DraftOrderStatus
     */
    private String status;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
  }

  @Data
  @JsonRootName("draft_order_invoice")
  class SendInvoiceReq {

    private String to;
    private String from;
    private final List<String> bcc = new ArrayList<>();
    private String subject;
    private String customMessage;
  }
}
