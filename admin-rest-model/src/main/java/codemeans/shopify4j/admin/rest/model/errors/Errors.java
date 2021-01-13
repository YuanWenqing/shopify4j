package codemeans.shopify4j.admin.rest.model.errors;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class Errors {

  private List<Error> errors = Lists.newArrayList();
}
