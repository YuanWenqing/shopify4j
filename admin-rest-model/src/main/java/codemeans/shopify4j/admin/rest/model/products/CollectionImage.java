package codemeans.shopify4j.admin.rest.model.products;

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
@Accessors(chain = true)
public class CollectionImage {

  /**
   * Base64-encoded binary data of image, used for uploading
   */
  private String attachment;
  private String src;
  private String alt;
  private int width;
  private int height;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
}
