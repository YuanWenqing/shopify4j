package codemeans.shopify4j.admin.rest.model.events;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.collect.Lists;
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
  private String apiVersion;
  private DateTime createdAt;
  @Setter(AccessLevel.NONE)
  private List<String> fields;

  public Webhook addField(String field) {
    if (fields == null) {
      fields = Lists.newArrayList();
    }
    fields.add(field);
    return this;
  }

  private Format format;

  private Long id;
  private List<String> metafieldNamespaces;

  public Webhook addMetafieldNamespace(String namespace) {
    if (metafieldNamespaces == null) {
      metafieldNamespaces = Lists.newArrayList();
    }
    metafieldNamespaces.add(namespace);
    return this;
  }

  private List<String> privateMetafieldNamespaces;

  public Webhook addPrivateMetafieldNamespace(String namespace) {
    if (privateMetafieldNamespaces == null) {
      privateMetafieldNamespaces = Lists.newArrayList();
    }
    privateMetafieldNamespaces.add(namespace);
    return this;
  }

  /**
   * @see EventTopics
   */
  private String topic;
  private DateTime updated;

  public enum Format {
    json, xml
  }
}
