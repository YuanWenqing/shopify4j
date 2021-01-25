package codemeans.shopify4j.rest.admin.model.products;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.model.enums.InventoryPolicy;
import codemeans.shopify4j.rest.admin.model.enums.WeightUnit;
import codemeans.shopify4j.rest.admin.model.metafield.Metafield;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
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
  private DateTime createdAt;
  private String fulfillmentService;
  private Integer grams;
  private Long id;
  private Long imageId;
  private Long inventoryItemId;
  private String inventoryManagement;
  /**
   * @see InventoryPolicy
   */
  private String inventoryPolicy;
  @ReadOnly
  private int inventoryQuantity;
  private String option1;
  private String option2;
  private String option3;
  @ReadOnly
  private Integer position;
  private BigDecimal price;
  private Long productId;
  private String sku;
  private Boolean taxable;
  @ReadOnly
  private String title;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime updatedAt;
  private Integer weight;
  /**
   * @see WeightUnit
   */
  private String weightUnit;
  private List<Metafield> metafields;
}
