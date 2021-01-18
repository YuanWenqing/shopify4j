package codemeans.shopify4j.admin.rest.api.orders;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.orders.Order;
import codemeans.shopify4j.admin.rest.model.orders.OrderList;
import codemeans.shopify4j.admin.rest.model.orders.Refund;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public interface OrderApi {

  OrderList list(ListReq req) throws ShopifyServerException;

  Order get(long id) throws ShopifyServerException;

  Count count(CountReq req) throws ShopifyServerException;

  Order close(long id) throws ShopifyServerException;

  Order open(long id) throws ShopifyServerException;

  Order cancel(long id, CancelReq req) throws ShopifyServerException;

  Order create(Order req) throws ShopifyServerException;

  Order update(long id, Order req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

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
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime processedAtMin;
    private DateTime processedAtMax;
    private String attributionAppId;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.OrderStatus
     */
    private String status;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.FinancialStatus
     */
    private String financialStatus;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.OrderListFulfillmentStatus
     */
    private String fulfillmentStatus;

    private final List<String> fields = new ArrayList<>();

    public ListReq addField(String field) {
      this.fields.add(field);
      return this;
    }
  }

  @Data
  @Accessors(chain = true)
  class CountReq {

    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.OrderStatus
     */
    private String status;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.FinancialStatus
     */
    private String financialStatus;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.OrderListFulfillmentStatus
     */
    private String fulfillmentStatus;
  }

  @Data
  class CancelReq {

    private BigDecimal amount;
    private String currency;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.CancelReason
     */
    private String reason;
    private Boolean email;
    private Refund refund;
  }
}
