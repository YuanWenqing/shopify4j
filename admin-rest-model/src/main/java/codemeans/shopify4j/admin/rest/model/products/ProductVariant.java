package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.metafield.Metafield;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.ArrayList;
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
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private String fulfillmentService;
  private Integer grams;
  private Long id;
  private Long imageId;
  private Long inventoryItemId;
  private String inventoryManagement;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.InventoryPolicy
   */
  private String inventoryPolicy;
  @Setter(AccessLevel.NONE)
  private int inventoryQuantity;
  private String option1;
  private String option2;
  private String option3;
  @Setter(AccessLevel.NONE)
  private Integer position;
  private BigDecimal price;
  private Long productId;
  private String sku;
  private Boolean taxable;
  @Setter(AccessLevel.NONE)
  private String title;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
  private Integer weight;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.WeightUnit
   */
  private String weightUnit;

  @Setter(AccessLevel.NONE)
  private List<Metafield> metafields;

  public ProductVariant addMetafield(Metafield metafield) {
    if (metafields == null) {
      metafields = new ArrayList<>();
    }
    metafields.add(metafield);
    return this;
  }
}
