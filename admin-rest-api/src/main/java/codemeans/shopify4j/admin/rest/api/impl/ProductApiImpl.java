package codemeans.shopify4j.admin.rest.api.impl;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.req.ProductCountReq;
import codemeans.shopify4j.admin.rest.req.ProductListReq;
import codemeans.shopify4j.admin.rest.sdk.ShopifyStore;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.Invoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductApiImpl implements ProductApi {

  private final ShopifyStore store;
  private final Invoker invoker;

  public ProductApiImpl(ShopifyStore store) {
    this.store = store;
    this.invoker = store.getInvoker();
  }

  private String resourcesEndpoint() {
    return store.getBaseEndpoint() + "/products.json";
  }

  private String countEndpoint() {
    return store.getBaseEndpoint() + "/products/count.json";
  }

  private String singleEndpoint(long id) {
    return String.format("%s/products/%s.json", store.getBaseEndpoint(), id);
  }

  @Override
  public ProductList listProducts(ProductListReq req) throws ShopifyServerException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Count countProducts(ProductCountReq req) throws ShopifyServerException {
    return invoker.get(countEndpoint(), Count.class);
  }

  @Override
  public Product getProduct(long id) throws ShopifyServerException {
    return invoker.get(singleEndpoint(id), Product.class);
  }

  @Override
  public Product createProduct(Product req) throws ShopifyServerException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Product updateProduct(Product req) throws ShopifyServerException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public void deleteProduct(long id) throws ShopifyServerException {
    // TODO: impl 2021-01-12

  }
}
