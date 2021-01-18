package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.common.Money;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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

  @Setter(AccessLevel.NONE)
  private List<TaxLine> taxLines;

  public Duty addTaxLine(TaxLine taxLine) {
    if (taxLines == null) {
      taxLines = new ArrayList<>();
    }
    taxLines.add(taxLine);
    return this;
  }

  private String adminGraphqlApiId;
}
