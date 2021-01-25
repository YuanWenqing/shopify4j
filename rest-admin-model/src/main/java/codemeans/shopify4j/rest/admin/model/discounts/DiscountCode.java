package codemeans.shopify4j.rest.admin.model.discounts;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.annotation.Required;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
@JsonRootName("discount_code")
public class DiscountCode {

  @Required
  private String code;
  @ReadOnly
  private DateTime createdAt;
  @ReadOnly
  private DateTime updatedAt;
  @ReadOnly
  private Long id;
  @ReadOnly
  private Long priceRuleId;
  @ReadOnly
  private Integer usageCount;
}
