package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import codemeans.shopify4j.admin.rest.model.enums.ProductStatus;
import codemeans.shopify4j.admin.rest.model.enums.PublishedScope;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.collect.Lists;
import java.util.Collection;
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
  /**
   * joined by comma
   */
  @Setter(AccessLevel.NONE)
  private String tags;

  public Product addTag(String tag) {
    if (StringUtils.isNotBlank(tags)) {
      this.tags = StringUtils.joinWith(COMMA, tags, tag);
    } else {
      this.tags = tag;
    }
    return this;
  }

  public Product addTags(Collection<String> tags) {
    if (StringUtils.isBlank(this.tags)) {
      this.tags = StringUtils.join(tags, COMMA);
    } else {
      this.tags = this.tags + COMMA + StringUtils.join(tags, COMMA);
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
