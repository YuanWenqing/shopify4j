package codemeans.shopify4j.admin.rest.model.events;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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
  @Setter(AccessLevel.NONE)
  private List<String> fields;

  public Webhook addField(String field) {
    if (fields == null) {
      fields = new ArrayList<>();
    }
    fields.add(field);
    return this;
  }

  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.WebhookFormat
   */
  private String format;
  @ReadOnly
  private Long id;
  private List<String> metafieldNamespaces;

  public Webhook addMetafieldNamespace(String namespace) {
    if (metafieldNamespaces == null) {
      metafieldNamespaces = new ArrayList<>();
    }
    metafieldNamespaces.add(namespace);
    return this;
  }

  private List<String> privateMetafieldNamespaces;

  public Webhook addPrivateMetafieldNamespace(String namespace) {
    if (privateMetafieldNamespaces == null) {
      privateMetafieldNamespaces = new ArrayList<>();
    }
    privateMetafieldNamespaces.add(namespace);
    return this;
  }

  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.EventTopic
   */
  private String topic;
  @ReadOnly
  private DateTime updatedAt;

}
