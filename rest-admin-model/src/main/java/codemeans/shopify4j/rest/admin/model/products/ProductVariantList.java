package codemeans.shopify4j.rest.admin.model.products;

import java.util.List;
import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
public class ProductVariantList {

  private List<ProductVariant> variants;
}
