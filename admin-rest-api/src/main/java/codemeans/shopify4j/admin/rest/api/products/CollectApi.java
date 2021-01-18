package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.Collect;
import codemeans.shopify4j.admin.rest.model.products.CollectList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectApi {

  Collect create(Collect collect) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  Collect get(long id) throws ShopifyServerException;

  Count count(CountReq req) throws ShopifyServerException;

  CollectList list(ListReq req) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class CountReq {

    private Long productId;
    private Long collectionId;
  }

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private Long sinceId;
    private final List<String> fields = Lists.newArrayList();

    public ListReq addField(String field) {
      this.fields.add(field);
      return this;
    }

  }
}
