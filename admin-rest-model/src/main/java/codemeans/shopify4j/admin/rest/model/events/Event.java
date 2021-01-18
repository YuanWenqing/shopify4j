package codemeans.shopify4j.admin.rest.model.events;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
@Accessors(chain = true)
@JsonRootName("event")
public class Event {

  @Setter(AccessLevel.NONE)
  private List<String> arguments;
  private String body;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private Long id;
  private String path;
  private String message;
  private Long subjectId;
  private String subjectType;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.ArticleVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.BlogVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.CollectionVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.CommentVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.OrderVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.PageVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.PriceVerb
   * @see codemeans.shopify4j.admin.rest.model.enums.ProductVerb
   */
  private String verb;

}
