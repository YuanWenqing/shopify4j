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
public class SmartCollectionList {

  @Setter(AccessLevel.NONE)
  private List<SmartCollection> smartCollections;

  public SmartCollectionList addSmartCollection(SmartCollection smartCollection) {
    if (smartCollections == null) {
      smartCollections = new ArrayList<>();
    }
    this.smartCollections.add(smartCollection);
    return this;
  }
}
