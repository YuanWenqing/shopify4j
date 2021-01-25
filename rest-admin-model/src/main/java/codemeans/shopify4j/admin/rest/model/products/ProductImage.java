package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.metafield.Metafield;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
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
   * Base64-encoded binary data of image, used for uploading
   */
  private String attachment;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime createdAt;
  private Long id;
  /**
   * if unset, position of image will be updated with the index of image array(starting from 1)
   */
  private Integer position;
  private Long productId;
  private List<Long> variantIds;
  private String src;
  private Integer width;
  private Integer height;
  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime updatedAt;
  private List<Metafield> metafields;
}
