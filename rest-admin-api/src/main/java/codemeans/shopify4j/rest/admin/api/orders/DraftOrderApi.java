package codemeans.shopify4j.rest.admin.api.orders;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.DraftOrderStatus;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrder;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrderInvoice;
import codemeans.shopify4j.rest.admin.model.orders.DraftOrderList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public interface DraftOrderApi {

  HttpResponse<DraftOrder> create(DraftOrder req) throws HttpResponseException;

  HttpResponse<DraftOrder> update(long id, DraftOrder req) throws HttpResponseException;

  HttpResponse<DraftOrderList> list(ListReq req) throws HttpResponseException;

  HttpResponse<DraftOrder> get(long id) throws HttpResponseException;

  HttpResponse<Count> count(CountReq req) throws HttpResponseException;

  HttpResponse<DraftOrder> sendInvoice(long id, DraftOrderInvoice req) throws HttpResponseException;

  HttpResponse<String> delete(long id) throws HttpResponseException;

  HttpResponse<DraftOrder> complete(long id, Boolean paymentPending) throws HttpResponseException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private List<Long> ids;
    private Integer limit;
    private Long sinceId;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    /**
     * @see DraftOrderStatus
     */
    private String status;
    private List<String> fields;
  }

  @Data
  @Accessors(chain = true)
  class CountReq {

    private Long sinceId;
    /**
     * @see DraftOrderStatus
     */
    private String status;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
  }

}
