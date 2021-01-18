package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.SmartCollection;
import codemeans.shopify4j.admin.rest.model.products.SmartCollectionList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
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

  SmartCollectionList list(SmartCollectionApi.ListReq req) throws ShopifyServerException;

  Count count(SmartCollectionApi.CountReq req) throws ShopifyServerException;

  SmartCollection get(long id) throws ShopifyServerException;

  SmartCollection create(SmartCollection req) throws ShopifyServerException;

  SmartCollection update(long id, SmartCollection req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private final List<Long> ids = new ArrayList<>();
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
    private final List<String> fields = new ArrayList<>();

    public SmartCollectionApi.ListReq addId(long id) {
      this.ids.add(id);
      return this;
    }

    public SmartCollectionApi.ListReq addField(String field) {
      this.fields.add(field);
      return this;
    }

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
