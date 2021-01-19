package codemeans.shopify4j.admin.rest.api.orders;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrder;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrderInvoice;
import codemeans.shopify4j.admin.rest.model.orders.DraftOrderList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
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

  DraftOrder sendInvoice(long id, DraftOrderInvoice req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  DraftOrder complete(long id, Boolean paymentPending) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private List<Long> ids;
    private Integer limit;
    private Long sinceId;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    /**
     * @see codemeans.shopify4j.admin.rest.model.enums.DraftOrderStatus
     */
    private String status;
    private List<String> fields;
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

}
