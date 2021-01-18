package codemeans.shopify4j.admin.rest.model.orders;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
@Data
@Accessors(chain = true)
@JsonRootName("transaction")
public class Transaction {

  private BigDecimal amount;
  private String authorization;
  @Setter(AccessLevel.NONE)
  private DateTime authorizationExpiresAt;
  @Setter(AccessLevel.NONE)
  private DateTime createdAt;
  private String currency;
  private String deviceId;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionErrorCode
   */
  @Setter(AccessLevel.NONE)
  private String errorCode;
  private ExtendedAuthorizationAttributes extendedAuthorizationAttributes;
  private String gateway;
  @Setter(AccessLevel.NONE)
  private Long id;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionKind
   */
  private String kind;
  @Setter(AccessLevel.NONE)
  private Long locationId;
  @Setter(AccessLevel.NONE)
  private String message;
  private Long orderId;
  private PaymentDetails paymentDetails;
  private Long parentId;
  @Setter(AccessLevel.NONE)
  private DateTime processedAt;
  @Setter(AccessLevel.NONE)
  private Map<String, Object> receipt;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionSource
   */
  @Setter(AccessLevel.NONE)
  private String sourceName;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionStatus
   */
  private String status;
  private Boolean test;
  private Long userId;
  private CurrencyExchangeAdjustment currencyExchangeAdjustment;

}
