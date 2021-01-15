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
public class SmartCollectionList {

  @Setter(AccessLevel.NONE)
  private List<SmartCollection> smartCollections;

  public SmartCollectionList addSmartCollection(SmartCollection smartCollection) {
    if (smartCollections == null) {
      smartCollections = Lists.newArrayList();
    }
    this.smartCollections.add(smartCollection);
    return this;
  }
}
