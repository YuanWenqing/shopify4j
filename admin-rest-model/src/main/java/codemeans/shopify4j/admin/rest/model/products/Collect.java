package codemeans.shopify4j.admin.rest.model.products;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
@Data
@JsonRootName("collect")
@Accessors(chain = true)
public class Collect {

  private Long collectionId;
  private DateTime createdAt;
  private Long id;
  private Integer position;
  private Long productId;
  private String sortValue;
  private DateTime updatedAt;
}
