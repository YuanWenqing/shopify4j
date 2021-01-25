package codemeans.shopify4j.rest.admin.model.products;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
@Data
@Accessors(chain = true)
public class CollectionImage {

  /**
   * Base64-encoded binary data of image, used for uploading
   */
  private String attachment;
  private String src;
  private String alt;
  @ReadOnly
  private int width;
  @ReadOnly
  private int height;
  @ReadOnly
  private DateTime createdAt;
}
