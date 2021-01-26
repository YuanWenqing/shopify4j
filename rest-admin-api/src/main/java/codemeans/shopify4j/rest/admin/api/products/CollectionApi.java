package codemeans.shopify4j.rest.admin.api.products;

import codemeans.shopify4j.rest.admin.model.products.Collection;
import codemeans.shopify4j.rest.admin.model.products.ProductList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.RestApiException;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface CollectionApi {

  HttpResponse<Collection> get(long id) throws RestApiException;

  HttpResponse<ProductList> products(long id, Integer limit) throws RestApiException;

}
