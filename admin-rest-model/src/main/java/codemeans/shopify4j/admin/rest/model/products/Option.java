package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("option")
public class Option {

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
  private String name;
  private long position;
  @JsonProperty("product_id")
  private long productId;
}
