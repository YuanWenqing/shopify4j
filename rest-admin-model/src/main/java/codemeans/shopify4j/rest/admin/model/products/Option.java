package codemeans.shopify4j.rest.admin.model.products;

import codemeans.shopify4j.rest.admin.model.metafield.Metafield;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

@Data
@Accessors(chain = true)
public class Option {

  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  private DateTime createdAt;
  private Long id;
  private String name;
  private Integer position;
  private Long productId;
  private List<String> values;
  private List<Metafield> metafields;
}
