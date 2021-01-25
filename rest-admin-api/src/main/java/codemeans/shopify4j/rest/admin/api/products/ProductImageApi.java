package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.products.ProductImage;
import codemeans.shopify4j.rest.admin.model.products.ProductImageList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface ProductImageApi {

  HttpResponse<ProductImageList> list(long productId, ProductImageApi.ListReq req) throws ShopifyServerException;

  HttpResponse<Count> count(long productId, Long imageSinceId) throws ShopifyServerException;

  HttpResponse<ProductImage> get(long productId, long imageId) throws ShopifyServerException;

  HttpResponse<ProductImage> create(long productId, ProductImage req) throws ShopifyServerException;

  HttpResponse<ProductImage> update(long productId, long imageId, ProductImage req) throws ShopifyServerException;

  HttpResponse<String> delete(long productId, long imageId) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Long sinceId;
    private List<String> fields;
  }

}
