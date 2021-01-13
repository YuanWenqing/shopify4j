package codemeans.shopify4j.admin.rest.req;

import codemeans.shopify4j.admin.rest.model.products.ProductStatus;
import codemeans.shopify4j.admin.rest.model.products.PublishedStatus;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-12
 */
@Data
@Accessors(chain = true)
public class ProductListReq {

  private final List<Long> ids = Lists.newArrayList();
  private Integer limit;
  private Long sinceId;
  private String title;
  private String vendor;
  private String handle;
  private String productType;
  private ProductStatus status;
  private Long collectionId;
  private DateTime createdAtMin;
  private DateTime createdAtMax;
  private DateTime updatedAtMin;
  private DateTime updatedAtMax;
  private DateTime publishedAtMin;
  private DateTime publishedAtMax;
  private PublishedStatus publishedStatus;
  private List<String> fields = Lists.newArrayList();
  private List<String> presentmentCurrencies = Lists.newArrayList();

}
