package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product
 */
@Data
@Accessors(chain = true)
@JsonRootName("product")
public class Product {

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
  @JsonProperty("body_html")
  private String bodyHtml;
  private String handle;
  @JsonProperty("image")
  private ProductImage image;
  @JsonProperty("images")
  private List<ProductImage> images;
  private List<Option> options;
  @JsonProperty("product_type")
  private String productType;
  private Boolean published;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601 ，{@link org.joda.time.DateTime} 可解析
   */
  @JsonProperty("published_at")
  private String publishedAt;
  private String tags;
  @JsonProperty("template_suffix")
  private String templateSuffix;
  private String title;
  private List<ProductVariant> variants;
  private String vendor;
  @JsonProperty("published_scope")
  private String publishedScope;

}
