package codemeans.shopify4j.admin.rest.model.common;

import codemeans.shopify4j.admin.rest.internal.ShopifyEnum;
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
   * https://en.wikipedia.org/wiki/ISO_8601 ，{@link org.joda.time.DateTime} 可解析
   */
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601 ，{@link org.joda.time.DateTime} 可解析
   */
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  private String description;
  @Setter(AccessLevel.NONE)
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
   * @see ValueType
   */
  @Required
  private String valueType;

  public enum ValueType implements ShopifyEnum<ValueType> {
    string,
    integer,
    json_string
  }
}
