package codemeans.shopify4j.app;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Data
@Accessors(chain = true)
public class PublicApp {

  private String clientId;
  private String clientSecret;
  private String redirectUri;
  /**
   * app required scopes
   */
  private List<String> scopes;


}
