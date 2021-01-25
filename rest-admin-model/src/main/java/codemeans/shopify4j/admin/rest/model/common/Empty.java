package codemeans.shopify4j.admin.rest.model.common;

import lombok.Data;

/**
 * empty
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class Empty {

  public static final Empty INSTANCE = new Empty();

  private Empty() {
  }
}
