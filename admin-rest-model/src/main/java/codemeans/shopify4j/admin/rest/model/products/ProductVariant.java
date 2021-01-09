package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product-variant
 */
@Data
@Accessors(chain = true)
@JsonRootName("variant")
public class ProductVariant {

  private String barcode;
  private BigDecimal compareAtPrice;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @JsonProperty("created_at")
  private DateTime createdAt;
  private String fulfillmentService;
  private Integer grams;
  private Long id;
  private Long imageId;
  private Long inventoryItemId;
  private String inventoryManagement;
  private InventoryPolicy inventoryPolicy = InventoryPolicy.DENY;
  @Setter(AccessLevel.NONE)
  private int inventoryQuantity;
  private String option1;
  private String option2;
  private String option3;
  @Setter(AccessLevel.NONE)
  private long position;
  private BigDecimal price;
  private Long productId;
  private String sku;
  private Boolean taxable;
  @Setter(AccessLevel.NONE)
  private String title;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime updatedAt;
  private Integer weight;
  private WeightUnit weightUnit;

  @Setter(AccessLevel.NONE)
  private List<Metafield> metafields;

  public ProductVariant addMetafield(Metafield metafield) {
    if (metafields == null) {
      metafields = Lists.newArrayList();
    }
    metafields.add(metafield);
    return this;
  }
}
