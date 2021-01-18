package codemeans.shopify4j.admin.rest.internal;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public interface ShopifyEnum<T extends Enum<T>> {

  /**
   * valid value for shopify api, default is lowercase of name
   */
  @SuppressWarnings("unchecked")
  default String shopifyValue() {
    Enum<T> tEnum = (Enum<T>) this;
    return tEnum.name().toLowerCase();
  }

}
