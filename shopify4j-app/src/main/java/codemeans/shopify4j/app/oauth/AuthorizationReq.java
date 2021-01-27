package codemeans.shopify4j.app.oauth;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * request for building url of authorization page: https://shopify.dev/tutorials/authenticate-with-oauth
 *
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Data
@Accessors(chain = true)
public class AuthorizationReq {

  /**
   * myshopify domain of store ending with {@code .myshopify.com}
   */
  private String shop;
  private String state;
  /**
   * default offline if blank; set to {@code per-user} for online
   */
  private String accessMode;

}
