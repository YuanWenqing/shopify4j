package codemeans.shopify4j.admin.rest.model.discounts;

import codemeans.shopify4j.admin.rest.annotation.Required;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  private Long id;
  private Long priceRuleId;
  @Setter(AccessLevel.NONE)
  private Integer usageCount;
}
