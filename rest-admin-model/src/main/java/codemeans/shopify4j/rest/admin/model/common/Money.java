package codemeans.shopify4j.rest.admin.model.common;

import codemeans.shopify4j.rest.admin.annotation.Required;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Money {

  @Required
  private BigDecimal amount;
  @Required
  private String currencyCode;
}
