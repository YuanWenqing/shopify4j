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
  @Setter(AccessLevel.NONE)
  private List<ProductImage> images;

  public Product addImage(ProductImage image) {
    if (images == null) {
      images = new ArrayList<>();
    }
    images.add(image);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Option> options;

  public Product addOption(Option option) {
    if (options == null) {
      options = new ArrayList<>();
    }
    option.setPosition(options.size() + 1);
    options.add(option);
    return this;
  }

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
  @Setter(AccessLevel.NONE)
  private List<ProductVariant> variants;

  public Product addVariant(ProductVariant variant) {
    if (variants == null) {
      variants = new ArrayList<>();
    }
    variants.add(variant);
    return this;
  }

  private String vendor;

  @Setter(AccessLevel.NONE)
  private List<Metafield> metafields;

  public Product addMetafield(Metafield metafield) {
    if (metafields == null) {
      metafields = new ArrayList<>();
    }
    metafields.add(metafield);
    return this;
  }


}
