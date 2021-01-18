package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.common.MoneySet;
import java.math.BigDecimal;
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
public class ShippingLine {

  private String code;
  private BigDecimal price;
  private MoneySet priceSet;
  private BigDecimal discountedPrice;
  private MoneySet discountedPriceSet;
  private String source;
  private String title;

  @Setter(AccessLevel.NONE)
  private List<TaxLine> taxLines;

  public ShippingLine addTaxLine(TaxLine taxLine) {
    if (taxLines == null) {
      taxLines = new ArrayList<>();
    }
    taxLines.add(taxLine);
    return this;
  }

  private String carrierIdentifier;
  private String requestedFulfillmentServiceId;
}
