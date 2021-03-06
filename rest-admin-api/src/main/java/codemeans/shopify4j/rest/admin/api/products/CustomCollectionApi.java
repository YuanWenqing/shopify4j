package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.PublishedStatus;
import codemeans.shopify4j.rest.admin.model.products.CustomCollection;
import codemeans.shopify4j.rest.admin.model.products.CustomCollectionList;
import codemeans.shopify4j.rest.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CustomCollectionApi {

  HttpResponse<CustomCollectionList> list(CustomCollectionApi.ListReq req) throws RestApiException;

  HttpResponse<Count> count(CustomCollectionApi.CountReq req) throws RestApiException;

  HttpResponse<CustomCollection> get(long id) throws RestApiException;

  HttpResponse<CustomCollection> create(CustomCollection req) throws RestApiException;

  HttpResponse<CustomCollection> update(long id, CustomCollection req) throws RestApiException;

  HttpResponse<String> delete(long id) throws RestApiException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private List<Long> ids;
    private Integer limit;
    private Long sinceId;
    private String title;
    private Long productId;
    private String handle;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime publishedAtMin;
    private DateTime publishedAtMax;
    /**
     * @see PublishedStatus
     */
    private String publishedStatus;
    private List<String> fields;
  }

  @Data
  @Accessors(chain = true)
  class CountReq {

    private String title;
    private Long productId;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime publishedAtMin;
    private DateTime publishedAtMax;
    /**
     * @see PublishedStatus
     */
    private String publishedStatus;

  }
}
