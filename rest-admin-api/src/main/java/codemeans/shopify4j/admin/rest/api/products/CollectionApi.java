package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.products.Collection;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import codemeans.shopify4j.core.http.HttpResponse;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectionApi {

  HttpResponse<Collection> get(long id) throws ShopifyServerException;

  HttpResponse<ProductList> products(long id, Integer limit) throws ShopifyServerException;

}
