package codemeans.shopify4j.admin.rest.model.common;

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

  private String name;
  private String value;
}