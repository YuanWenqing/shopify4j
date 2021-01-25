package codemeans.shopify4j.admin.rest.model.events;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
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
   * @see codemeans.shopify4j.admin.rest.model.enums.WebhookFormat
   */
  private String format;
  @ReadOnly
  private Long id;
  private List<String> metafieldNamespaces;
  private List<String> privateMetafieldNamespaces;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.EventTopic
   */
  private String topic;
  @ReadOnly
  private DateTime updatedAt;

}
