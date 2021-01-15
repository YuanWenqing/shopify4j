package codemeans.shopify4j.admin.rest.api;

import codemeans.shopify4j.admin.rest.model.products.Collection;
import codemeans.shopify4j.admin.rest.model.products.ProductList;
import codemeans.shopify4j.core.exception.ShopifyServerException;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectionApi {

  Collection get(long id) throws ShopifyServerException;

  ProductList products(long id, Integer limit) throws ShopifyServerException;

}
