package codemeans.shopify4j.admin.rest.model.discounts;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
@JsonRootName("discount_code_creation")
public class DiscountCodeCreation {

  private Long id;
  private Long priceRuleId;
  private DateTime startedAt;
  private DateTime completedAt;
  private DateTime createdAt;
  private DateTime updatedAt;
  private String status;
  private Integer codesCount;
  private Integer importedCount;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.DiscountCodeCreationStatus
   */
  private Integer failedCount;
  private List<String> logs;

}
