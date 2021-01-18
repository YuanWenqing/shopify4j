package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.api.Pipeline;
import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.model.products.ProductStatus;
import codemeans.shopify4j.admin.rest.model.products.PublishedStatus;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface ProductApi {

  ProductList list(ListReq req) throws ShopifyServerException;

  Count count(CountReq req) throws ShopifyServerException;

  Product get(long id) throws ShopifyServerException;

  Product create(Product req) throws ShopifyServerException;

  Product update(Product req) throws ShopifyServerException;

  void delete(long id) throws ShopifyServerException;

  default <R> R pipeline(ProductPipeline<R> pipeline) throws ShopifyServerException {
    return pipeline.runWith(this);
  }

  interface ProductPipeline<R> extends Pipeline<ProductApi, R> {

  }

  @Data
  @Accessors(chain = true)
  class ListReq {

    private final List<Long> ids = Lists.newArrayList();
    private Integer limit;
    private Long sinceId;
    private String title;
    private String vendor;
    private String handle;
    private String productType;
    private ProductStatus status;
    private Long collectionId;
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime publishedAtMin;
    private DateTime publishedAtMax;
    private PublishedStatus publishedStatus;
    private final List<String> fields = Lists.newArrayList();
    private final List<String> presentmentCurrencies = Lists.newArrayList();

    public ListReq addId(long id) {
      this.ids.add(id);
      return this;
    }

    public ListReq addField(String field) {
      this.fields.add(field);
      return this;
    }

    public ListReq addPresentmentCurrency(String presentmentCurrency) {
      this.presentmentCurrencies.add(presentmentCurrency);
      return this;
    }
  }

  @Data
  @Accessors(chain = true)
  class CountReq {

    private String vendor;
    private String productType;
    private Long collectionId;
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime publishedAtMin;
    private DateTime publishedAtMax;
    private PublishedStatus publishedStatus;

  }
}
