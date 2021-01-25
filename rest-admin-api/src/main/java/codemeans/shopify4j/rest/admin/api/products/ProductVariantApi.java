package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductVariant;
import codemeans.shopify4j.rest.admin.model.products.ProductVariantList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface ProductVariantApi {

  HttpResponse<ProductVariantList> list(long productId, ProductVariantApi.ListReq req)
      throws ShopifyServerException;

  HttpResponse<Count> count(long productId) throws ShopifyServerException;

  HttpResponse<ProductVariant> get(long variantId) throws ShopifyServerException;

  HttpResponse<ProductVariant> create(long productId, ProductVariant req) throws ShopifyServerException;

  HttpResponse<ProductVariant> update(long id, ProductVariant req) throws ShopifyServerException;

  HttpResponse<String> delete(long productId, long variantId) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private  List<String> presentmentCurrencies;
    private Long sinceId;
    private List<String> fields;
  }

}
