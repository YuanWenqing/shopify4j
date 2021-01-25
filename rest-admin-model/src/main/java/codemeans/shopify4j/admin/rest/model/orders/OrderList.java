package codemeans.shopify4j.admin.rest.model.orders;

import java.util.List;
import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
public
class OrderList {

  private List<Order> orders;
}
