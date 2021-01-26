package codemeans.shopify4j.rest.admin;

import codemeans.shopify4j.rest.admin.api.discounts.DiscountCodeApi;
import codemeans.shopify4j.rest.admin.api.discounts.DiscountCodeCreationApi;
import codemeans.shopify4j.rest.admin.api.discounts.PriceRuleApi;
import codemeans.shopify4j.rest.admin.api.discounts.impl.DiscountCodeApiImpl;
import codemeans.shopify4j.rest.admin.api.discounts.impl.PriceRuleApiImpl;
import codemeans.shopify4j.rest.admin.api.orders.DraftOrderApi;
import codemeans.shopify4j.rest.admin.api.orders.OrderApi;
import codemeans.shopify4j.rest.admin.api.orders.impl.DraftOrderApiImpl;
import codemeans.shopify4j.rest.admin.api.orders.impl.OrderApiImpl;
import codemeans.shopify4j.rest.admin.api.products.CollectApi;
import codemeans.shopify4j.rest.admin.api.products.CollectionApi;
import codemeans.shopify4j.rest.admin.api.products.CustomCollectionApi;
import codemeans.shopify4j.rest.admin.api.products.ProductApi;
import codemeans.shopify4j.rest.admin.api.products.ProductImageApi;
import codemeans.shopify4j.rest.admin.api.products.ProductVariantApi;
import codemeans.shopify4j.rest.admin.api.products.SmartCollectionApi;
import codemeans.shopify4j.rest.admin.api.products.impl.CollectApiImpl;
import codemeans.shopify4j.rest.admin.api.products.impl.CollectionApiImpl;
import codemeans.shopify4j.rest.admin.api.products.impl.CustomCollectionApiImpl;
import codemeans.shopify4j.rest.admin.api.products.impl.ProductApiImpl;
import codemeans.shopify4j.rest.admin.api.products.impl.ProductImageApiImpl;
import codemeans.shopify4j.rest.admin.api.products.impl.ProductVariantApiImpl;
import codemeans.shopify4j.rest.admin.api.products.impl.SmartCollectionApiImpl;
import codemeans.shopify4j.rest.http.RestInvoker;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class DefaultRestStore implements RestStore {

  private final String myshopifyDomain;
  private final String apiVersion;
  private final RestInvoker invoker;
  private final String baseEndpoint;

  /*>>>>> discounts <<<<<*/
  private PriceRuleApi priceRuleApi;
  private DiscountCodeApi discountCodeApi;
  private DiscountCodeCreationApi discountCodeCreationApi;
  /*>>>>> products <<<<<*/
  private ProductApi productApi;
  private CollectApi collectApi;
  private CollectionApi collectionApi;
  private CustomCollectionApi customCollectionApi;
  private SmartCollectionApi smartCollectionApi;
  private ProductImageApi productImageApi;
  private ProductVariantApi productVariantApi;
  /*>>>>> orders <<<<<*/
  private DraftOrderApi draftOrderApi;
  private OrderApi orderApi;

  public DefaultRestStore(String myshopifyDomain, String apiVersion, RestInvoker invoker) {
    this.myshopifyDomain = myshopifyDomain;
    this.apiVersion = apiVersion;
    this.baseEndpoint = String.format("https://%s/admin/api/%s", myshopifyDomain, apiVersion);
    this.invoker = invoker;
    initApis();
  }

  private void initApis() {
    // discounts
    priceRuleApi = PriceRuleApiImpl.of(this);
    discountCodeApi = DiscountCodeApiImpl.of(this);
    // products
    productApi = ProductApiImpl.of(this);
    collectApi = CollectApiImpl.of(this);
    collectionApi = CollectionApiImpl.of(this);
    customCollectionApi = CustomCollectionApiImpl.of(this);
    smartCollectionApi = SmartCollectionApiImpl.of(this);
    productImageApi = ProductImageApiImpl.of(this);
    productVariantApi = ProductVariantApiImpl.of(this);
    // orders
    draftOrderApi = DraftOrderApiImpl.of(this);
    orderApi = OrderApiImpl.of(this);
  }

  @Override
  public String getMyshopifyDomain() {
    return myshopifyDomain;
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public String getBaseEndpoint() {
    return baseEndpoint;
  }

  @Override
  public RestInvoker getInvoker() {
    return invoker;
  }

  @Override
  public ProductApi products() {
    return productApi;
  }

  @Override
  public CollectApi collects() {
    return collectApi;
  }

  @Override
  public CollectionApi collections() {
    return collectionApi;
  }

  @Override
  public CustomCollectionApi customCollections() {
    return customCollectionApi;
  }

  @Override
  public SmartCollectionApi smartCollections() {
    return smartCollectionApi;
  }

  @Override
  public ProductImageApi productImages() {
    return productImageApi;
  }

  @Override
  public ProductVariantApi productVariants() {
    return productVariantApi;
  }

  @Override
  public DraftOrderApi draftOrders() {
    return draftOrderApi;
  }

  @Override
  public OrderApi orders() {
    return orderApi;
  }

  @Override
  public PriceRuleApi priceRules() {
    return priceRuleApi;
  }

  @Override
  public DiscountCodeApi discountCodes() {
    return discountCodeApi;
  }

  @Override
  public DiscountCodeCreationApi discountCodeCreations() {
    return discountCodeCreationApi;
  }
}
