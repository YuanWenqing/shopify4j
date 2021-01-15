package codemeans.shopify4j.admin.rest.model.products;

import com.google.common.collect.Lists;
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
  private List<ProductImage> productImages;

  public ProductImageList addProductImage(ProductImage productImage) {
    if (productImages == null) {
      productImages = Lists.newArrayList();
    }
    this.productImages.add(productImage);
    return this;
  }
}
