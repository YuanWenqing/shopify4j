package codemeans.shopify4j.admin.rest.api.impl;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.core.Invoker;
import codemeans.shopify4j.admin.rest.exception.ShopifyErrorException;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.req.ProductCountReq;
import codemeans.shopify4j.admin.rest.req.ProductListReq;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductApiImpl implements ProductApi {

  private final Invoker invoker;

  public ProductApiImpl(Invoker invoker) {
    this.invoker = invoker;
  }

  @Override
  public ProductList listProducts(ProductListReq req) throws ShopifyErrorException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Count countProducts(ProductCountReq req) throws ShopifyErrorException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Product getProduct(long id) throws ShopifyErrorException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Product createProduct(Product req) throws ShopifyErrorException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Product updateProduct(Product req) throws ShopifyErrorException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public void deleteProduct(long id) throws ShopifyErrorException {
    // TODO: impl 2021-01-12

  }
}
