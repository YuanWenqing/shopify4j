package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.core.exception.RestApiException;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.PublishedStatus;
import codemeans.shopify4j.rest.admin.model.products.SmartCollection;
import codemeans.shopify4j.rest.admin.model.products.SmartCollectionList;
import codemeans.shopify4j.rest.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface SmartCollectionApi {

  HttpResponse<SmartCollectionList> list(SmartCollectionApi.ListReq req) throws RestApiException;

  HttpResponse<Count> count(SmartCollectionApi.CountReq req) throws RestApiException;

  HttpResponse<SmartCollection> get(long id) throws RestApiException;

  HttpResponse<SmartCollection> create(SmartCollection req) throws RestApiException;

  HttpResponse<SmartCollection> update(long id, SmartCollection req) throws RestApiException;

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
