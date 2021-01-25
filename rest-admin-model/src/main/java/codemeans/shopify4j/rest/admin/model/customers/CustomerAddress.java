package codemeans.shopify4j.rest.admin.model.customers;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
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
  @ReadOnly
  private String provinceCode;
  private String country;
  @ReadOnly
  private String countryCode;
  private String countryName;
  private String zip;
  private String phone;
  private String name;

  @JsonProperty("default")
  private Boolean ifDefault;
}
