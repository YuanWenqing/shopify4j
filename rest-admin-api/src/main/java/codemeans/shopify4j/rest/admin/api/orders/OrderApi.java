package codemeans.shopify4j.rest.admin.api.orders;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.CancelReason;
import codemeans.shopify4j.rest.admin.model.enums.FinancialStatus;
import codemeans.shopify4j.rest.admin.model.enums.OrderListFulfillmentStatus;
import codemeans.shopify4j.rest.admin.model.enums.OrderStatus;
import codemeans.shopify4j.rest.admin.model.orders.Order;
import codemeans.shopify4j.rest.admin.model.orders.OrderList;
import codemeans.shopify4j.rest.admin.model.orders.Refund;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public interface OrderApi {

  HttpResponse<OrderList> list(ListReq req) throws HttpResponseException;

  HttpResponse<Order> get(long id) throws HttpResponseException;

  HttpResponse<Count> count(CountReq req) throws HttpResponseException;

  HttpResponse<Order> close(long id) throws HttpResponseException;

  HttpResponse<Order> open(long id) throws HttpResponseException;

  HttpResponse<Order> cancel(long id, CancelReq req) throws HttpResponseException;

  HttpResponse<Order> create(Order req) throws HttpResponseException;

  HttpResponse<Order> update(long id, Order req) throws HttpResponseException;

  HttpResponse<String> delete(long id) throws HttpResponseException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private List<Long> ids;
    private Integer limit;
    private Long sinceId;
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime processedAtMin;
    private DateTime processedAtMax;
    private String attributionAppId;
    /**
     * @see OrderStatus
     */
    private String status;
    /**
     * @see FinancialStatus
     */
    private String financialStatus;
    /**
     * @see OrderListFulfillmentStatus
     */
    private String fulfillmentStatus;
    private List<String> fields;

  }

  @Data
  @Accessors(chain = true)
  class CountReq {

    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    /**
     * @see OrderStatus
     */
    private String status;
    /**
     * @see FinancialStatus
     */
    private String financialStatus;
    /**
     * @see OrderListFulfillmentStatus
     */
    private String fulfillmentStatus;
  }

  @Data
  class CancelReq {

    private BigDecimal amount;
    private String currency;
    /**
     * @see CancelReason
     */
    private String reason;
    private Boolean email;
    private Refund refund;
  }
}
