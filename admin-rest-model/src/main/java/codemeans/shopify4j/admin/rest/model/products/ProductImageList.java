package codemeans.shopify4j.admin.rest.model.products;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
public class ProductImageList {

  @Setter(AccessLevel.NONE)
  private List<ProductImage> images;

  public ProductImageList addProductImage(ProductImage image) {
    if (images == null) {
      images = new ArrayList<>();
    }
    this.images.add(image);
    return this;
  }
}
