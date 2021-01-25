package codemeans.shopify4j.rest.http;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Data;

/**
 * Generic Http Request
 *
 * @author: yuanwq
 * @date: 2021-01-13
 */
@Data
public class HttpRequest {

  private final String endpoint;
  private final Map<String, String> queries = new LinkedHashMap<>();
  private Object body;

  private HttpRequest(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public Map<String, String> getQueries() {
    return Collections.unmodifiableMap(queries);
  }

  public HttpRequest addQuery(String name, String value) {
    this.queries.put(name, value);
    return this;
  }

  public HttpRequest addQueries(Map<String, String> map) {
    map.forEach(this::addQuery);
    return this;
  }

  public HttpRequest setBody(Object body) {
    this.body = body;
    return this;
  }

  public Object getBody() {
    return body;
  }

  public static HttpRequest of(String endpoint) {
    return new HttpRequest(endpoint);
  }
}
