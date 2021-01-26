package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.rest.admin.api.Pipeline;
import codemeans.shopify4j.rest.admin.api.discounts.DiscountCodeApi;
import codemeans.shopify4j.rest.admin.api.discounts.DiscountCodeCreationApi;
import codemeans.shopify4j.rest.admin.api.discounts.PriceRuleApi;
import codemeans.shopify4j.rest.admin.api.orders.DraftOrderApi;
import codemeans.shopify4j.rest.admin.api.orders.OrderApi;
import codemeans.shopify4j.rest.admin.api.products.CollectApi;
import codemeans.shopify4j.rest.admin.api.products.CollectionApi;
import codemeans.shopify4j.rest.admin.api.products.CustomCollectionApi;
import codemeans.shopify4j.rest.admin.api.products.ProductApi;
import codemeans.shopify4j.rest.admin.api.products.ProductImageApi;
import codemeans.shopify4j.rest.admin.api.products.ProductVariantApi;
import codemeans.shopify4j.rest.admin.api.products.SmartCollectionApi;
import codemeans.shopify4j.rest.exception.RestApiException;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public interface RestStore {

  String getMyshopifyDomain();

  String getApiVersion();

  /**
   * base endpoint:
   * <ul>
   * <li>specify domain and apiVersion</li>
   * <li>not ending with slash {@code /}</li>
   * </ul>
   */
  String getBaseEndpoint();

  RestInvoker getInvoker();

  default <R> R pipeline(Pipeline<RestStore, R> pipeline) throws RestApiException {
    return pipeline.runWith(this);
  }

  ProductApi products();

  CollectApi collects();

  CollectionApi collections();

  CustomCollectionApi customCollections();

  SmartCollectionApi smartCollections();

  ProductImageApi productImages();

  ProductVariantApi productVariants();

  DraftOrderApi draftOrders();

  OrderApi orders();

  PriceRuleApi priceRules();

  DiscountCodeApi discountCodes();

  DiscountCodeCreationApi discountCodeCreations();
}
