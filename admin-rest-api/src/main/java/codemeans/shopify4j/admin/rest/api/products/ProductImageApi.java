package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.ProductImage;
import codemeans.shopify4j.admin.rest.model.products.ProductImageList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface ProductImageApi {

  ProductImageList list(long productId, ProductImageApi.ListReq req) throws ShopifyServerException;

  Count count(long productId, Long imageSinceId) throws ShopifyServerException;

  ProductImage get(long productId, long imageId) throws ShopifyServerException;

  ProductImage create(long productId, ProductImage req) throws ShopifyServerException;

  ProductImage update(long productId, long imageId, ProductImage req) throws ShopifyServerException;

  void delete(long productId, long imageId) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Long sinceId;
    private List<String> fields;
  }

}
