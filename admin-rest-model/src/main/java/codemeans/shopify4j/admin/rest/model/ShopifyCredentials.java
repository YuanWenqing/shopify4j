package codemeans.shopify4j.admin.rest.model;

import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2020-08-26
 */
@Data
public class ShopifyCredentials {

  private final String subDomain;
  private final String apiKey;
  private final String password;
}
