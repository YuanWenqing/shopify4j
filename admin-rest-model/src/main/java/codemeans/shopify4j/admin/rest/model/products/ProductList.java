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
public class ProductList {

  @Setter(AccessLevel.NONE)
  private List<Product> products;

  public ProductList addProduct(Product product) {
    if (products == null) {
      products = new ArrayList<>();
    }
    this.products.add(product);
    return this;
  }
}
