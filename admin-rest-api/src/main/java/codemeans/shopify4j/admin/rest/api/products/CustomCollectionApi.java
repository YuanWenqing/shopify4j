package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.CustomCollection;
import codemeans.shopify4j.admin.rest.model.products.CustomCollectionList;
import codemeans.shopify4j.admin.rest.model.products.PublishedStatus;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CustomCollectionApi {

  CustomCollectionList list(CustomCollectionApi.ListReq req) throws ShopifyServerException;

  Count count(CustomCollectionApi.CountReq req) throws ShopifyServerException;

  CustomCollection get(long id) throws ShopifyServerException;

  CustomCollection create(CustomCollection req) throws ShopifyServerException;

  CustomCollection update(CustomCollection req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private final List<Long> ids = Lists.newArrayList();
    private Integer limit;
    private Long sinceId;
    private String title;
    private Long productId;
    private String handle;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime publishedAtMin;
    private DateTime publishedAtMax;
    private PublishedStatus publishedStatus;
    private final List<String> fields = Lists.newArrayList();

    public CustomCollectionApi.ListReq addId(long id) {
      this.ids.add(id);
      return this;
    }

    public CustomCollectionApi.ListReq addField(String field) {
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
    private PublishedStatus publishedStatus;

  }
}
