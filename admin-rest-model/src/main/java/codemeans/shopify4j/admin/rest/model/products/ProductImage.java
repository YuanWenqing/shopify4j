package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product-image
 */
@Data
@Accessors(chain = true)
@JsonRootName("image")
public class ProductImage {

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
  /**
   * 为空，则更新为第一张图，并替换主图
   */
  private int position;
  @JsonProperty("product_id")
  private long productId;
  /**
   * src仅在创建时有用
   */
  private String src;
  @JsonProperty("variant_ids")
  private List<Long> variantIds;
}
