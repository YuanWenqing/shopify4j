package codemeans.shopify4j.rest.admin.model.metafield;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.annotation.Required;
import codemeans.shopify4j.rest.admin.model.enums.MetafieldValueType;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
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
   * @see MetafieldValueType
   */
  @Required
  private String valueType;

}
