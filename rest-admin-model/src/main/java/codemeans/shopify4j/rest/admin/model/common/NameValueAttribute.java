package codemeans.shopify4j.rest.admin.model.common;

import codemeans.shopify4j.rest.admin.annotation.Required;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class NameValueAttribute {

  @Required
  private String name;
  @Required
  private String value;
}