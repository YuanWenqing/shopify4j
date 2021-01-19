package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import codemeans.shopify4j.admin.rest.annotation.Required;
import codemeans.shopify4j.admin.rest.internal.Utils;
import codemeans.shopify4j.admin.rest.model.metafield.Metafield;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product
 */
@Data
@Accessors(chain = true)
@JsonRootName("product")
public class Product {

  private String bodyHtml;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @ReadOnly
  private DateTime createdAt;
  private String handle;
  @ReadOnly
  private Long id;
  /**
   * first image, only used for get info from shopify
   */
  @Setter(AccessLevel.NONE)
  @ReadOnly
  private ProductImage image;
  private List<ProductImage> images;
  private List<Option> options;
  private String productType;
  private Boolean published;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime publishedAt;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.PublishedScope
   */
  private String publishedScope;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.ProductStatus
   */
  private String status;
  @JsonIgnore
  private List<String> tags;

  public Product addTag(String tag) {
    if (tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tag);
    return this;
  }

  @JsonIgnore
  public List<String> getTagsAsList() {
    return tags;
  }

  @JsonProperty("tags")
  public String getTagsAsText() {
    return Utils.joinTags(tags);
  }

  @JsonProperty("tags")
  public Product setTags(String tags) {
    this.tags = Utils.splitTags(tags);
    return this;
  }

  private String templateSuffix;
  @Required
  private String title;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @ReadOnly
  private DateTime updatedAt;
  private List<ProductVariant> variants;
  private String vendor;
  private List<Metafield> metafields;

}
