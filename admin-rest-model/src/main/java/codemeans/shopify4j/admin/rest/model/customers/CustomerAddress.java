package codemeans.shopify4j.admin.rest.model.customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class CustomerAddress {

  private Long id;
  private Long customerId;
  private String firstName;
  private String lastName;
  private String company;
  private String address1;
  private String address2;
  private String city;
  private String province;
  private String country;
  private String zip;
  private String phone;
  private String provinceCode;
  private String countryCode;
  private String countryName;
  @JsonProperty("default")
  private Boolean ifDefault;
}
