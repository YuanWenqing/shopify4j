package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.PublishedStatus;
import codemeans.shopify4j.rest.admin.model.products.SmartCollection;
import codemeans.shopify4j.rest.admin.model.products.SmartCollectionList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface SmartCollectionApi {

  HttpResponse<SmartCollectionList> list(SmartCollectionApi.ListReq req) throws HttpResponseException;

  HttpResponse<Count> count(SmartCollectionApi.CountReq req) throws HttpResponseException;

  HttpResponse<SmartCollection> get(long id) throws HttpResponseException;

  HttpResponse<SmartCollection> create(SmartCollection req) throws HttpResponseException;

  HttpResponse<SmartCollection> update(long id, SmartCollection req) throws HttpResponseException;

  HttpResponse<String> delete(long id) throws HttpResponseException;

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
