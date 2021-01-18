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
public class ProductVariantList {

  @Setter(AccessLevel.NONE)
  private List<ProductVariant> variants;

  public ProductVariantList addProductVariant(ProductVariant variant) {
    if (variants == null) {
      variants = new ArrayList<>();
    }
    this.variants.add(variant);
    return this;
  }
}
