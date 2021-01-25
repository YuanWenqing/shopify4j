package codemeans.shopify4j.admin.rest.model.orders;

import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class ExtendedAuthorizationAttributes {

  private DateTime standardAuthorizationExpiresAt;
  private DateTime extendedAuthorizationExpiresAt;
}
