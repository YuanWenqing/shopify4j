package codemeans.shopify4j.admin.rest.model.products;

import codemeans.shopify4j.admin.rest.model.Metafield;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

@Data
@Accessors(chain = true)
@JsonRootName("option")
public class Option {

  /**
   * https://en.wikipedia.org/wiki/ISO_8601
   */
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private Long id;
  private String name;
  private Integer position;
  private Long productId;
  @Setter(AccessLevel.NONE)
  private List<String> values;

  public Option addValue(String value) {
    if (values == null) {
      values = Lists.newArrayList();
    }
    values.add(value);
    return this;
  }

  @Setter(AccessLevel.NONE)
  private List<Metafield> metafields;

  public Option addMetafield(Metafield metafield) {
    if (metafields == null) {
      metafields = Lists.newArrayList();
    }
    metafields.add(metafield);
    return this;
  }
}
