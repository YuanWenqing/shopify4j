package codemeans.shopify4j.admin.rest.model.products;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface Rule {

  String getColumn();

  String getRelation();

  String getCondition();

  @Data
  @Accessors(fluent = true)
  class TextRule implements Rule {

    private final TextColumn column;
    private final TextRelation relation;
    private final String condition;

    @Override
    public String getColumn() {
      return column.name();
    }

    @Override
    public String getRelation() {
      return relation.name();
    }

    @Override
    public String getCondition() {
      return condition;
    }
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

  @Data
  @Accessors(fluent = true)
  class NumberRule implements Rule {

    private final NumberColumn column;
    private final NumberRelation relation;
    private final String condition;

    @Override
    public String getColumn() {
      return column.name();
    }

    @Override
    public String getRelation() {
      return relation.name();
    }

    @Override
    public String getCondition() {
      return condition;
    }
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

  @Data
  class TagRule implements Rule {

    private final String condition;

    @Override

    public String getColumn() {
      return "tag";
    }

    @Override
    public String getRelation() {
      return "equals";
    }

  }
}
