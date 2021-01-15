package codemeans.shopify4j.admin.rest.model.products;

import com.fasterxml.jackson.annotation.JsonRootName;
import javax.swing.SortOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
@Data
@JsonRootName("collection")
public class Collection {

  private String bodyHtml;
  private String handle;
  private Image image;
  @Setter(AccessLevel.NONE)
  private Long id;
  @Setter(AccessLevel.NONE)
  private DateTime publishedAt;
  @Setter(AccessLevel.NONE)
  private PublishedScope publishedScope;
  private SortOrder sortOrder;
  private String templateSuffix;
  private String title;
  @Setter(AccessLevel.NONE)
  private DateTime updatedAt;

  @Data
  public static class Image {

    private String src;
    private String alt;
    private int width;
    private int height;
    private DateTime createdAt;
  }
}
