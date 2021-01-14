package codemeans.shopify4j.core.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: yuanwq
 * @date: 2021-01-14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryParameter {

  /**
   * name of query parameter
   */
  String name() default "";

  /**
   * separator used for joining values of {@link java.util.Collection}
   */
  String valueJoinWith() default ",";

  /**
   * whether ignore this annotated field
   */
  boolean ignore() default false;
}
