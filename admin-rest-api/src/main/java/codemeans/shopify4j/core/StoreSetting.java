package codemeans.shopify4j.core;

import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2020-08-26
 */
@Data
public class StoreSetting {

  /**
   * store domain, format like {@code your-shop.myshopify.com}
   */
  private String storeDomain;
  private String apiVersion = "2021-01";
  private String apiKey;
  private String password;

}
