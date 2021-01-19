package codemeans.shopify4j.admin.rest.model.metafield;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import codemeans.shopify4j.admin.rest.annotation.Required;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/metafield
 */
@Data
@Accessors(chain = true)
@JsonRootName("metafield")
public class Metafield {

  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @ReadOnly
  private DateTime createdAt;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @ReadOnly
  private DateTime updatedAt;
  private String description;
  @ReadOnly
  private Long id;
  @Required
  private String key;
  @Required
  private String namespace;
  private String ownerId;
  private String ownerResource;
  @Required
  private String value;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.MetafieldValueType
   */
  @Required
  private String valueType;

}
