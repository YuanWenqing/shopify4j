package codemeans.shopify4j.admin.rest.model.orders;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class OrderAddress {

  private String firstName;
  private String lastName;
  private String company;
  private String address1;
  private String address2;
  private String city;
  private String province;
  private String provinceCode;
  private String country;
  private String countryCode;
  private String zip;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String phone;
  private String name;

}