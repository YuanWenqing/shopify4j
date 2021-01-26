package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.api.Pipeline;
import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.enums.ProductStatus;
import codemeans.shopify4j.rest.admin.model.enums.PublishedStatus;
import codemeans.shopify4j.rest.admin.model.products.Product;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface ProductApi {

  HttpResponse<ProductList> list(ListReq req) throws RestApiException;

  HttpResponse<Count> count(CountReq req) throws RestApiException;

  HttpResponse<Product> get(long id) throws RestApiException;

  HttpResponse<Product> create(Product req) throws RestApiException;

  HttpResponse<Product> update(long id, Product req) throws RestApiException;

  HttpResponse<String> delete(long id) throws RestApiException;

  default <R> R pipeline(ProductPipeline<R> pipeline) throws RestApiException {
    return pipeline.runWith(this);
  }

  interface ProductPipeline<R> extends Pipeline<ProductApi, R> {

  }

  @Data
  @Accessors(chain = true)
  class ListReq {

    private List<Long> ids;
    private Integer limit;
    private Long sinceId;
    private String title;
    private String vendor;
    private String handle;
    private String productType;
    /**
     * @see ProductStatus
     */
    private String status;
    private Long collectionId;
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime publishedAtMin;
    private DateTime publishedAtMax;
    /**
     * @see PublishedStatus
     */
    private String publishedStatus;
    private List<String> fields;
    private List<String> presentmentCurrencies;
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
    /**
     * @see PublishedStatus
     */
    private String publishedStatus;

  }
}
