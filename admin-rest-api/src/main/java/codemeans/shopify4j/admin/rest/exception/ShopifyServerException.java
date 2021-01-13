package codemeans.shopify4j.admin.rest.exception;

import codemeans.shopify4j.admin.rest.model.errors.Error;
import codemeans.shopify4j.admin.rest.model.errors.Errors;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * shopify response with error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyServerException extends Exception {

  private final int statusCode;
  private final List<Error> errors = Lists.newArrayList();

  public ShopifyServerException(int statusCode, Errors errors) {
    this.statusCode = statusCode;
    this.errors.addAll(errors.getErrors());
  }
}