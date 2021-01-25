package codemeans.shopify4j.rest.admin.model.errors;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
public class Errors {

  private List<Error> errors = new ArrayList<>();
}
