package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.Collect;
import codemeans.shopify4j.rest.admin.model.products.CollectList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectApi {

  HttpResponse<Collect> create(Collect collect) throws HttpResponseException;

  HttpResponse<String> delete(long id) throws HttpResponseException;

  HttpResponse<Collect> get(long id) throws HttpResponseException;

  HttpResponse<Count> count(CountReq req) throws HttpResponseException;

  HttpResponse<CollectList> list(ListReq req) throws HttpResponseException;

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
