package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product-image
 */
@Data
@Accessors(chain = true)
@JsonRootName("image")
public class ProductImage {

  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime createdAt;
  private Long id;
  private Long productId;
  /**
   * 为空，则更新为第一张图，并替换主图
   */
  private int position;
  @Setter(AccessLevel.NONE)
  private List<Long> variantIds;
  private String src;
  private Integer width;
  private Integer height;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime updatedAt;

  @Setter(AccessLevel.NONE)
  private List<Metafield> metafields;

  public ProductImage addMetafield(Metafield metafield) {
    if (metafields == null) {
      metafields = Lists.newArrayList();
    }
    metafields.add(metafield);
    return this;
  }

  public ProductImage addVariantId(long variantId) {
    if (variantIds == null) {
      variantIds = Lists.newArrayList();
    }
    variantIds.add(variantId);
    return this;
  }
}
