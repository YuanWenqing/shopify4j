package codemeans.shopify4j.core.store;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Data
@Accessors(chain = true)
public class PrivateApp {

  private String name;
  private String adminApiKey;
  private String adminApiPassword;
  private String storefrontAccessToken;

}
