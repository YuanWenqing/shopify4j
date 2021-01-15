package codemeans.shopify4j.admin.rest.model.products;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
public class CustomCollectionList {

  @Setter(AccessLevel.NONE)
  private List<CustomCollection> customCollections;

  public CustomCollectionList addCustomCollection(CustomCollection customCollection) {
    if (customCollections == null) {
      customCollections = Lists.newArrayList();
    }
    this.customCollections.add(customCollection);
    return this;
  }
}
