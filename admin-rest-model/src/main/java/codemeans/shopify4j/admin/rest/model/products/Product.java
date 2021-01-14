package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product
 */
@Data
@Accessors(chain = true)
@JsonRootName("product")
public class Product {

  private static final String COMMA = ",";

  private String bodyHtml;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private String handle;
  private Long id;
  /**
   * first image, only used for get info from shopify
   */
  @Setter(AccessLevel.NONE)
  private ProductImage image;
  @Setter(AccessLevel.NONE)
  private List<ProductImage> images;

  public Product addImage(ProductImage image) {
    if (images == null) {
      images = Lists.newArrayList();
    }
    images.add(image);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Option> options;

  public Product addOption(Option option) {
    if (options == null) {
      options = Lists.newArrayList();
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
  private PublishedScope publishedScope;
  private ProductStatus status;
  @JsonIgnore
  private List<String> tags;

  public Product addTag(String tag) {
    if (tags == null) {
      this.tags = Lists.newArrayList();
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
    if (tags == null) {
      return null;
    }
    return StringUtils.join(tags, COMMA);
  }

  @JsonProperty("tags")
  public Product setTags(String tags) {
    if (StringUtils.isNotBlank(tags)) {
      this.tags = Lists.newArrayList(Splitter.on(COMMA).trimResults().splitToList(tags));
    }
    return this;
  }

  private String templateSuffix;
  private String title;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  @Setter(AccessLevel.NONE)
  private List<ProductVariant> variants;

  public Product addVariant(ProductVariant variant) {
    if (variants == null) {
      variants = Lists.newArrayList();
    }
    variants.add(variant);
    return this;
  }

  private String vendor;

  @Setter(AccessLevel.NONE)
  private List<Metafield> metafields;

  public Product addMetafield(Metafield metafield) {
    if (metafields == null) {
      metafields = Lists.newArrayList();
    }
    metafields.add(metafield);
    return this;
  }


}
