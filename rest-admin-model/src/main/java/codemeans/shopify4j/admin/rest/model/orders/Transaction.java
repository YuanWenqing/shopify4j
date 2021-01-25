package codemeans.shopify4j.admin.rest.model.orders;

import codemeans.shopify4j.admin.rest.annotation.ReadOnly;
import codemeans.shopify4j.admin.rest.annotation.Required;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;
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
  private DateTime authorizationExpiresAt;
  @ReadOnly
  private DateTime createdAt;
  private String currency;
  @ReadOnly
  private String deviceId;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionErrorCode
   */
  @ReadOnly
  private String errorCode;
  private ExtendedAuthorizationAttributes extendedAuthorizationAttributes;
  private String gateway;
  @ReadOnly
  private Long id;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionKind
   */
  @Required
  private String kind;
  @ReadOnly
  private Long locationId;
  @ReadOnly
  private String message;
  private Long orderId;
  @ReadOnly
  private PaymentDetails paymentDetails;
  private Long parentId;
  private DateTime processedAt;
  @ReadOnly
  private Map<String, Object> receipt;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionSource
   */
  @ReadOnly
  private String sourceName;
  /**
   * @see codemeans.shopify4j.admin.rest.model.enums.TransactionStatus
   */
  private String status;
  private Boolean test;
  private Long userId;
  private CurrencyExchangeAdjustment currencyExchangeAdjustment;

}
