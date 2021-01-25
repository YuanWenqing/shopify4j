package codemeans.shopify4j.rest.admin.model.events;

import codemeans.shopify4j.rest.admin.model.enums.ArticleVerb;
import codemeans.shopify4j.rest.admin.model.enums.BlogVerb;
import codemeans.shopify4j.rest.admin.model.enums.CollectionVerb;
import codemeans.shopify4j.rest.admin.model.enums.CommentVerb;
import codemeans.shopify4j.rest.admin.model.enums.OrderVerb;
import codemeans.shopify4j.rest.admin.model.enums.PageVerb;
import codemeans.shopify4j.rest.admin.model.enums.PriceVerb;
import codemeans.shopify4j.rest.admin.model.enums.ProductVerb;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
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

  private List<String> arguments;
  private String body;
  private DateTime createdAt;
  private Long id;
  @Deprecated
  private String description;
  private String path;
  private String message;
  private Long subjectId;
  private String subjectType;
  /**
   * @see ArticleVerb
   * @see BlogVerb
   * @see CollectionVerb
   * @see CommentVerb
   * @see OrderVerb
   * @see PageVerb
   * @see PriceVerb
   * @see ProductVerb
   */
  private String verb;

}
