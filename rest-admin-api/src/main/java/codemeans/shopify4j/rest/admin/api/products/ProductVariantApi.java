package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductVariant;
import codemeans.shopify4j.rest.admin.model.products.ProductVariantList;
import codemeans.shopify4j.rest.exception.RestApiException;
import codemeans.shopify4j.rest.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface ProductVariantApi {

  HttpResponse<ProductVariantList> list(long productId, ProductVariantApi.ListReq req)
      throws RestApiException;

  HttpResponse<Count> count(long productId) throws RestApiException;

  HttpResponse<ProductVariant> get(long variantId) throws RestApiException;

  HttpResponse<ProductVariant> create(long productId, ProductVariant req) throws RestApiException;

  HttpResponse<ProductVariant> update(long id, ProductVariant req) throws RestApiException;

  HttpResponse<String> delete(long productId, long variantId) throws RestApiException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private  List<String> presentmentCurrencies;
    private Long sinceId;
    private List<String> fields;
  }

}
