package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductVariant;
import codemeans.shopify4j.rest.admin.model.products.ProductVariantList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface ProductVariantApi {

  HttpResponse<ProductVariantList> list(long productId, ProductVariantApi.ListReq req)
      throws HttpResponseException;

  HttpResponse<Count> count(long productId) throws HttpResponseException;

  HttpResponse<ProductVariant> get(long variantId) throws HttpResponseException;

  HttpResponse<ProductVariant> create(long productId, ProductVariant req) throws HttpResponseException;

  HttpResponse<ProductVariant> update(long id, ProductVariant req) throws HttpResponseException;

  HttpResponse<String> delete(long productId, long variantId) throws HttpResponseException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private  List<String> presentmentCurrencies;
    private Long sinceId;
    private List<String> fields;
  }

}
