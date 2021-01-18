package codemeans.shopify4j.admin.rest.model.orders;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class PaymentDetails {

  private String avsResultCode;
  private String creditCardBin;
  private String cvvResultCode;
  private String creditCardNumber;
  private String creditCardCompany;
}
