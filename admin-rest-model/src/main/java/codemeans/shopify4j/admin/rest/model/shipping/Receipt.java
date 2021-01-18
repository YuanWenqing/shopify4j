package codemeans.shopify4j.admin.rest.model.shipping;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class Receipt {

  private Boolean testcase;
  private String authorization;
}
