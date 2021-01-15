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
@Accessors(chain = true)
@JsonRootName("collection")
public class Collection {

  private String bodyHtml;
  private String handle;
  private CollectionImage image;
  @Setter(AccessLevel.NONE)
  private Long id;
  @Setter(AccessLevel.NONE)
  private DateTime publishedAt;
  @Setter(AccessLevel.NONE)
  private PublishedScope publishedScope;
  private SortOrder sortOrder;
  private String templateSuffix;
  private String title;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;
}
