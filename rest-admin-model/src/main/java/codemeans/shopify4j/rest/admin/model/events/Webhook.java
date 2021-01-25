package codemeans.shopify4j.rest.admin.model.events;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.model.enums.EventTopic;
import codemeans.shopify4j.rest.admin.model.enums.WebhookFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
@Accessors(chain = true)
@JsonRootName("webhook")
public class Webhook {

  private String address;
  @ReadOnly
  private String apiVersion;
  @ReadOnly
  private DateTime createdAt;
  private List<String> fields;
  /**
   * @see WebhookFormat
   */
  private String format;
  @ReadOnly
  private Long id;
  private List<String> metafieldNamespaces;
  private List<String> privateMetafieldNamespaces;
  /**
   * @see EventTopic
   */
  private String topic;
  @ReadOnly
  private DateTime updatedAt;

}
