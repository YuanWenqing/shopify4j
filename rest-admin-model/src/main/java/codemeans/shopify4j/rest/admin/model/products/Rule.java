package codemeans.shopify4j.rest.admin.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

  private String column;
  private String relation;
  private String condition;

  public static Rule text(TextColumn column, TextRelation relation, String condition) {
    return new Rule(column.name(), relation.name(), condition);
  }

  public static Rule number(NumberRelation column, NumberRelation relation, Number number) {
    return new Rule(column.name(), relation.name(), number.toString());
  }

  public static Rule tag(String tag) {
    return new Rule("tag", "equals", tag);
  }

  enum TextColumn {
    title,
    type,
    vendor,
    variant_title
  }

  enum TextRelation {
    equals,
    not_equals,
    starts_with,
    ends_with,
    contains,
    not_contains
  }

  enum NumberColumn {
    variant_compare_at_price,
    variant_weight,
    variant_inventory,
    variant_price
  }

  enum NumberRelation {
    greater_than,
    less_than,
    equals,
    not_equals
  }

}
