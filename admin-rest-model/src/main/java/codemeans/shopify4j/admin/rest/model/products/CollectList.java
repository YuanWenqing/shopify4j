package codemeans.shopify4j.admin.rest.model.products;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
public class CollectList {

  @Setter(AccessLevel.NONE)
  private List<Collect> collects;

  public CollectList addCollect(Collect collect) {
    if (collects == null) {
      collects = new ArrayList<>();
    }
    this.collects.add(collect);
    return this;
  }
}
