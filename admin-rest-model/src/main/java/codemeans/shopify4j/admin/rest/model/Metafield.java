package codemeans.shopify4j.admin.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/metafield
 */
@Data
@Accessors(chain = true)
@JsonRootName("metafield")
public class Metafield {

  private Long id;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601 ，{@link org.joda.time.DateTime} 可解析
   */
  @JsonProperty("created_at")
  private String createdAt;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601 ，{@link org.joda.time.DateTime} 可解析
   */
  @JsonProperty("updated_at")
  private String updatedAt;
  private List<Metafield> metafields = new ArrayList<Metafield>();
  private String description;
  private String key;
  private String namespace;
  private String value;
  @JsonProperty("value_type")
  private String valueType;
}
