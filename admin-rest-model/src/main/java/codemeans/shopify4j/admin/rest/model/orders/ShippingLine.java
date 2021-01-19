package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.model.common.MoneySet;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
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
  private List<TaxLine> taxLines;
  private String carrierIdentifier;
  private String requestedFulfillmentServiceId;
}
