package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * https://shopify.dev/docs/admin-api/rest/reference/products/product-variant
 */
@Data
@Accessors(chain = true)
@JsonRootName("variant")
public class ProductVariant {

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
  @JsonProperty("product_id")
  private long productId;
  @JsonProperty("compare_at_price")
  private BigDecimal compareAtPrice;
  @JsonProperty("fulfillment_service")
  private String fulfillmentService;
  private int grams;
  @JsonProperty("inventory_management")
  private String inventoryManagement;
  @JsonProperty("inventory_policy")
  private String inventoryPolicy;
  @JsonProperty("inventory_quantity")
  private int inventoryQuantity;
  private String option1;
  private String option2;
  private String option3;
  private long position;
  private BigDecimal price;
  @JsonProperty("requires_shipping")
  private boolean requiresShipping;
  /**
   * 我们的skuId
   */
  private String sku;
  private boolean taxable;
  private String title;
  private String barcode;
}
