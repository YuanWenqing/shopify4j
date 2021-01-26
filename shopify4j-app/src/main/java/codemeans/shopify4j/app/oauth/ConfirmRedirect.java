package codemeans.shopify4j.app.oauth;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * receive data after user confirm: https://shopify.dev/tutorials/authenticate-with-oauth
 *
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Data
@Accessors(chain = true)
public class ConfirmRedirect {

  private String code;
  private String state;
  /**
   * hostname of store ending with {@code .myshopify.com}
   */
  private String shop;
  private String hmac;
  private String timestamp;
}
