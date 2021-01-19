package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.CustomCollection;
import codemeans.shopify4j.admin.rest.model.products.CustomCollectionList;
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
public interface CustomCollectionApi {

  HttpResponse<CustomCollectionList> list(CustomCollectionApi.ListReq req) throws ShopifyServerException;

  HttpResponse<Count> count(CustomCollectionApi.CountReq req) throws ShopifyServerException;

  HttpResponse<CustomCollection> get(long id) throws ShopifyServerException;

  HttpResponse<CustomCollection> create(CustomCollection req) throws ShopifyServerException;

  HttpResponse<CustomCollection> update(long id, CustomCollection req) throws ShopifyServerException;

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
