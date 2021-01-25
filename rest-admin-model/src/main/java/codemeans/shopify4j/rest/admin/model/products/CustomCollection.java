package codemeans.shopify4j.rest.admin.model.products;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.annotation.Required;
import codemeans.shopify4j.rest.admin.model.enums.PublishedScope;
import codemeans.shopify4j.rest.admin.model.enums.SortOrder;
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
@JsonRootName("custom_collection")
public class CustomCollection {

  private String bodyHtml;
  private String handle;
  @ReadOnly
  private Long id;
  private CollectionImage image;
  private Boolean published;
  @ReadOnly
  private DateTime publishedAt;
  /**
   * @see PublishedScope
   */
  @ReadOnly
  private String publishedScope;
  /**
   * @see SortOrder
   */
  private String sortOrder;
  private String templateSuffix;
  @Required
  private String title;
  @ReadOnly
  private DateTime updatedAt;
}
