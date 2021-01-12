package codemeans.shopify4j.admin.rest.exception;

import codemeans.shopify4j.admin.rest.model.errors.ShopifyError;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * exception because of shopify error code
 *
 * @author: yuanwq
 * @date: 2021-01-12
 */
public class ShopifyErrorException extends Exception {

  private final List<ShopifyError> errors = Lists.newArrayList();


}
