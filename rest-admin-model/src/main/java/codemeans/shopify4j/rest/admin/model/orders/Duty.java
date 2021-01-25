package codemeans.shopify4j.rest.admin.model.orders;

import codemeans.shopify4j.rest.admin.model.common.Money;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class Duty {

  private Long id;
  private String harmonizedSystemCode;
  private String countryCodeOfOrigin;
  private Money shopMoney;
  private Money presentmentMoney;
  private List<TaxLine> taxLines;
  private String adminGraphqlApiId;
}
