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
  private List<ProductImage> images;

  public ProductImageList addProductImage(ProductImage image) {
    if (images == null) {
      images = Lists.newArrayList();
    }
    this.images.add(image);
    return this;
  }
}
