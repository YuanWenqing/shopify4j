package codemeans.shopify4j.admin.rest.model.products;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.collect.Lists;
import java.util.List;
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
@JsonRootName("smart_collection")
public class SmartCollection {

  private String bodyHtml;
  private String handle;
  private Long id;
  private CollectionImage image;
  @Setter(AccessLevel.NONE)
  private DateTime publishedAt;
  private PublishedScope publishedScope;
  private final List<Rule> rules = Lists.newArrayList();

  public SmartCollection addRule(Rule rule) {
    this.rules.add(rule);
    return this;
  }

  private Boolean disjunctive;
  private SortOrder sortOrder;
  private String templateSuffix;
  private String title;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;

}
