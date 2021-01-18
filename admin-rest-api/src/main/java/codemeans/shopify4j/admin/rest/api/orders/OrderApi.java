package codemeans.shopify4j.admin.rest.api.orders;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.orders.Order;
import codemeans.shopify4j.core.exception.ShopifyServerException;
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

  Order cancel(long id) throws ShopifyServerException;

  Order create(Order req) throws ShopifyServerException;

  Order update(Order req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  @Data
  class OrderList {

    private List<Order> orders;
  }

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

}
