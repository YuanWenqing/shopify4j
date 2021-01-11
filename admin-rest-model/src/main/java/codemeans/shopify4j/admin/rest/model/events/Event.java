package codemeans.shopify4j.admin.rest.model.events;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-11
 */
@Data
@Accessors(chain = true)
@JsonRootName("event")
public class Event {

  @Setter(AccessLevel.NONE)
  private List<String> arguments;
  private String body;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private Long id;
  private String path;
  private String message;
  private Long subjectId;
  private String subjectType;
  /**
   * see subclasses of {@link EventVerb}
   */
  private String verb;

}
