package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Collect;
import codemeans.shopify4j.rest.admin.model.products.CollectList;
import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectApi {

  HttpResponse<Collect> create(Collect collect) throws RestApiException;

  HttpResponse<String> delete(long id) throws RestApiException;

  HttpResponse<Collect> get(long id) throws RestApiException;

  HttpResponse<Count> count(CountReq req) throws RestApiException;

  HttpResponse<CollectList> list(ListReq req) throws RestApiException;

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
