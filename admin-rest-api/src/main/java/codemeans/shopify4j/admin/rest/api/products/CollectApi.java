package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.common.Empty;
import codemeans.shopify4j.admin.rest.model.products.Collect;
import codemeans.shopify4j.admin.rest.model.products.CollectList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectApi {

  HttpResponse<Collect> create(Collect collect) throws ShopifyServerException;

  HttpResponse<String> delete(long id) throws ShopifyServerException;

  HttpResponse<Collect> get(long id) throws ShopifyServerException;

  HttpResponse<Count> count(CountReq req) throws ShopifyServerException;

  HttpResponse<CollectList> list(ListReq req) throws ShopifyServerException;

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
    private List<String> fields;

  }
}
