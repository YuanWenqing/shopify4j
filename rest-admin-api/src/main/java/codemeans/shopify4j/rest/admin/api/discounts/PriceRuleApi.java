package codemeans.shopify4j.rest.admin.api.discounts;

import codemeans.shopify4j.rest.admin.model.common.Count;
import codemeans.shopify4j.rest.admin.model.discounts.PriceRule;
import codemeans.shopify4j.rest.admin.model.discounts.PriceRuleList;
import codemeans.shopify4j.rest.http.HttpResponse;
import codemeans.shopify4j.rest.http.HttpResponseException;
import lombok.Data;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

/**
 * @author: yuanwq
 * @date: 2021-01-15
 */
public interface PriceRuleApi {

  HttpResponse<PriceRule> create(PriceRule priceRule) throws HttpResponseException;

  HttpResponse<PriceRule> update(long id, PriceRule priceRule) throws HttpResponseException;

  HttpResponse<String> delete(long id) throws HttpResponseException;

  HttpResponse<PriceRule> get(long id) throws HttpResponseException;

  HttpResponse<Count> count() throws HttpResponseException;

  HttpResponse<PriceRuleList> list(ListReq req) throws HttpResponseException;

  @Data
  @Accessors(chain = true)
  class ListReq {

    private Integer limit;
    private Long sinceId;
    private DateTime createdAtMin;
    private DateTime createdAtMax;
    private DateTime updatedAtMin;
    private DateTime updatedAtMax;
    private DateTime startsAtMin;
    private DateTime startsAtMax;
    private DateTime endsAtMin;
    private DateTime endsAtMax;
    private Integer timesUsed;
  }
}
