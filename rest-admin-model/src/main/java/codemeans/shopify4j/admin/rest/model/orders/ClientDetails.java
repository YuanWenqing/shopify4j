package codemeans.shopify4j.admin.rest.model.orders;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
public class ClientDetails {

  private String acceptLanguage;
  private String browserIp;
  private int browserHeight;
  private int browserWidth;
  private String sessionHash;
  private String userAgent;

}
