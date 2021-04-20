package codemeans.shopify4j.core.base;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * a wrapper class for whole data of event
 *
 * @author: yuanwq
 * @date: 2021-02-01
 */
@Data
@Accessors(chain = true)
public class WebhookEvent<D> {

  private String topic;
  /**
   * sha256
   */
  private String hmac;
  private String shopDomain;
  private String apiVersion;
  private String webhookId;

  /**
   * event data
   */
  private D data;
}
