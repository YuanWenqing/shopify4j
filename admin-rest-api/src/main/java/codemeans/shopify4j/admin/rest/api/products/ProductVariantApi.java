package codemeans.shopify4j.admin.rest.api.products;

import codemeans.shopify4j.admin.rest.model.common.Count;
import codemeans.shopify4j.admin.rest.model.products.ProductVariant;
import codemeans.shopify4j.admin.rest.model.products.ProductVariantList;
import codemeans.shopify4j.core.exception.ShopifyServerException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface ProductVariantApi {

  ProductVariantList list(long productId, ProductVariantApi.ListReq req)
      throws ShopifyServerException;

  Count count(long productId) throws ShopifyServerException;

  ProductVariant get(long variantId) throws ShopifyServerException;

  ProductVariant create(long productId, ProductVariant req) throws ShopifyServerException;

  ProductVariant update(ProductVariant req) throws ShopifyServerException;

  void delete(long productId, long variantId) throws ShopifyServerException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private final List<String> presentmentCurrencies = new ArrayList<>();

    public ListReq addPresentmentCurrency(String presentmentCurrency) {
      this.presentmentCurrencies.add(presentmentCurrency);
      return this;
    }

    private Long sinceId;
    private final List<String> fields = new ArrayList<>();

    public ListReq addField(String field) {
      this.fields.add(field);
      return this;
    }

  }

}
