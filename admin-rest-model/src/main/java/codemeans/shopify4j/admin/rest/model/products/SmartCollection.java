package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import codemeans.shopify4j.admin.rest.annotation.Required;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
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
   * @see codemeans.shopify4j.admin.rest.model.enums.PublishedScope
   */
  private String publishedScope;
  @Required
  private final List<Rule> rules = new ArrayList<>();

  @Required
  public SmartCollection addRule(Rule rule) {
    this.rules.add(rule);
    return this;
  }

  private Boolean disjunctive;
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
