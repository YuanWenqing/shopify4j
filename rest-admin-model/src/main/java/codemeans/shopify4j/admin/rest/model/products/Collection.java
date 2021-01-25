package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import codemeans.shopify4j.admin.rest.annotation.Required;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
@Data
@Accessors(chain = true)
@JsonRootName("collection")
public class Collection {

  private String bodyHtml;
  private String handle;
  private CollectionImage image;
  @ReadOnly
  private Long id;
  @ReadOnly
  private DateTime publishedAt;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.PublishedScope
   */
  @ReadOnly
  private String publishedScope;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.SortOrder
   */
  private String sortOrder;
  private String templateSuffix;
  @Required
  private String title;
  @ReadOnly
  private DateTime updatedAt;
}
