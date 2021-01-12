package codemeans.shopify4j.admin.rest.req;

import codemeans.shopify4j.admin.rest.model.products.PublishedStatus;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
@Accessors(chain = true)
public class ProductCountReq {

  private String vendor;
  private String productType;
  private Long collectionId;
  private DateTime createdAtMin;
  private DateTime createdAtMax;
  private DateTime updatedAtMin;
  private DateTime updatedAtMax;
  private DateTime publishedAtMin;
  private DateTime publishedAtMax;
  private PublishedStatus publishedStatus;

}
