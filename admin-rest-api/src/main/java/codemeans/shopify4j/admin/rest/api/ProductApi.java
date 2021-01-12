package codemeans.shopify4j.admin.rest.api;

import codemeans.shopify4j.admin.rest.exception.ShopifyErrorException;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.req.ProductCountReq;
import codemeans.shopify4j.admin.rest.req.ProductListReq;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
public interface ProductApi {

  ProductList listProducts(ProductListReq req) throws ShopifyErrorException;

  Count countProducts(ProductCountReq req) throws ShopifyErrorException;

  Product getProduct(long id) throws ShopifyErrorException;

  Product createProduct(Product req) throws ShopifyErrorException;

  Product updateProduct(Product req) throws ShopifyErrorException;

  void deleteProduct(long id) throws ShopifyErrorException;
}
