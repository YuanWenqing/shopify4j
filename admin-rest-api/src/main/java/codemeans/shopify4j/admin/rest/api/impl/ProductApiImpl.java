package codemeans.shopify4j.admin.rest.api.impl;

import codemeans.shopify4j.admin.rest.api.ProductApi;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.Invoker;
import codemeans.shopify4j.admin.rest.model.Count;
import codemeans.shopify4j.admin.rest.model.products.Product;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.admin.rest.req.ProductCountReq;
import codemeans.shopify4j.admin.rest.req.ProductListReq;
import okhttp3.HttpUrl;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ProductApiImpl implements ProductApi {

  private final Invoker invoker;

  private final HttpUrl resourcesEndpoint;
  private final HttpUrl countEndpoint;

  public ProductApiImpl( String baseEndpoint, Invoker invoker) {
    this.invoker = invoker;
    HttpUrl httpUrl = HttpUrl.parse(baseEndpoint);
    this.resourcesEndpoint = httpUrl.newBuilder().addPathSegment("products.json").build();
    this.countEndpoint = httpUrl.newBuilder().addEncodedPathSegment("count.json").build();
  }

  @Override
  public ProductList listProducts(ProductListReq req) throws ShopifyServerException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Count countProducts(ProductCountReq req) throws ShopifyServerException {
    // TODO: impl 2021-01-12
    return null;
  }

  @Override
  public Product getProduct(long id) throws ShopifyServerException {
    String url = String.format("%s/%s.json", resourcesEndpoint, id);

    // TODO: impl 2021-01-12
    return null;
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
