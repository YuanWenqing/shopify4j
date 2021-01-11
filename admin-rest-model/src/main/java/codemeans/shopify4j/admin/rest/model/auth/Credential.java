package codemeans.shopify4j.admin.rest.model.auth;

import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2020-08-26
 */
@Data
public class Credential {

  /**
   * store domain, format like {@code your-shop.myshopify.com}
   */
  private final String storeDomain;
  private final String apiKey;
  private final String password;
}
