package codemeans.shopify4j.admin.rest.api;

import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.req.ProductCountReq;
import codemeans.shopify4j.admin.rest.req.ProductListReq;
import codemeans.shopify4j.core.exception.ShopifyServerException;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface ProductApi {

  ProductList listProducts(ProductListReq req) throws ShopifyServerException;

  Count countProducts(ProductCountReq req) throws ShopifyServerException;

  Product getProduct(long id) throws ShopifyServerException;

  Product createProduct(Product req) throws ShopifyServerException;

  Product updateProduct(Product req) throws ShopifyServerException;

  void deleteProduct(long id) throws ShopifyServerException;

  default <R> R doPipeline(ProductPipeline<R> pipeline) throws ShopifyServerException {
    return pipeline.runWith(this);
  }

  interface ProductPipeline<R> extends Pipeline<ProductApi, R> {

  }
}
