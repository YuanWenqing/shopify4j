package codemeans.shopify4j.rest.admin.model.orders;

import java.util.List;
import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
public
class DraftOrderList {

  private List<DraftOrder> draftOrders;
}
