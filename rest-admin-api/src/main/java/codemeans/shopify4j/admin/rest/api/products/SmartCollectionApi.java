package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.SmartCollection;
import codemeans.shopify4j.admin.rest.model.products.SmartCollectionList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface SmartCollectionApi {

  HttpResponse<SmartCollectionList> list(SmartCollectionApi.ListReq req) throws ShopifyServerException;

  HttpResponse<Count> count(SmartCollectionApi.CountReq req) throws ShopifyServerException;

  HttpResponse<SmartCollection> get(long id) throws ShopifyServerException;

  HttpResponse<SmartCollection> create(SmartCollection req) throws ShopifyServerException;

  HttpResponse<SmartCollection> update(long id, SmartCollection req) throws ShopifyServerException;

  HttpResponse<String> delete(long id) throws ShopifyServerException;

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
     * @see codemeans.shopify4j.admin.rest.model.enums.PublishedStatus
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
     * @see codemeans.shopify4j.admin.rest.model.enums.PublishedStatus
     */
    private String publishedStatus;

  }
}
