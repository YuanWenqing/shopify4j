package codemeans.shopify4j.admin.rest.model.orders;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class ShippingLine {

  private String handle;
  private BigDecimal price;
  private String title;
  private Boolean custom;
}
