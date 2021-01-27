package codemeans.shopify4j.core.store;

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
  private String myshopifyDomain;
  private PrivateApp privateApp;

}
