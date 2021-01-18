package codemeans.shopify4j.admin.rest.model.orders;

/**
 * @author: yuanwq
 * @date: 2021-01-18
 */
public enum TransactionErrorCode {
  incorrect_number,
  invalid_number,
  invalid_expiry_date,
  invalid_cvc,
  expired_card,
  incorrect_cvc,
  incorrect_zip,
  incorrect_address,
  card_declined,
  processing_error,
  call_issuer,
  pick_up_card,
}
