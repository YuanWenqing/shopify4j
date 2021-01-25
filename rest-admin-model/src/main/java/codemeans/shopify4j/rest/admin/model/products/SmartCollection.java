package codemeans.shopify4j.rest.admin.model.products;

import codemeans.shopify4j.rest.admin.annotation.ReadOnly;
import codemeans.shopify4j.rest.admin.annotation.Required;
import codemeans.shopify4j.rest.admin.model.enums.PublishedScope;
import codemeans.shopify4j.rest.admin.model.enums.SortOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
@Data
@Accessors(chain = true)
@JsonRootName("smart_collection")
public class SmartCollection {

  private String bodyHtml;
  private String handle;
  private Long id;
  private CollectionImage image;
  private DateTime publishedAt;
  /**
   * @see PublishedScope
   */
  private String publishedScope;
  @Required
  private List<Rule> rules;
  private Boolean disjunctive;
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
