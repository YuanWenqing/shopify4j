package codemeans.shopify4j.rest.admin.model.discounts;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(chain = true)
public class PriceRuleList {

  private List<PriceRule> priceRules;
}
