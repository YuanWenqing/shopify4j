package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.common.MoneySet;
import codemeans.shopify4j.rest.admin.model.enums.RestockType;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class RefundLineItem {

  private Long id;
  private LineItem lineItem;
  private Long lineItemId;
  private Integer quantity;
  private Long locationId;
  /**
   * @see RestockType
   */
  private String restockType;
  private BigDecimal subtotal;
  private BigDecimal totalTax;
  private MoneySet subtotalSet;
  private MoneySet totalTaxSet;

}
